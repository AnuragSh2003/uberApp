package com.anurag.project.uber.uberApp.services.impl;

import com.anurag.project.uber.uberApp.dto.WalletTransactionDto;
import com.anurag.project.uber.uberApp.entities.WalletTransaction;
import com.anurag.project.uber.uberApp.repositories.WalletRepository;
import com.anurag.project.uber.uberApp.repositories.WalletTransactionRepository;
import com.anurag.project.uber.uberApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService {

    private final WalletRepository walletRepository;
    private final ModelMapper modelMapper;
    private final WalletTransactionRepository walletTransactionRepository;

    @Override
    public void createNewWalletTransaction(WalletTransaction walletTransaction) {

        modelMapper.map(walletTransaction,WalletTransaction.class);
        walletTransactionRepository.save(walletTransaction);
    }
}
