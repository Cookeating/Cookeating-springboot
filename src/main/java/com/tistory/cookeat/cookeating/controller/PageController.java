package com.tistory.cookeat.cookeating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String welcome() {
        return "main";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "user/signUp";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "main";
    }
}
