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
    @Column(name = "id", columnDefinition = "int unsigned")
    private Long id;

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

    @Column(name = "online", columnDefinition = "int unsigned")
    private Long online;

    @Column(name = "totaltime", columnDefinition = "int unsigned")
    private Long totalTime;

    @Column(name = "locale", columnDefinition = "tinyint unsigned")
    private Byte locale;

    @Column(name = "os")
    private String os;

}