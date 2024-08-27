package com.globant.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {this.scanner = new Scanner(System.in);}

    public int getUserChoice(){
        System.out.println("----- WELCOME -----");
        System.out.println("CRYPTO EXCHANGE SYSTEM");
        System.out.println("1.LOGIN");
        System.out.println("2.REGISTRATION");
        System.out.println("3.EXIT");
        System.out.println("ENTER YOUR CHOICE: ");
        try{
            return this.scanner.nextInt();
        }catch(InputMismatchException e){
            this.scanner.nextLine();
            return -1;
        }
    }

    public List<String> loginPage(){
            try{
                System.out.println("Please enter your username: ");
                String username = this.scanner.nextLine();
                System.out.println("Please enter your password: ");
                String password = this.scanner.nextLine();
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
                System.out.println("Please enter your username: ");
                String username = this.scanner.nextLine();
                System.out.println("Please enter your password: ");
                String password = this.scanner.nextLine();
                System.out.println("Please enter your email: ");
                String email = this.scanner.nextLine();
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

    public void showError(String errorMessage) {System.out.println(errorMessage);}
    public void close(){this.scanner.close();}
}
