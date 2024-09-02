package com.globant.service;

import com.globant.model.cryptoCurrency.BitCoin;
import com.globant.model.cryptoCurrency.CryptoCurrency;
import com.globant.model.cryptoCurrency.Ethereum;
import com.globant.model.orders.OrderModel;
import com.globant.model.user.User;

import java.util.Random;

public class OrderService {
    private final OrderModel model;
    private final Random rand  = new Random();
    private final TransactionService transactionService;
    private final WalletService walletService;
    private final UserService userService;
    public OrderService() {
        model = new OrderModel();
        walletService = new WalletService();
        transactionService = new TransactionService();
        userService = new UserService();
    }

    public int placeSellOrder(String[] data, User user, CryptoCurrency crypto) throws Exception {
        try{

            int orderId = rand.nextInt(Integer.MAX_VALUE) + 1;
            int userId = user.getUserId();
            String cryptoName = data[0];
            double amount = Double.parseDouble(data[1]);
            double price = Double.parseDouble(data[2]);

            if(cryptoName.equals("BitCoin") && user.getBitCoinBalance() >= amount && price > crypto.getPrice()) {
                    walletService.deductBitCoinAmount(user.getWallet(), amount);
                    model.setSellOrder(orderId, userId, cryptoName, amount, price);
                    transactionService.saveTransaction(user, cryptoName, amount, price, 0);
                    return 1;
            }else{
                if(cryptoName.equals("Ethereum") && user.getEthereumBalance() >= amount && price > crypto.getPrice()){
                    walletService.deductEthereumAmount(user.getWallet(), amount);
                    model.setSellOrder(orderId, userId, cryptoName, amount, price);
                    transactionService.saveTransaction(user, cryptoName, amount, price, 0);
                    return 1;
                }
                else{
                    throw new Exception("Error");
                }
            }
        }catch (Exception e){
            return 0;
        }
    }

    public int placeBuyOrder(String[] data, User user){
        String currencyName = data[0];
        double amount;
        double price;
        try{
            amount = Double.parseDouble(data[1]);
            price = Double.parseDouble(data[2]);
        }catch(Exception e){
            return 0;
        }
        String[] buyData = model.getSellOrder(user.getUserId(), currencyName, amount, price);
        if (buyData != null) {
            double buyAmount;
            double buyPrice;
            int sellerId;
            try{
                buyAmount = Double.parseDouble(buyData[3]);
                buyPrice = Double.parseDouble(buyData[4]);
                sellerId = Integer.parseInt(buyData[1]);
            }catch (Exception e){
                return 0;
            }
            user.deductFiat(buyPrice);
            if (currencyName.equals("BitCoin")) {
                addBitCoin(user, buyAmount);
                model.completeOrder(sellerId, buyPrice);
                transactionService.saveTransaction(user, currencyName, buyAmount, buyPrice, 1);
                return 1;
            }
            if (currencyName.equals("Ethereum")) {
                addEthereum(user, buyAmount);
                model.completeOrder(sellerId, buyPrice);
                transactionService.saveTransaction(user, currencyName, buyAmount, buyPrice, 1);
                return 1;
            }


            return 0;
        }
        return 0;
    }


    public int buyExachange(String crypto, double amount, BitCoin bitCoin, Ethereum ethereum, User user){
        try{

            if (crypto.equals(bitCoin.getName())){
                double price = bitCoin.getPrice() * amount;
                if (user.getWalletBalance() > price){
                    userService.balanceDeduct(user, price);
                    addBitCoin(user, amount);
                    return 1;
                }
            }
            if (crypto.equals(ethereum.getName())){
                double price = ethereum.getPrice() * amount;
                if (user.getWalletBalance() > price){
                    userService.balanceDeduct(user, price);
                    addEthereum(user, amount);
                    return 1;
                }
            }
        }catch (Exception e){
            return 0;
        }

        return 0;
    }


    public void addBitCoin(User user, double amount){
        walletService.addBitCoinAmount(user.getWallet(), amount);
    }

    public void addEthereum(User user, double amount){
        walletService.addEthereumAmount(user.getWallet(), amount);
    }
}
