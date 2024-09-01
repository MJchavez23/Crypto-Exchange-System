package com.globant.service;

import com.globant.model.cryptoCurrency.CryptoCurrency;
import com.globant.model.orders.OrderModel;
import com.globant.model.transaction.TransactionService;
import com.globant.model.user.User;
import com.globant.model.wallet.Wallet;
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

    public void placeSellOrder(String[] data, User user, CryptoCurrency crypto, Wallet userWallet) throws Exception {
        int orderId = rand.nextInt(Integer.MAX_VALUE) + 1;
        int userId = user.getUserId();
        String cryptoName = data[0];
        double amount = Double.parseDouble(data[1]);
        double price = Double.parseDouble(data[2]);

        if(cryptoName.equals("BitCoin") && user.getBitCoinBalance() > amount && price > crypto.getPrice()) {
                walletService.deductBitCoinAmount(userWallet, amount);
                model.setSellOrder(orderId, userId, cryptoName, amount, price);
                transactionService.saveTransaction(user, cryptoName, amount, price, 0);
        }else{
            if(cryptoName.equals("Ethereum") && user.getEthereumBalance() > amount && price > crypto.getPrice()){
                walletService.deductEthereumAmount(userWallet, amount);
                model.setSellOrder(orderId, userId, cryptoName, amount, price);
                transactionService.saveTransaction(user, cryptoName, amount, price, 0);
            }
            else{
                throw new Exception("Error");
            }
        }
    }


    public void addBitCoin(User user, double price, double amount){
        walletService.addBitCoinAmount(user.getWallet(), amount);
    }

    public void addEthereum(User user, double price, double amount){
        walletService.addEthereumAmount(user.getWallet(), amount);
    }
}
