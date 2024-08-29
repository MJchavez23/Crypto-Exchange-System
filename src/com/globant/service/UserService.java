package com.globant.service;

import com.globant.model.user.User;
import com.globant.model.user.UserModel;

import java.util.Objects;
import java.util.Random;

public class UserService {
    private final Random rand = new Random();
    private UserModel model;

    public UserService(){
        model = new UserModel();
    }

    public void login(){

    }

    public void register(String username, String password, String email){
            if(!Objects.equals(username, "") && !Objects.equals(password, "") && !Objects.equals(email, "")){
                int newUserId = rand.nextInt(Integer.MAX_VALUE) + 1;
                User newUser = new User(newUserId, username, email, password);
                model.registerUser(newUser);
                login();
            }

    }
}
