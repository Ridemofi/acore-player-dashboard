package com.wow.dashboard.web.controller;

import com.wow.dashboard.application.mapper.AuthMapper;
import com.wow.dashboard.security.service.AuthService;
import com.wow.dashboard.web.dto.account.request.LoginRequest;
import com.wow.dashboard.web.dto.account.response.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthMapper authMapper;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        AuthService.AuthResult result = authService.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(authMapper.toLoginResponse(result.account(), result.token()));
    }
}
