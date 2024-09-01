package com.globant.model;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class CsvManager {

    private static final String CSV_USER_FILE = "src/com/globant/model/user/users.csv";
    private static final String CSV_WALLET_FILE = "src/com/globant/model/wallet/wallet.csv";
    private static final String CSV_SELL_ORDER_FILE = "src/com/globant/model/sell_order.csv";


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


    public void updateWallet(int userId, double newBalance) {
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
                        // Skip lines with invalid userId
                        lines.add(line);
                        continue;
                    }

                    if (userId == csvUserId) {
                        // Update only the balance
                        lines.add(String.format("%d,%.2f,%s,%s",
                            csvUserId, newBalance, parts[2], parts[3]));
                        updated = true;
                    } else {
                        // Keep the existing line
                        lines.add(line);
                    }
                } else {
                    // Keep lines with less data
                    lines.add(line);
                }
            }

        } catch (IOException e) {
        }

        // Write the updated lines back to the file
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
            pw.printf("%d,%d,\"%s\",%.2f,%.2f",
                    orderId,
                    userId,
                    cryptoCurrency.replace("\"", "\"\""),
                    amount,
                    price);
        } catch (IOException e) {

        }
    }


    public void writeTransaction(){

    }

}
