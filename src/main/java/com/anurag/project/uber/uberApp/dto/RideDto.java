package com.anurag.project.uber.uberApp.dto;

import com.anurag.project.uber.uberApp.entities.Driver;
import com.anurag.project.uber.uberApp.entities.Rider;
import com.anurag.project.uber.uberApp.entities.enums.PaymentMethod;
import com.anurag.project.uber.uberApp.entities.enums.RideStatus;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class RideDto {


    private  Long id;
    private Point pickupLocation;
    private  Point dropOfLocation;
    private LocalDateTime createdTime;
    private RideDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;
    private RideStatus rideStatus;

    private String opt;
    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
