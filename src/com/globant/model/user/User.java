package com.globant.model.user;


import com.globant.model.wallet.Wallet;

public class User {
    private final int userId;
    private final String userName;
    private final String email;
    private final String password;
    private Wallet wallet;

    public User(int userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void setWallet(int userId, Double balanceFiat) {
        this.wallet = new Wallet(userId, balanceFiat);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public double getWalletBalance() {
        return wallet.getBalanceFiat();
    }


    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void depositFiat(double amount) {
        wallet.depositFiat(amount);
    }
}
