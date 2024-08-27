package com.globant.controller;

import com.globant.model.WalletModel;
import com.globant.model.user.UserModel;
import com.globant.view.ConsoleView;

public class RootController {
    private UserController userController;
    private WalletController walletController;
    private ConsoleView view;
    public RootController(UserModel userModel, WalletModel walletModel, ConsoleView view){
        this.view = view;
        this.userController = new UserController(userModel, view);
    }

    public void run(){
        while(true){
            int choice = view.getUserChoice();
            switch(choice){
                case 1:
                    this.userController.executeLogin();
                    break;
                case 2:
                    this.userController.executeRegister();
                    break;

                default:
                    view.showError("Invalid choice");
            }
        }
    }
}
