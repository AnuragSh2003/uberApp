package com.anurag.project.uber.uberApp.strategies.Impl;

import com.anurag.project.uber.uberApp.entities.Driver;
import com.anurag.project.uber.uberApp.entities.RideRequest;
import com.anurag.project.uber.uberApp.strategies.DriverMatchingStrategy;

import java.util.List;

public class DriverMatchingHighestRateDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return List.of();
    }
}
