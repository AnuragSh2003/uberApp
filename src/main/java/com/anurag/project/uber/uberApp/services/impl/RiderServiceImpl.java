package com.anurag.project.uber.uberApp.services.impl;

import com.anurag.project.uber.uberApp.dto.DriverDto;
import com.anurag.project.uber.uberApp.dto.RideDto;
import com.anurag.project.uber.uberApp.dto.RideRequestDto;
import com.anurag.project.uber.uberApp.entities.Driver;
import com.anurag.project.uber.uberApp.entities.RideRequest;
import com.anurag.project.uber.uberApp.entities.Rider;
import com.anurag.project.uber.uberApp.entities.User;
import com.anurag.project.uber.uberApp.entities.enums.RideRequestStatus;
import com.anurag.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.anurag.project.uber.uberApp.repositories.RideRequestRepository;
import com.anurag.project.uber.uberApp.repositories.RiderRepository;
import com.anurag.project.uber.uberApp.services.RiderService;
import com.anurag.project.uber.uberApp.strategies.RideStrategyManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private  final ModelMapper modelMapper;
    private  final RideStrategyManager rideStrategyManager;
    private  final RideRequestRepository rideRequestRepository;
    private  final RiderRepository riderRepository;
    @Override
    @Transactional // either every thing is saved or nothing is saved.
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {

        Rider rider = getCurrentRider();
        RideRequest rideRequest = modelMapper.map(rideRequestDto , RideRequest.class);

        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);

        Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);

        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

        List<Driver> drivers = rideStrategyManager
                .driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest);
        // TODO : send notifications to all the drivers to about this ride request

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

    @Override
    public Rider createNewRider(User user) {

        Rider rider =  Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();

        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        // TODO : implement Spring security
        return riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException(
                "Rider not found with id : "+1
        ));
    }
}
