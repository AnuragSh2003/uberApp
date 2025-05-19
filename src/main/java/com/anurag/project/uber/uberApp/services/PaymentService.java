package com.anurag.project.uber.uberApp.services;

import com.anurag.project.uber.uberApp.entities.Payment;
import com.anurag.project.uber.uberApp.entities.Ride;

public interface PaymentService {
    void processPayment(Payment payment);

    Payment createNewPayment(Ride ride);
}
