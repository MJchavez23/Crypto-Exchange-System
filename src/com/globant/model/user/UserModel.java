package com.globant.model.user;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserModel {

    private static final String CSV_FILE = "src/com/globant/model/user/users.csv";


    public boolean registerUser(User user){
        try (PrintWriter pw = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            // Write user details to the CSV file without extra escaping
            pw.printf("%d,\"%s\",\"%s\",\"%s\"%n",
                    user.getUserId(),
                    user.getUserName().replace("\"", "\"\""),
                    user.getEmail().replace("\"", "\"\""),
                    user.getPassword().replace("\"", "\"\""));
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
