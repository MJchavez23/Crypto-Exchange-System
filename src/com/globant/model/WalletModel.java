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

    public void newWallet(int userId, double balanceFiat, HashMap<String, Double> cryptoCurrencies){
        try(PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE, true))) {
             pw.printf("%d,%.2f",
                userId,
                balanceFiat
            );
             pw.print(",");
            HashMap<String, Double> crypto = cryptoCurrencies;
            StringBuilder cryptoBuilder = new StringBuilder();
            for (Map.Entry<String, Double> entry : crypto.entrySet()) {
                if (!cryptoBuilder.isEmpty()) {
                    cryptoBuilder.append(";");
                }
                cryptoBuilder.append(entry.getKey()).append(":").append(entry.getValue());
            }
            pw.print("\"" + cryptoBuilder.toString() + "\"%n");

        } catch (IOException e) {

        }
    }

}
