package com.globant.controller;

import com.globant.model.user.User;
import com.globant.model.user.UserModel;
import com.globant.view.ConsoleView;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class UserController {
    private final Random rand = new Random();
    private final UserModel model;
    private final ConsoleView view;
    private User user;
    public UserController(UserModel model, ConsoleView view) {
        this.view = view;
        this.model = model;
    }

    public void executeRegister(){
        List<String> data = view.registrationPage();
        String username = data.get(0);
        String password = data.get(1);
        String email = data.get(2);
        try{
            if(!Objects.equals(username, "") && !Objects.equals(password, "") && !Objects.equals(email, "")){
                register(username, password, email);
                executeLogin();
            }else{
                view.showError("Register Error");
                executeRegister();
            }

        }catch(Exception e){
            view.showError("Register Error");
        }
    }


    public void executeLogin(){
        List<String> data = view.loginPage();
        String username = data.get(0);
        String password = data.get(1);

        if(!Objects.equals(username, "") && !Objects.equals(password, "")){
            user = model.loginUser(username, password);

        }


    }

    public void register(String username, String password, String email){
            int newUserId = rand.nextInt(Integer.MAX_VALUE) + 1;
            User newUser = new User(newUserId, username, email, password);
            model.registerUser(newUser);
    }

}
