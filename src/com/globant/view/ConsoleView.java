package com.globant.view;

import com.globant.model.user.User;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {this.scanner = new Scanner(System.in);}

    public int getUserChoiceMain(){
        System.out.println("----- WELCOME -----");
        System.out.println("CRYPTO EXCHANGE SYSTEM");
        System.out.println("1.LOGIN");
        System.out.println("2.REGISTRATION");
        System.out.println("3.EXIT");
        System.out.print("ENTER YOUR CHOICE: ");
        try{
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        }catch(InputMismatchException e){
            scanner.nextLine();
            return -1;
        }
    }


    public List<String> loginPage(){
            try{
                System.out.println("---- LOGIN PAGE ---");
                System.out.print("Please enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String password = scanner.nextLine();
                List<String> data = new ArrayList<String>();
                data.add(username);
                data.add(password);
                return data;
            }catch(InputMismatchException e) {
                System.out.println("Invalid username or password");
                return loginPage();
            }
    }

    public List<String> registrationPage(){
            try{
                System.out.println("---- REGISTRATION PAGE ----");
                System.out.print("Please enter your username: ");
                String username = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String password = scanner.nextLine();
                System.out.print("Please enter your email: ");
                String email = scanner.nextLine();

                List<String> data = new ArrayList<>();
                data.add(username);
                data.add(password);
                data.add(email);
                return data;
            }catch(InputMismatchException e) {
                System.out.println("Invalid Data");
                return registrationPage();
            }
    }

    public void menuPage(User user){

    }


    public void showError(String errorMessage) {System.out.println(errorMessage);}
    public void close(){this.scanner.close();}
}
