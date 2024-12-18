package com.sta.account;

import java.io.*;
import java.util.ArrayList;

public class AccountHandler {
    private ArrayList<Account> accounts;
    String filePath;

    public AccountHandler() {
        accounts = new ArrayList<>();
        filePath = new String("res/credentials/cred.dat");
        readAccounts();
    }

    public void readAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            File file = new File(filePath);
            if (file.length() == 0) {
                return;
            }
            String line;
            String username;
            String password;
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
}
