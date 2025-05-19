package com.anurag.project.uber.uberApp.services;

import com.anurag.project.uber.uberApp.entities.User;
import com.anurag.project.uber.uberApp.entities.Wallet;

public interface WalletService {
    Wallet addMoneyToWallet(User user , Double amount);

    Wallet deductMoneyFromWallet(User user , Double amount);

    void withDrawAllMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

    Wallet findByUser(User user);
}
