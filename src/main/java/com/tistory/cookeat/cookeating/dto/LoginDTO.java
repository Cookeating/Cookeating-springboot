package com.tistory.cookeat.cookeating.dto;

import com.tistory.cookeat.cookeating.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    private String loginId;
    private String password;

    public User toEntity() {
        return User.builder().
                loginId(this.loginId).
                password(this.password)
                .build();
    }
}
