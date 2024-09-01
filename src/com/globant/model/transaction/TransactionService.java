package com.globant.model.transaction;

import com.globant.model.user.User;

public class TransactionService {
    private TransactionModel model;

    public TransactionService() {
        this.model = new TransactionModel();
    }

    public void saveTransaction(User user, String cryptoName, double amount, double price, int isBuying){
        int sellerId = user.getUserId();
        model.saveTransaction(sellerId, cryptoName, amount, price, isBuying);
    }


    public String[] getUserTransaction(User user){
        int userId = user.getUserId();
        return model.userTransactions(userId);
    }
}
