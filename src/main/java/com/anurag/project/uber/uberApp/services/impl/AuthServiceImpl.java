package com.anurag.project.uber.uberApp.services.impl;

import com.anurag.project.uber.uberApp.dto.DriverDto;
import com.anurag.project.uber.uberApp.dto.SignUpDto;
import com.anurag.project.uber.uberApp.dto.UserDto;
import com.anurag.project.uber.uberApp.entities.Rider;
import com.anurag.project.uber.uberApp.entities.User;
import com.anurag.project.uber.uberApp.entities.enums.Role;
import com.anurag.project.uber.uberApp.exceptions.RuntimeConflictException;
import com.anurag.project.uber.uberApp.repositories.UserRepository;
import com.anurag.project.uber.uberApp.services.AuthService;
import com.anurag.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private  final ModelMapper modelMapper;
    private  final UserRepository userRepository;
    private  final RiderService riderService;
    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    public UserDto signup(SignUpDto signUpDto) {

        User user = userRepository.findByEmail(signUpDto.getEmail()).orElse(null);
        if (user != null)
            throw new RuntimeConflictException("cannot signup , this emailId is already signedUp "+signUpDto.getEmail());

        User mappeduser = modelMapper.map(signUpDto, User.class);
        mappeduser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappeduser);


        // create user related entities
        Rider rider = riderService.createNewRider(savedUser);


        return modelMapper.map(savedUser , UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
