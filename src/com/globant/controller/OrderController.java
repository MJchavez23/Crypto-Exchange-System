package com.globant.controller;

import com.globant.model.cryptoCurrency.BitCoin;
import com.globant.model.cryptoCurrency.Ethereum;
import com.globant.model.user.User;
import com.globant.service.OrderService;
import com.globant.service.UserService;
import com.globant.view.ConsoleView;

public class OrderController {

    private final ConsoleView view;
    private final OrderService orderService;
    private final UserService userService;
    public OrderController(OrderService orderService, ConsoleView view) {
        userService = new UserService();
        this.orderService = orderService;
        this.view = view;
    }

    public void buyExchange(User user, BitCoin bitCoin, Ethereum ethereum){
        String[] data = view.buyExchange();
        String crypto = data[0];
        double amount = Double.parseDouble(data[1]);
        if (crypto.equals(bitCoin.getName())){
            double price = bitCoin.getPrice() * amount;
            if (user.getWalletBalance() > price){
                userService.balanceDeduct(user, price);
                orderService.addBitCoin(user, price, amount);
                view.showSuccess("Sell order successful");
            }
        }
        if (crypto.equals(ethereum.getName())){
            double price = ethereum.getPrice() * amount;
            if (user.getWalletBalance() > price){
                userService.balanceDeduct(user, price);
                orderService.addEthereum(user, price, amount);
                view.showSuccess("Sell order successful");
            }
        }
    }

}
