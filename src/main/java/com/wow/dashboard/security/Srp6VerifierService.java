package com.wow.dashboard.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

@Service
public class Srp6VerifierService {

    private final String nHex;
    private final int g;

    public Srp6VerifierService(@Value("${acore.security.srp6.n-hex}") String nHex,
                               @Value("${acore.security.srp6.g:7}") int g) {
        this.nHex = nHex;
        this.g = g;
    }

    public boolean verify(String username, String rawPassword, byte[] salt, byte[] verifier) {
        if (salt == null || verifier == null) {
            return false;
        }
        if (nHex == null || nHex.isBlank()) {
            throw new IllegalStateException("Falta acore.security.srp6.n-hex con el valor SRP6_N");
        }
        String userUpper = username.toUpperCase(Locale.ROOT);
        String passUpper = rawPassword.toUpperCase(Locale.ROOT);

        byte[] userPassHash = sha1((userUpper + ":" + passUpper).getBytes(StandardCharsets.UTF_8));
        byte[] xHash = sha1(concat(salt, userPassHash));
        BigInteger x = new BigInteger(1, reverseBytes(xHash));

        BigInteger n = new BigInteger(nHex, 16);
        BigInteger gVal = BigInteger.valueOf(g);
        BigInteger v = gVal.modPow(x, n);

        byte[] computed = reverseBytes(toFixedLength(v, verifier.length));
        return constantTimeEquals(computed, verifier);
    }

    private static byte[] sha1(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            return md.digest(data);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    private static byte[] concat(byte[] left, byte[] right) {
        byte[] out = new byte[left.length + right.length];
        System.arraycopy(left, 0, out, 0, left.length);
        System.arraycopy(right, 0, out, left.length, right.length);
        return out;
    }

    private static byte[] toFixedLength(BigInteger value, int length) {
        byte[] raw = value.toByteArray();
        if (raw.length == length) {
            return raw;
        }
        int srcPos = Math.max(0, raw.length - length);
        int copyLen = Math.min(raw.length, length);
        byte[] out = new byte[length];
        System.arraycopy(raw, srcPos, out, length - copyLen, copyLen);
        return out;
    }

    private static byte[] reverseBytes(byte[] input) {
        byte[] out = new byte[input.length];
        for (int i = 0; i < input.length; i++) {
            out[i] = input[input.length - 1 - i];
        }
        return out;
    }

    private static boolean constantTimeEquals(byte[] left, byte[] right) {
        if (left == null || right == null || left.length != right.length) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < left.length; i++) {
            result |= left[i] ^ right[i];
        }
        return result == 0;
    }
}
