package com.sta.account;

import java.io.*;
import java.util.ArrayList;

public class AccountHandler {
    private ArrayList<Account> accounts;
    private static Account currentAccount;
    String filePath;


    public AccountHandler() {
        accounts = new ArrayList<>();
        filePath = new String("res/credentials/cred.dat");
        readAccounts();
    }


    // reads account from the file
    public void readAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            File file = new File(filePath);
            if (file.length() == 0) {
                return;
            }
            String line;
            String username;
            String password;
            // parser of the reading mechanism
            while((line = br.readLine()) != null) {
                int usernameStart = line.indexOf("username=") + "username=".length();
                int usernameEnd = line.indexOf(",", usernameStart);
                if (usernameEnd == -1) {
                    usernameEnd = line.indexOf("]", usernameStart);
                }
                username = line.substring(usernameStart, usernameEnd);
                System.out.println("Username: " + username);

                int passwordStart = line.indexOf("password=") + "password=".length();
                int passwordEnd = line.indexOf("]", passwordStart);
                if (passwordEnd == -1) {
                    passwordEnd = line.indexOf(",", passwordStart);
                }
                password = line.substring(passwordStart, passwordEnd);
                System.out.println("Username: " + password);

                if(line.contains("Admin")) {
                    accounts.add(new Admin(username, password));
                }
                else if (line.contains("User")) {
                    accounts.add(new User(username, password));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // making sure to make accounts that doesn't already exist
    public boolean makeNewAccount(Account newAccount) {
        for(Account account : accounts) {
            if(account.getUsername().equals(newAccount.getUsername())) {
                return false;
            }
        }
        System.out.println("hello,world");
        newAccount.saveAccount(filePath);
        return true;
    }

    // This is used for checking if account exist from the database or not
    public Account retrieveAccount(Account account) {
        for (Account ac : accounts) {
            if(ac.getUsername().equals(account.getUsername())
            && ac.getPassword().equals(account.getPassword())) {
                return ac;
            }
        }
        return null;
    }

    public static void setCurrentAccount(Account account) {
        AccountHandler.currentAccount = account;
    }

    public static Account getCurrentAccount() {
        return AccountHandler.currentAccount;
    }

    public boolean isDatabaseEmpty() {
        return accounts.isEmpty();
    }
}
