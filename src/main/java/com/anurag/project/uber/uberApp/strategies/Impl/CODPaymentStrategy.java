package com.anurag.project.uber.uberApp.strategies.Impl;

import com.anurag.project.uber.uberApp.entities.Driver;
import com.anurag.project.uber.uberApp.entities.Payment;
import com.anurag.project.uber.uberApp.entities.Wallet;
import com.anurag.project.uber.uberApp.services.WalletService;
import com.anurag.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CODPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    @Override
    public void processPayment(Payment payment) {

        Driver driver = payment.getRide().getDriver();

        Wallet driverWallet = walletService.findByUser(driver.getUser());
        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(),platformCommission);
    }
}
