package com.apiclasswork.API.ClassWork.controller;

import com.apiclasswork.API.ClassWork.dto.LoginRequest;
import com.apiclasswork.API.ClassWork.dto.SignUpRequest;
import com.apiclasswork.API.ClassWork.service.serviceimpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/api")
public class UserController {
    private UserServiceImpl userService;

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody SignUpRequest signUpRequest) {
        return new ResponseEntity<>(userService.registerUser(signUpRequest), HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<LoginRequest> login(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }

}
