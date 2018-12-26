package com.BankAccount;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();



        //Read a CSV File then create new account base on that data
        String file = "C:\\Users\\Ануарбек\\Desktop\\File\\NewBankAccounts.csv";
        List<String[]> newAccountHolder = utilites.CSV.read(file);
        for(String[] accuntHolder : newAccountHolder){
            String name = accuntHolder[0];
            String sSN = accuntHolder[1];
            String accountType = accuntHolder[2];
            double initDeposite = Double.parseDouble(accuntHolder[3]);
            //System.out.println(name + " " + sSN + " " + accountType + " $" + initDeposite);
            if(accountType.equals("Savings")){
//                System.out.println("OPEN A SAVING ACCOUNT");
                accounts.add(new Saving(name, sSN, initDeposite));
            }
            else if (accountType.equals("Checking")){
//                System.out.println("OPEN A CHECKING ACCOUNT");
                accounts.add(new Checking(name, sSN, initDeposite));
            }
            else{
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }


        for(Account acc : accounts){
            System.out.println("\n**************************");
            acc.showInfo();
        }

    }
}
