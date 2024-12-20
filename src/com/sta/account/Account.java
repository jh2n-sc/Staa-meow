package com.sta.account;

import java.io.*;

public class Account {
    private String username;
    private String password;


    // Initialization of account
    public Account() {
        username = "";
        password = "";
    }
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }


    // Accessors and Mutators
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Used for printing, and also storing of accounts
    @Override
    public String toString() {
        return "Account [username=" + username + ", password=" + password + "]";
    }

    public void saveAccount(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            BufferedWriter br = new BufferedWriter(new BufferedWriter(writer));
            writer.write(toString());
            br.newLine();
            br.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
