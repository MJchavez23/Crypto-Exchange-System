package com.globant.model.user;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class UserModel {

    private static final String CSV_FILE = "src/com/globant/model/user/users.csv";


    public void registerUser(User user){
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            pw.printf("%d,\"%s\",\"%s\",\"%s\"%n",
                    user.getUserId(),
                    user.getUserName().replace("\"", "\"\""),
                    user.getEmail().replace("\"", "\"\""),
                    user.getPassword().replace("\"", "\"\""));
        } catch (IOException e) {

        }
    }


    public User loginUser(String username, String password){
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (parts.length >= 4) {
                    String csvUserId = parts[0].replace("\"", "");
                    String csvUsername = parts[1].replace("\"", "");
                    String csvPassword = parts[2].replace("\"", "");
                    String csvEmail = parts[3].replace("\"", "");


                    if (username.equals(csvUsername) && password.equals(csvPassword)) {
                        int userId = Integer.parseInt(csvUserId);
                        User newUser = new User(userId, csvUsername, csvEmail, csvPassword);
                        return newUser;
                    }
                }
            }
        } catch (IOException e) {

        }

        System.out.println("User dont match");
        return null;
    }
}
