package com.globant.service;

import com.globant.model.orders.OrderModel;
import com.globant.model.user.User;
import com.globant.model.user.UserModel;
import java.util.Random;

public class OrderService {
    private final OrderModel model;
    private final UserModel user;
    private final Random rand  = new Random();
    private java.lang.Exception Exception;

    public OrderService() {
        user = new UserModel();
        model = new OrderModel();
    }

    public void placeSellOrder(String[] data, User user) throws Exception {
        int orderId = rand.nextInt(Integer.MAX_VALUE) + 1;
        int userId = user.getUserId();
        String cryptoName = data[0];
        double amount = Double.parseDouble(data[1]);
        double price = Double.parseDouble(data[2]);

        if(cryptoName.equals("BitCoin") && user.getBitCoinCurrency() > amount) {
                model.setSellOrder(orderId, userId, cryptoName, amount, price);
        }else{
            if(cryptoName.equals("Ethereum") && user.getEthereumCurrency() > amount){
                model.setSellOrder(orderId, userId, cryptoName, amount, price);
            }
            else{
                throw new Exception("Error");
            }
        }

    }
}
