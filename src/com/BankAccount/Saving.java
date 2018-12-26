package com.BankAccount;

public class Saving extends Account {
    // List properties specific to the Saving acoount
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize setting for the Saving properties

    public Saving(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
//        System.out.println("ACCOUNT NUMBER: " + this.accountNumber);
//        System.out.println("NEW SAVING ACCOUNT");
//        System.out.println("NAME: " + name);

        setSafetyDepositBox();
    }

    @Override
    public void setRate(){

//        System.out.println("Implement rate for saving");

        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
//        System.out.println("Safety Deposit Box ID: " + safetyDepositBoxID);

    }


    //List any methods specific to saving account
    public void showInfo(){
        System.out.println("ACCOUNT TYPE: Saving");
        super.showInfo();
        System.out.println(
                " Your Account Features" +
                 "\n Safety Deposit Box ID: " + safetyDepositBoxID  +
                 "\n Safety Deposit Box Key: " + safetyDepositBoxKey
        );

    }
}
