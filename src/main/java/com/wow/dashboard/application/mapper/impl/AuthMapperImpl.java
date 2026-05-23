package com.wow.dashboard.application.mapper.impl;

import com.wow.dashboard.application.mapper.AuthMapper;
import com.wow.dashboard.domain.model.Account;
import com.wow.dashboard.web.dto.account.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthMapperImpl implements AuthMapper {

    @Override
    public LoginResponse toLoginResponse(Account account, String token) {
        return LoginResponse.builder()
                .username(account.getUsername())
                .token(token)
                .build();
    }
}
