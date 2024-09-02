package com.globant.service;

import com.globant.model.cryptoCurrency.CryptoCurrency;
import com.globant.model.user.User;
import com.globant.model.user.UserModel;

import java.util.Objects;
import java.util.Random;

public class UserService {
    private final Random rand = new Random();
    private final UserModel model;
    public UserService(){
        model = new UserModel();
    }

    public User login(String username, String password){
        try{
            if(!Objects.equals(username, "") && !Objects.equals(password, "")){
                return model.loginUser(username, password);
            }
        }catch(Exception e){
            return null;
        }
        return null;
    }

    public void register(String username, String password, String email){
            if(!Objects.equals(username, "") && !Objects.equals(password, "") && !Objects.equals(email, "")){
                int newUserId = rand.nextInt(Integer.MAX_VALUE) + 1;
                User newUser = new User(newUserId, username, email, password);
                model.registerUser(newUser);
            }

    }

    public void deposit(double amount, User user){
        if(amount > 0){
            user.depositFiat(amount);
        }
    }

    public void balanceDeduct(User user, double amount){
        if(user.getWalletBalance() > amount){
            model.deductBalance(user, amount);
        }
    }

    public void logOut(User user){
        model.logOut(user.getUserId(), user.getWallet());
    }

}
