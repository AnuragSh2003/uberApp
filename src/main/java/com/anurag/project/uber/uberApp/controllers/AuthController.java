package com.anurag.project.uber.uberApp.controllers;


import com.anurag.project.uber.uberApp.dto.SignUpDto;
import com.anurag.project.uber.uberApp.dto.UserDto;
import com.anurag.project.uber.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private  final AuthService authService;

    @PostMapping("/signup")
    UserDto signUp(@RequestBody SignUpDto signUpDto){
        return authService.signup(signUpDto);
    }
}
