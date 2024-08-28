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

    public int getUserChoiceMenu(){
        System.out.println("----- MENU -----");
        System.out.println("1.SHOW BALANCE");
        System.out.println("2.PLACE A SELL ORDER");
        System.out.println("3.PLACE A BUY ORDER");
        System.out.println("4.LOGOUT");
        System.out.println("5.EXIT");
        System.out.print("ENTER YOUR CHOICE: ");

        try{

            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        }catch (InputMismatchException e){
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

    public void balancePage(User user){
        System.out.println("---- BALANCE PAGE ----");
        System.out.println("Username: " + user.getUserName());
        System.out.println("Email: " + user.getEmail());
        //System.out.println("Balance: " + user.getBalance());
    }


    public void showError(String errorMessage) {System.out.println(errorMessage);}
    public void close(){this.scanner.close();}
}
