package com.anurag.project.uber.uberApp.strategies.Impl;

import com.anurag.project.uber.uberApp.dto.RideRequestDto;
import com.anurag.project.uber.uberApp.strategies.RideFareCalculationStrategy;

public class RideFareDefaultFareCalculation implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
