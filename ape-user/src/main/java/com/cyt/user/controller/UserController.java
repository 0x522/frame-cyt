package com.cyt.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/getHello")
    public String getCall() {
        return "hello world";
    }
}
