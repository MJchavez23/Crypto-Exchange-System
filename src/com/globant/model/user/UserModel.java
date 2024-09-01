package com.globant.model.user;

import com.globant.model.CsvManager;
import java.util.List;

public class UserModel {

    private final CsvManager csvManager = new CsvManager();

    public void registerUser(User user){
        int userId = user.getUserId();
        String userName = user.getUserName();
        String email = user.getEmail();
        String password = user.getPassword();
        csvManager.writeNewWallet(userId, 0.0);
        csvManager.writeNewUser(userId,userName, email, password);
    }


    public User loginUser(String username, String password){
        List<String> data = csvManager.checkUser(username, password);
        int newUserId = Integer.parseInt(data.get(0));
        String newUserName = data.get(1);
        String newPassword = data.get(2);
        String newEmail = data.get(3);
        User newUser = new User(newUserId, newUserName, newEmail, newPassword);

        String[] newWallet = csvManager.getWallet(newUserId);
        int walletUserId = Integer.parseInt(newWallet[0]);
        double walletBalance = Double.parseDouble(newWallet[1]);
        newUser.setWallet(walletUserId, walletBalance);

        return newUser;

    }


    public void deductBalance(User user, double amount){
        user.deductFiat(amount);
    }

    public void logOut(int userid, double balance){
        csvManager.updateWallet(userid, balance);
    }
}
