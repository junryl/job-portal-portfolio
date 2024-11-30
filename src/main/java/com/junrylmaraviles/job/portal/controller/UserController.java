package com.junrylmaraviles.job.portal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")

public class UserController {

    @PostMapping("/testUser")
    public ResponseEntity<String> sampleUserController() {
        return ResponseEntity.ok("Hello from User Controller!");
    }
}