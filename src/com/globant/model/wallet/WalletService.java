package com.globant.model.wallet;

public class WalletService {
    public void addBitCoinAmount(Wallet wallet, double amount) {
        wallet.addBitCoinBalance(amount);
    }

    public void addEthereumAmount(Wallet wallet, double amount) {
        wallet.addEthereumBalance(amount);
    }

    public void deductEthereumAmount(Wallet wallet, double amount) {
        wallet.deductEthereum(amount);
    }

    public void deductBitCoinAmount(Wallet wallet, double amount) {
        wallet.deductBitcoin(amount);
    }
}
