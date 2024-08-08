package com.anurag.project.uber.uberApp.strategies;

import com.anurag.project.uber.uberApp.dto.RideRequestDto;
import com.anurag.project.uber.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;
    double calculateFare(RideRequest rideRequest);
}
