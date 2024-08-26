package com.globant.controller;

import com.globant.model.WalletModel;
import com.globant.model.user.User;
import com.globant.model.user.UserModel;

import java.util.HashMap;
import java.util.Random;

public class UserController {
    private final Random rand = new Random();
    private UserModel model;
    private WalletModel wallet;


    public UserController(UserModel model) {
        this.model = model;
        this.wallet = new WalletModel();
    }


    public boolean register(String username, String password, String email){
        int newUserId = rand.nextInt();
        HashMap<String, Double> cryptoCurrencies = new HashMap<>();
        cryptoCurrencies.put("BitCoin", 0.0);
        cryptoCurrencies.put("Ethereum", 0.0);
        wallet.newWallet(newUserId, 0.0, cryptoCurrencies);
        User newUser = new User(newUserId, username, email, password);
        boolean result = model.registerUser(newUser);

        return result;
    }

}
