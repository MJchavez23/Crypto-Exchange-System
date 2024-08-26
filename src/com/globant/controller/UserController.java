package com.globant.controller;

import com.globant.model.UserModel;

import java.util.Random;

public class UserController {
    private final Random rand = new Random();
    private UserModel model;


    public UserController(UserModel model) {
        this.model = model;
    }

    public boolean register(String username, String password, String email){

    }
}
