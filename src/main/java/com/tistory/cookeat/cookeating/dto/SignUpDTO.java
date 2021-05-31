package com.tistory.cookeat.cookeating.dto;

import com.tistory.cookeat.cookeating.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SignUpDTO {

    @NotEmpty(message = "ID는 필수 입니다.")
    @Size(max = 20, message = "ID는 20자리를 초과할 수 없습니다.")
    private String loginId;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    @Size(max = 20, message = "비밀번호는 20자리를 초과할 수 없습니다.")
    private String password;

    public User toEntity() {
        return User.builder().
                loginId(loginId).
                password(password)
                .build();
    }
}
