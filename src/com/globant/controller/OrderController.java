package com.globant.controller;

import com.globant.model.cryptoCurrency.BitCoin;
import com.globant.model.cryptoCurrency.Ethereum;
import com.globant.model.user.User;
import com.globant.service.OrderService;
import com.globant.service.UserService;
import com.globant.view.ConsoleView;

import java.util.Objects;

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
        String crypto = "";
        double amount = 0;
        try{
            crypto = data[0];
            amount = Double.parseDouble(data[1]);
        }catch (Exception e){

        }
        int result = orderService.buyExachange(crypto, amount, bitCoin, ethereum, user);
        if(result == 1){
            view.showSuccess("Buy Exchange Success");
        }
        if(result == 0){
            view.showError("Sorry, a error has occurred");
        }
    }

    public void placeBuyOrder(User user, double bitCoinPrice, double ethereumPrice) {
        String[] data = view.placeBuyOrderPage(bitCoinPrice, ethereumPrice);
        int result = orderService.placeBuyOrder(data, user);
        if(result == 1){
            view.showSuccess("Congratulations! A matching sell order has been found for your buy order. The transaction has been processed successfully");
        }
        if(result == 0){
            view.showError("Sorry, no matching sell order was found for your buy order at this time. Please try again later or adjust your order criteria");
        }
    }


     public void placeSellOrder(BitCoin bitCoin, Ethereum ethereum, User user){
        String[] data = view.placeSellOrderPage(bitCoin.getPrice(), ethereum.getPrice());
        if(Objects.equals(data[0], "BitCoin")){
            try{
                int result = orderService.placeSellOrder(data, user, bitCoin);
                if(result == 1){
                    view.showSuccess("Place sell order successful");
                }else{
                    view.showError("Place Sell Order Error");
                }
            }catch(Exception e){
                view.showError("Place Sell Order Error");
            }
        }
        if(Objects.equals(data[0], "Ethereum")){
            try{
                orderService.placeSellOrder(data, user, ethereum);
                view.showSuccess("Place sell order successful");
            }catch(Exception e){
                view.showError("Place Sell Order Error");
            }
        }

     }


}
