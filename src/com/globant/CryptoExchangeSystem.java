package com.globant;

import com.globant.controller.RootController;
import com.globant.model.wallet.WalletModel;
import com.globant.model.user.UserModel;
import com.globant.service.UserService;
import com.globant.view.ConsoleView;

public class CryptoExchangeSystem {
    public static void main(String[] args) {
        UserService userService = new UserService();
        WalletModel walletModel = new WalletModel();
        ConsoleView consoleView = new ConsoleView();
        RootController rootController = new RootController(userService, walletModel, consoleView);

        rootController.run();
        consoleView.close();
    }
}
