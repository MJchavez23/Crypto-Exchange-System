package com.globant.model;

import java.util.Random;

public class UserModel {
    private static final Random rand = new Random();

    private int userId;
    private String userName;
    private String email;
    private String password;
    private WalletModel wallet;

    public UserModel(int userId, String userName, String email, String password, WalletModel wallet) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.wallet = wallet;
    }
}
