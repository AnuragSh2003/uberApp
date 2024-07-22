package com.anurag.project.uber.uberApp.services;

// we make this interface separated because to make our project loss coupling (so that we can use it in another stratergy pattern)

import com.anurag.project.uber.uberApp.dto.DriverDto;
import com.anurag.project.uber.uberApp.dto.SignUpDto;
import com.anurag.project.uber.uberApp.dto.UserDto;

public interface AuthService {
    String  login(String email, String password);

    UserDto signup(SignUpDto signUpDto);

    DriverDto onboardNewDriver(Long userId);

}
