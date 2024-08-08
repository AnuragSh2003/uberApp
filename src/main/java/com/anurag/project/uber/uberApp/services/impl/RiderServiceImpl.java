package com.anurag.project.uber.uberApp.services.impl;

import com.anurag.project.uber.uberApp.dto.DriverDto;
import com.anurag.project.uber.uberApp.dto.RideDto;
import com.anurag.project.uber.uberApp.dto.RideRequestDto;
import com.anurag.project.uber.uberApp.entities.RideRequest;
import com.anurag.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.anurag.project.uber.uberApp.repositories.RideRequestRepository;
import com.anurag.project.uber.uberApp.services.RiderService;
import com.anurag.project.uber.uberApp.strategies.DriverMatchingStrategy;
import com.anurag.project.uber.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private  final ModelMapper modelMapper;
    private  final RideFareCalculationStrategy rideFareCalculationStrategy;
    private  final DriverMatchingStrategy driverMatchingStrategy;
    private  final RideRequestRepository rideRequestRepository;
    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

        RideRequest rideRequest = modelMapper.map(rideRequestDto , RideRequest.class);

        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        Double fare = rideFareCalculationStrategy.calculateFare(rideRequest);

        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        driverMatchingStrategy.findMatchingDriver(rideRequest);

        return modelMapper.map(savedRideRequest,RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RideDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return null;
    }
}
