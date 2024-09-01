package com.globant.model.wallet;

public class WalletService {
    public void setBitCoinAmount(Wallet wallet, double amount) {
        wallet.setBitCoinBalance(amount);
    }

    public void setEthereumAmount(Wallet wallet, double amount) {
        wallet.setEthereumBalance(amount);
    }
}
