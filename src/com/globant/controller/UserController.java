package com.globant.controller;

import com.globant.model.WalletModel;
import com.globant.model.user.User;
import com.globant.model.user.UserModel;
import com.globant.view.ConsoleView;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class UserController {
    private final Random rand = new Random();
    private UserModel model;
    private WalletModel wallet;
    private final ConsoleView view;

    public UserController(UserModel model, ConsoleView view) {
        this.view = view;
        this.model = model;
        this.wallet = new WalletModel();
    }

    public void executeRegister(){
        List<String> data = view.registrationPage();
        try{
            register(data.get(0), data.get(1), data.get(2));
            executeLogin();
        }catch(Exception e){
            view.showError("Register Error");
        }
    }


    public void executeLogin(){
        List<String> data = view.loginPage();
    }

    public void register(String username, String password, String email){
            int newUserId = rand.nextInt(Integer.MAX_VALUE) + 1;
            wallet.newWallet(newUserId, 0.0);
            User newUser = new User(newUserId, username, email, password);
            model.registerUser(newUser);
    }

}
