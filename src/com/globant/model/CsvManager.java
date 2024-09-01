package com.globant.model;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class CsvManager {

    private static final String CSV_USER_FILE = "src/com/globant/model/user/users.csv";
    private static final String CSV_WALLET_FILE = "src/com/globant/model/wallet/wallet.csv";
    private static final String CSV_SELL_ORDER_FILE = "src/com/globant/model/orders/sell_order.csv";
    private static final String CSV_SELL_TRANSACTION = "src/com/globant/model/transaction/transactions.csv";


    public void writeNewUser(int userId, String userName, String email, String password) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_USER_FILE, true))) {
            pw.printf("%d,\"%s\",\"%s\",\"%s\"%n",
                    userId,
                    userName.replace("\"", "\"\""),
                    password.replace("\"", "\"\""),
                    email.replace("\"", "\"\""));
        } catch (IOException e) {

        }
    }

    public List<String> checkUser(String username, String password){
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (parts.length >= 4) {
                    String csvUserId = parts[0].replace("\"", "");
                    String csvUsername = parts[1].replace("\"", "");
                    String csvPassword = parts[2].replace("\"", "");
                    String csvEmail = parts[3].replace("\"", "");


                    if (username.equals(csvUsername) && password.equals(csvPassword)) {
                        List<String> data = new ArrayList<String>();
                        data.add(csvUserId);
                        data.add(csvUsername);
                        data.add(csvPassword);
                        data.add(csvEmail);
                        return data;
                    }
                }
            }
        } catch (IOException e) {

        }
        return null;
    }

    public void writeNewWallet(int userId, double balanceFiat){
        try(PrintWriter pw = new PrintWriter(new FileWriter(CSV_WALLET_FILE, true))) {
             pw.printf("%d,%.2f", userId, balanceFiat);
             pw.print(",0,0");
             pw.println();
        } catch (IOException e) {

        }
    }


    public String[] getWallet(int userId){
        try(BufferedReader br = new BufferedReader(new FileReader(CSV_WALLET_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(String.valueOf(userId))) {
                    return line.split(",");
                }
            }
        } catch (IOException e) {

        }
        return null;
    }


    public void updateWallet(int userId, double newBalance, double bitCoinAmount, double ethereumAmount) {
        List<String> lines = new ArrayList<>();
        boolean updated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_WALLET_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (parts.length >= 4) {
                    String csvUserIdStr = parts[0].replace("\"", "").trim();
                    int csvUserId;
                    try {
                        csvUserId = Integer.parseInt(csvUserIdStr);
                    } catch (NumberFormatException e) {
                        lines.add(line);
                        continue;
                    }

                    if (userId == csvUserId) {
                        lines.add(String.format("%d,%.2f,%.2f,%.2f",
                            csvUserId, newBalance, bitCoinAmount, ethereumAmount));
                        updated = true;
                    } else {
                        lines.add(line);
                    }
                } else {
                    lines.add(line);
                }
            }

        } catch (IOException e) {
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_WALLET_FILE))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
        }
    }

    public void writeSellOrder(int orderId, int userId, String cryptoCurrency, double amount, double price){
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_SELL_ORDER_FILE, true))) {
            pw.printf("%d,%d,\"%s\",%.2f,%.2f%n",
                    orderId,
                    userId,
                    cryptoCurrency.replace("\"", "\"\""),
                    amount,
                    price);
             pw.println();
        } catch (IOException e) {

        }
    }
    public void writeSellTransaction(int userId, String cryptoCurrency, double amount, double price,int isBuying){
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_SELL_TRANSACTION, true))) {
            pw.printf("%d,\"%s\",%.2f,%.2f,%d%n",
                    userId,
                    cryptoCurrency.replace("\"", "\"\""),
                    amount,
                    price,
                    isBuying);
             pw.println();
        } catch (IOException e) {

        }
    }

}
