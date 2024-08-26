package com.globant.model.user;

import com.globant.model.WalletModel;

public class User {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private WalletModel wallet;

    public User(int userId, String userName, String email, String password, WalletModel wallet) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.wallet = wallet;
    }
}
