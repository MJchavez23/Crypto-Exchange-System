package com.globant;

import com.globant.controller.RootController;
import com.globant.service.TransactionService;
import com.globant.service.OrderService;
import com.globant.service.UserService;
import com.globant.view.ConsoleView;

public class CryptoExchangeSystem {
    public static void main(String[] args) {
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        TransactionService transactionService = new TransactionService();
        ConsoleView consoleView = new ConsoleView();
        RootController rootController = new RootController(userService, orderService, transactionService, consoleView);
        rootController.run();
        consoleView.close();
    }
}
