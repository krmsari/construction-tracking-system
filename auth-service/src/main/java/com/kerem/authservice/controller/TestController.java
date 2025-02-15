package com.kerem.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/run")
    public String test() {
        return "Test";
    }

    @GetMapping("/error")
    public String error() {
        return "Error";
    }
}
