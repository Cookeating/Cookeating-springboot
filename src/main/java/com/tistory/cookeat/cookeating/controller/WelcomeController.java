package com.tistory.cookeat.cookeating.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "index";
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    }
}
