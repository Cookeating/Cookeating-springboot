package com.tistory.cookeat.cookeating.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Builder
    public User(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
