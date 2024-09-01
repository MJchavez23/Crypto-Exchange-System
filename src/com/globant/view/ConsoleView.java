package com.globant.view;

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
        System.out.println("2.DEPOSIT FIAT ($)");
        System.out.println("3.PLACE A SELL ORDER");
        System.out.println("4.PLACE A BUY ORDER");
        System.out.println("5.VIEW HISTORY");
        System.out.println("6.BUY TO THE EXCHANGE");
        System.out.println("7.LOGOUT");
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

    public int balancePage(double balance, String userName, double bitcoin, double ethereum){
        System.out.println("---- BALANCE PAGE ----");
        System.out.println("Username: " + userName);
        System.out.println("Balance Fiat: " + balance);
        System.out.println("Bitcoin: " + bitcoin);
        System.out.println("Ethereum: " + ethereum);
        System.out.println("1.Go back");
        try{
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        }catch (InputMismatchException e){
            scanner.nextLine();
            return -1;
        }

    }


    public double depositPage(){
        System.out.println("---- DEPOSIT PAGE ----");
        System.out.println("How much do you want to deposit?: ");
        try{
            double amount = scanner.nextInt();
            scanner.nextLine();
            return amount;
        }catch (InputMismatchException e){
            scanner.nextLine();
            return 0;
        }
    }


    public String[] placeSellOrderPage(){
        System.out.println("---- PLACE ORDER PAGE ----");
        String cryptoType = cryptoCurrencySellChoice();
        System.out.print("How much do you want to sell?: ");
        String amount = scanner.nextLine();
        System.out.print("At what price do you want to sell: ");
        String price = scanner.nextLine();
        return new String[]{cryptoType, amount, price};
    }


    public String cryptoCurrencySellChoice(){
        System.out.println("Which crypto do you want to sell?: ");
        System.out.println("1.BitCoin");
        System.out.println("2.Ethereum");
        System.out.print("ENTER YOUR CHOICE: ");
        try{
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                return "BitCoin";
            }
            if (choice == 2){
                return "Ethereum";
            }else{
                return null;
            }
        }catch (Exception e){
            scanner.nextLine();
            return null;
        }
    }

    public String[] buyExchange(){
        System.out.println("---- BUY EXCHANGE ----");
        String crypto = cryptoCurrencySellChoice();
        System.out.print("How much do you want to buy?: ");
        String amount = scanner.nextLine();
        return new String[]{crypto, amount};
    }

    public String cryptoCurrencyBuyChoice(){
        System.out.println("Which crypto do you want to buy?: ");
        System.out.println("1.BitCoin");
        System.out.println("2.Ethereum");
        System.out.print("ENTER YOUR CHOICE: ");
        try{
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                return "BitCoin";
            }
            if (choice == 2){
                return "Ethereum";
            }else{
                return null;
            }
        }catch (Exception e){
            scanner.nextLine();
            return null;
        }
    }

    public void showError(String errorMessage) {System.out.println(errorMessage);}
    public void close(){this.scanner.close();}
}
