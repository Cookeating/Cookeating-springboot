package com.tistory.cookeat.cookeating.dto;

import com.tistory.cookeat.cookeating.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDTO {

    @NotEmpty(message = "ID는 필수 입니다.")
    @Size(min = 4, max = 20, message = "ID는 4~20자 사이로 입력해주세요.")
    private String loginId;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    @Size(min = 4, max = 20, message = "비밀번호는 4~20자 사이로 입력해주세요.")
    private String password;

    public User toEntity() {
        return User.builder().
                loginId(this.loginId).
                password(this.password)
                .build();
    }
}
