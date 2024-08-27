package com.globant.controller;

import com.globant.model.WalletModel;
import com.globant.model.user.UserModel;
import com.globant.view.ConsoleView;

public class RootController {
    private final UserController userController;
    private final WalletController walletController;
    private final ConsoleView view;
    public RootController(UserModel userModel, WalletModel walletModel, ConsoleView view){
        this.view = view;
        this.userController = new UserController(userModel, view);
        this.walletController = new WalletController(walletModel, view);
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
                case 3:
                    System.exit(0);

                default:
                    view.showError("Invalid choice");
            }
        }
    }
}
