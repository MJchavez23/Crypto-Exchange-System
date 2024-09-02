package com.globant.controller;

import com.globant.service.TransactionService;
import com.globant.model.user.User;
import com.globant.view.ConsoleView;

public class TransactionController {

    private final TransactionService transactionService;
    private final ConsoleView view;

    public TransactionController(TransactionService transactionService, ConsoleView view) {
        this.transactionService = transactionService;
        this.view = view;
    }

    public void showUserTransactions(User user) {
        String[] transactions = transactionService.getUserTransaction(user);
        for(String transaction : transactions) {
            String[] parts = transaction.split(",");
            view.showTransaction(parts[1], parts[2], parts[3], parts[4]);
        }
    }
}
