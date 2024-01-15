package A_PERSONAL_PROJECT.Atm_Management_System.ATP_Project;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
    /*
    Responsible for types of account
    customer verification
    operations regarding balance calculation
    exception handling for invalid choices
     */

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    /*
    Constructor
     */

    public Account() {
    }

    public Account(int customerNumber, int pinNumber) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
    }

    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
        this.customerNumber = customerNumber;
        this.pinNumber = pinNumber;
        this.checkingBalance = checkingBalance;
        this.savingBalance = savingBalance;
    }



    /*
            Getters and Setters
             */
    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }


    public double getSavingBalance() {
        return savingBalance;
    }

    // Withdraw in Checking Account
    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    //Withdraw in Saving Account
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    //Deposit in Checking Account
    public double calCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    //Deposit in Saving Account
    public double calSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    //Transfer from Checking to Saving Account
    public void calcCheckTransfer(double amount) {
        checkingBalance = checkingBalance - amount;
        savingBalance = savingBalance + amount;
    }

    //Transfer from  Saving Account to Checking Account
    public void calcSavingTransfer(double amount) {

        savingBalance = savingBalance - amount;
        checkingBalance = checkingBalance + amount;
    }

    /**
     * Get User input and perform Action
     */
    public void getCheckingWithdrawInput(){
        boolean end = false;
        while(!end){
            try{
                System.out.println("\nCurrent Checking Account Balance: "+ moneyFormat.format(checkingBalance));
                System.out.println("\nAmount you want to withdraw from Checking Account: ");
                double amount = input.nextDouble();
                if((checkingBalance - amount)>=0 && amount >=0){
                    calcCheckingWithdraw(amount);
                    System.out.println("\nCurrent Checking Account Balance: "+ moneyFormat.format(checkingBalance));
                    end = true;

            }else{
                System.out.println("\nBalance Cannot be Negative.");
            }
        }catch (InputMismatchException e){
                System.out.println("\nInvalid Choice");
                input.next();
            }

            }
    }

    public void getSavingWithdrawInput(){
        boolean end = false;
        while(!end){
            try{
                System.out.println("\nCurrent Saving Account Balance: "+ moneyFormat.format(savingBalance));
                System.out.println("\nAmount you want to withdraw from Saving Account: ");
                double amount = input.nextDouble();
                if((savingBalance - amount)>=0 && amount >=0){
                    calcSavingWithdraw(amount);
                    System.out.println("\nCurrent Saving Account Balance: "+ moneyFormat.format(savingBalance));
                    end = true;

                }else{
                    System.out.println("\nBalance Cannot be Negative.");
                }
            }catch (InputMismatchException e){
                System.out.println("\nInvalid Choice");
                input.next();
            }

        }
    }

    public void getCheckingDepositInput(){
        boolean end = false;
        while(!end){
            try{
                System.out.println("\nCurrent Checking Account Balance: "+ moneyFormat.format(checkingBalance));
                System.out.println("\nAmount you want to Deposit from Checking Account: ");
                double amount = input.nextDouble();
                if((checkingBalance + amount)>=0 && amount >=0){
                    calCheckingDeposit(amount);
                    System.out.println("\nCurrent Checking Account Balance: "+ moneyFormat.format(checkingBalance));
                    end = true;

                }else{
                    System.out.println("\nBalance Cannot be Negative.");
                }
            }catch (InputMismatchException e){
                System.out.println("\nInvalid Choice");
                input.next();
            }

        }
    }

    public void getSavingDepositInput(){
        boolean end = false;
        while(!end){
            try{
                System.out.println("\nCurrent Saving Account Balance: "+ moneyFormat.format(savingBalance));
                System.out.println("\nAmount you want to withdraw from Saving Account: ");
                double amount = input.nextDouble();
                if((savingBalance + amount)>=0 && amount >=0){
                    calSavingDeposit(amount);
                    System.out.println("\nCurrent Saving Account Balance: "+ moneyFormat.format(savingBalance));
                    end = true;

                }else{
                    System.out.println("\nBalance Cannot be Negative.");
                }
            }catch (InputMismatchException e){
                System.out.println("\nInvalid Choice");
                input.next();
            }

        }
    }

    //Check account first, then transfer from the choice
    public void getTransferInput(String accType) {
        boolean end = false;
        while (!end) {
            try {
                if (accType.equals("Checkings")) {
                    System.out.println("\nSelect an account you wish to transfer funds to:");
                    System.out.println("1. Savings");
                    System.out.println("2. Exit");
                    System.out.print("\nChoice: ");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
                            System.out.print("\nAmount you want to deposit into your Savings Account: ");
                            double amount = input.nextDouble();
                            if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
                                calcCheckTransfer(amount);
                                System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
                                System.out.println(
                                        "\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
                                end = true;
                            } else {
                                System.out.println("\nBalance Cannot Be Negative.");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Choice.");
                            break;
                    }
                } else if (accType.equals("Savings")) {
                    System.out.println("\nSelect an account you wish to transfers funds to: ");
                    System.out.println("1. Checkings");
                    System.out.println("2. Exit");
                    System.out.print("\nChoice: ");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
                            System.out.print("\nAmount you want to deposit into your savings account: ");
                            double amount = input.nextDouble();
                            if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
                                calcSavingTransfer(amount);
                                System.out.println("\nCurrent checkings account balance: " + moneyFormat.format(checkingBalance));
                                System.out.println("\nCurrent savings account balance: " + moneyFormat.format(savingBalance));
                                end = true;
                            } else {
                                System.out.println("\nBalance Cannot Be Negative.");
                            }
                            break;
                        case 2:
                            return;
                        default:
                            System.out.println("\nInvalid Choice.");
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                input.next();
            }
        }
    }


}
