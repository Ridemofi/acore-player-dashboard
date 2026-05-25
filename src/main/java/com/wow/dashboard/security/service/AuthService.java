package com.wow.dashboard.security.service;

import com.wow.dashboard.domain.model.Account;
import com.wow.dashboard.domain.repository.AccountRepository;
import com.wow.dashboard.security.jwt.JwtTokenProvider;
import com.wow.dashboard.security.Srp6VerifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountRepository accountRepository;
    private final Srp6VerifierService srp6VerifierService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthResult login(String username, String password) {
        Account account = accountRepository.findByUsername(username.toUpperCase())
                .orElseThrow(() -> new BadCredentialsException("Credenciales invalidas"));

        boolean ok = srp6VerifierService.verify(account.getUsername(), password, account.getSalt(), account.getVerifier());
        if (!ok) {
            throw new BadCredentialsException("Credenciales invalidas");
        }
        String token = jwtTokenProvider.generateToken(account.getUsername(), account.getId());
        return new AuthResult(account, token);
    }

    public record AuthResult(Account account, String token) {
        public AuthResult {
            Objects.requireNonNull(account, "account");
            Objects.requireNonNull(token, "token");
        }
    }
}
