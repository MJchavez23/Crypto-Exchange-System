package com.globant.model.transaction;

import com.globant.model.user.User;

public class TransactionService {
    private TransactionModel model;

    public TransactionService() {
        this.model = new TransactionModel();
    }

    public void saveSellTransaction(User user, String cryptoName, double amount, double price, int isBuying){
        int sellerId = user.getUserId();
        model.saveSellTransaction(sellerId, cryptoName, amount, price, isBuying);
    }
}
