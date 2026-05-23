package com.wow.dashboard.application.mapper;

import com.wow.dashboard.domain.model.Account;
import com.wow.dashboard.web.dto.account.response.LoginResponse;

public interface AuthMapper {
    LoginResponse toLoginResponse(Account account, String token);
}
