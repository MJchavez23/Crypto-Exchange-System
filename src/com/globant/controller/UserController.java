package com.globant.controller;

import com.globant.model.cryptoCurrency.BitCoin;
import com.globant.model.cryptoCurrency.Ethereum;
import com.globant.model.user.User;
import com.globant.service.UserService;
import com.globant.view.ConsoleView;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class UserController {
    private final Random rand = new Random();
    private final UserService userService;
    private final ConsoleView view;
    private User user;

    public UserController(UserService userService, ConsoleView view) {
        this.view = view;
        this.userService = userService;
    }

    public void executeRegister(){
        List<String> data = view.registrationPage();
        String username = data.get(0);
        String password = data.get(1);
        String email = data.get(2);
        try{
            userService.register(username, password, email);
            view.showSuccess("User successfully registered");
        }catch(Exception e){
            view.showError("Register Error");
        }
    }


    public User executeLogin(){
        List<String> data = view.loginPage();
        String username = data.get(0);
        String password = data.get(1);
        user = userService.login(username, password);
        if(user == null){
            view.showError("Login Error");
            return null;
        }else{
            view.showSuccess("User logged in");
            return user;
        }
    }


     public int executeBalance(){
        int choice = view.balancePage(user.getWalletBalance(), user.getUserName(), user.getBitCoinBalance(), user.getEthereumBalance());
        if (choice == 1){
            return 1;
        }
        return -1;
     }

     public void executeDeposit(){
        double amount = view.depositPage();
        userService.deposit(amount, user);
        view.showSuccess("Deposit successful");
     }


     public void executeLogOut(){
        userService.logOut(user);
        user = null;
        view.showSuccess("Logout successful");
     }




}
