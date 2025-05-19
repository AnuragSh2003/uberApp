package com.anurag.project.uber.uberApp.dto;

import com.anurag.project.uber.uberApp.entities.Ride;
import com.anurag.project.uber.uberApp.entities.Wallet;
import com.anurag.project.uber.uberApp.entities.enums.TransactionMethod;
import com.anurag.project.uber.uberApp.entities.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WalletTransactionDto {


    private  Long id;
    private  Double amount;
    private TransactionType transactionType;
    private TransactionMethod transactionMethod;
    private RideDto ride;
    private String transactionId;
    private WalletDto wallet;
    private LocalDateTime timeStamp;
}
