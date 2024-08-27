package com.globant.controller;

import com.globant.model.WalletModel;
import com.globant.view.ConsoleView;

public class WalletController {
    private final WalletModel model;
    private final ConsoleView view;
    public WalletController(WalletModel model, ConsoleView view) {
        this.model = model;
        this.view = view;
    }
}
