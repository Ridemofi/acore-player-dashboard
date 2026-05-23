package com.wow.dashboard.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "account", catalog = "acore_auth")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Account {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "salt", columnDefinition = "BINARY(32)")
    private byte[] salt;

    @Column(name = "verifier", columnDefinition = "BINARY(32)")
    private byte[] verifier;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "last_ip")
    private String lastIp;

    @Column(name = "online")
    private Integer online;

    @Column(name = "totaltime")
    private Integer totalTime;

    @Column(name = "locale")
    private Byte locale;

    @Column(name = "os")
    private String os;

}
