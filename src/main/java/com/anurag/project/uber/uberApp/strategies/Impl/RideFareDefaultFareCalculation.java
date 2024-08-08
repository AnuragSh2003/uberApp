package com.anurag.project.uber.uberApp.strategies.Impl;

import com.anurag.project.uber.uberApp.entities.RideRequest;
import com.anurag.project.uber.uberApp.strategies.RideFareCalculationStrategy;

public class RideFareDefaultFareCalculation implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
