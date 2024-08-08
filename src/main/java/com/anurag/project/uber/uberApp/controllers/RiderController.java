package com.anurag.project.uber.uberApp.controllers;

import com.anurag.project.uber.uberApp.dto.RideRequestDto;
import com.anurag.project.uber.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rider")
public class RiderController {

    private  final RiderService riderService;
    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDto> rideRequestDto(@RequestBody RideRequestDto rideRequestDto){
        return  ResponseEntity.ok(riderService.requestRide(rideRequestDto));
    }

}
