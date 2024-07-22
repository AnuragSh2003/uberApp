package com.anurag.project.uber.uberApp.strategies;

import com.anurag.project.uber.uberApp.dto.RideRequestDto;

public interface RideFareCalculationStrategy {
    double calculateFare(RideRequestDto rideRequestDto);
}
