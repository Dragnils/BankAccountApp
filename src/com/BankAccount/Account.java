package com.BankAccount;

public abstract class Account implements IBaseRate {
    // List common properties for saving and checking account
    private String name;
    private String sSN; // Social Security number
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;



    //Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
//        System.out.println("NAME: " + name);
//        System.out.print("NEW ACCOUNT: ");
        this.name = name;
        this.sSN  = sSN;
        this.balance = initDeposit;
//        System.out.println("NAME: " + name + " SSN: " + sSN + " BALANCE: $" + balance);

        //Set account number
        index++;
        this.accountNumber = setAccountNumber();
//        System.out.println("ACCOUNT NUMBER: " + this.accountNumber);

        setRate();

    }

    public abstract void setRate();

    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return  lastTwoOfSSN + uniqueID + randomNumber;

    }

    public void compoud(){ // начисленные проценты
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    //List common methods - transaction
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }

    public void showInfo(){
        System.out.println(
                "NAME: " + name +
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: $" + balance +
                        "\nRATE: " + rate + "%"
        );
    }
}
