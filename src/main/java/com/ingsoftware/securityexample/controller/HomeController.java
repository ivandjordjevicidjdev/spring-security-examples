package com.ingsoftware.securityexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/user")
    public String welcomeFromUserRoute() {
        return "Welcome from user route";
    }

    @GetMapping("/admin")
    public String welcomeFromAdminRoute() {
        return "Welcome from admin route";
    }

}
