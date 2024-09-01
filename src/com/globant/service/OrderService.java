package com.globant.service;

import com.globant.model.orders.OrderModel;
import com.globant.model.transaction.TransactionModel;
import com.globant.model.transaction.TransactionService;
import com.globant.model.user.User;
import com.globant.model.user.UserModel;
import com.globant.model.wallet.WalletService;

import java.util.Random;

public class OrderService {
    private final OrderModel model;
    private final Random rand  = new Random();
    private final TransactionService transactionService;
    private final WalletService walletService;
    public OrderService() {
        model = new OrderModel();
        walletService = new WalletService();
        transactionService = new TransactionService();
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


    public void addBitCoin(User user, double price, double amount){
        walletService.setBitCoinAmount(user.getWallet(), amount);
    }

    public void addEthereum(User user, double price, double amount){
        walletService.setEthereumAmount(user.getWallet(), amount);
    }
}
