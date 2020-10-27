package bankaccountapp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();


        //Read a CSV file then create new accounts base on that data
        String file = ".....";
        List<String[]> newAccountHolder = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolder) {
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("ERROR READING TYPE");
            }
        }
        for (Account acc: accounts){
            System.out.println("\n*********");
            acc.showInfo();
        }
    }


}

