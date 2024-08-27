package com.globant.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class WalletModel {

    private int userId;
    private double balanceFiat;
    private HashMap<String, Double> cryptoCurrencies;
    private static final String CSV_FILE = "wallet.csv";

    public void newWallet(int userId, double balanceFiat){
        try(PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE, true))) {
             pw.printf("%d, %.2f", userId, balanceFiat);
             pw.print(",0,0");
             pw.println();
        } catch (IOException e) {

        }
    }

}
