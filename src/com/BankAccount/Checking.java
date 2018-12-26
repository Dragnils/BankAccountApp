package com.BankAccount;

public class Checking extends Account {
    //List properties specific to a Checking account
    private int debitCardNumber;
    private int debitCardPIN;

    //Constructor to initialize checking account properties
    public Checking(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
//        System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
//        System.out.println("NEW CHECKING ACCOUNT");
//        System.out.println("NAME: " + name);
        setDebitCard();
    }

    @Override
    public void setRate(){
//        System.out.println("Implement rate for Checking");
        rate = getBaseRate() * .15;
    }

    //List any methods specific to the checking account
    private void setDebitCard(){
        debitCardNumber = (int)(Math.random() * Math.pow(10,12));
        debitCardPIN = (int) (Math.random() * Math.pow(10, 4));

    }


    public void showInfo(){
        System.out.println("ACCOUNT TYPE: Checking");
        super.showInfo();
        System.out.println(" Your Checking Account Features" +
                "\n Debit Card Number: " + debitCardNumber +
                "\n Debit Card PIN: " + debitCardPIN);

    }
}
