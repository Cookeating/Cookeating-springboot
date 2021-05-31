package com.tistory.cookeat.cookeating.controller;

import com.tistory.cookeat.cookeating.dto.SignUpDTO;
import com.tistory.cookeat.cookeating.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(SignUpDTO signUpDTO) throws Exception {
        userService.signUp(signUpDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
