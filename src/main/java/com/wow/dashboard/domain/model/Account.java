package com.wow.dashboard.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "account", catalog = "acore_auth")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Account {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "salt")
    private byte[] salt;

    @Column(name = "verifier")
    private byte[] verifier;

}
