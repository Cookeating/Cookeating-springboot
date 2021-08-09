package com.tistory.cookeat.cookeating.controller;

import com.tistory.cookeat.cookeating.dto.SignUpDTO;
import com.tistory.cookeat.cookeating.dto.UserResponse;
import com.tistory.cookeat.cookeating.exception.DuplicateLoginIdException;
import com.tistory.cookeat.cookeating.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignUpDTO signUpDTO) throws Exception {
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
