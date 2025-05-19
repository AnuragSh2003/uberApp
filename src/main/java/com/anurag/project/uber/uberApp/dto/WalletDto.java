package com.anurag.project.uber.uberApp.dto;

import com.anurag.project.uber.uberApp.entities.User;
import com.anurag.project.uber.uberApp.entities.WalletTransaction;
import lombok.Data;

import java.util.List;
@Data
public class WalletDto {

    private  Long id;
    private UserDto user;
    private Double balance;
    private List<WalletTransactionDto> transactions;
}
