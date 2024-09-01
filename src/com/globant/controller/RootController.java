package com.globant.controller;

import com.globant.model.cryptoCurrency.BitCoin;
import com.globant.model.cryptoCurrency.Ethereum;
import com.globant.model.transaction.TransactionService;
import com.globant.model.user.User;
import com.globant.model.wallet.WalletModel;
import com.globant.service.OrderService;
import com.globant.service.UserService;
import com.globant.view.ConsoleView;

public class RootController {
    private final UserController userController;
    private final ConsoleView view;
    private final OrderController orderController;
    private final TransactionController transactionController;
    private User user;
    private BitCoin bitCoin;
    private Ethereum ethereum;

    public RootController(UserService userService, OrderService orderService, TransactionService transactionService, ConsoleView view){
        this.view = view;
        userController = new UserController(userService, view);
        orderController = new OrderController(orderService, view);
        transactionController = new TransactionController(transactionService, view);
        bitCoin = new BitCoin("BTC", 50000.0, "BitCoin");
        ethereum = new Ethereum("ETH", 3000.0, "Ethereum");
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
        User result = userController.executeLogin();
        if (result != null){
            user = result;
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

                case 2:
                    userController.executeDeposit();
                    showMenuPage();
                    break;

                case 3:
                    userController.placeSellOrder(bitCoin, ethereum);
                    showMenuPage();
                    break;

                case 5:

                    transactionController.showUserTransactions(user);
                    showMenuPage();
                    break;
                case 6:
                    orderController.buyExchange(user, bitCoin, ethereum);
                    showMenuPage();
                    break;
                case 7:
                    userController.executeLogOut();
                    run();
                    break;
            }
        }
    }

}
