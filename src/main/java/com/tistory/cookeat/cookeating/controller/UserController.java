package com.tistory.cookeat.cookeating.controller;

import com.tistory.cookeat.cookeating.domain.user.User;
import com.tistory.cookeat.cookeating.dto.LoginDTO;
import com.tistory.cookeat.cookeating.dto.SignUpDTO;
import com.tistory.cookeat.cookeating.dto.UserResponse;
import com.tistory.cookeat.cookeating.exception.DuplicateLoginIdException;
import com.tistory.cookeat.cookeating.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginDTO, HttpSession session) throws Exception {
        log.info("LoginUpDTO : {}", loginDTO);
        User loginUser = userService.login(loginDTO);
        if (loginUser != null) {
            session.setAttribute("user", loginUser);
            return ResponseEntity.ok(new UserResponse(loginUser));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("아이디와 비밀번호를 확인해주세요.");
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserResponse> signUp(@RequestBody @Valid SignUpDTO signUpDTO) throws Exception {
        log.info("SignUpDTO : {}", signUpDTO);
        return ResponseEntity.ok(new UserResponse(userService.signUp(signUpDTO)));
    }

    @ExceptionHandler(value = DuplicateLoginIdException.class)
    public ResponseEntity duplicateLoginId() {

        List<String> errorList = new ArrayList<>();
        errorList.add("loginId");
        errorList.add("이미 존재하는 아이디입니다.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }

}
