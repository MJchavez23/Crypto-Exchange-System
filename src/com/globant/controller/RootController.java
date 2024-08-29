package com.globant.controller;

import com.globant.model.wallet.WalletModel;
import com.globant.model.user.UserModel;
import com.globant.service.UserService;
import com.globant.view.ConsoleView;

public class RootController {
    private final UserController userController;
    private final WalletController walletController;
    private final ConsoleView view;


    public RootController(UserService userService, WalletModel walletModel, ConsoleView view){
        this.view = view;
        userController = new UserController(userService, view);
        walletController = new WalletController(walletModel, view);
    }

    public void run(){
        while(true){
            int choice = view.getUserChoiceMain();
            switch(choice){
                case 1:
                    checkLogin();
                    break;
                case 2:
                    userController.executeRegister();
                    checkLogin();
                    break;
                case 3:
                    System.exit(0);
                default:
                    view.showError("Invalid choice");
            }
        }
    }

    public void checkLogin(){
        int result = userController.executeLogin();
        if (result == 1){
            showMenuPage();
        }else{
            run();
        }
    }

    public void showMenuPage(){
        while(true){
            int choice = view.getUserChoiceMenu();
            switch(choice){
                case 1:
                    int choice2 = userController.executeBalance();
                    if(choice2 == 1){
                        showMenuPage();
                    }
                    break;

                case 5:
                    userController.executeLogOut();
                    run();
                    break;

                case 6:
                    System.exit(0);
                    break;

            }
        }
    }

}
