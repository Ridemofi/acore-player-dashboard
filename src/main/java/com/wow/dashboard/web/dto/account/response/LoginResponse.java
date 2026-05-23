package com.wow.dashboard.web.dto.account.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String username;
    private LocalDateTime lastLogin;
    private String lastIp;
    private Integer online;
    private Integer totalTime;
    private Byte locale;
    private String os;

    private String token;
    @Builder.Default
    private String tokenType = "Bearer";

}
