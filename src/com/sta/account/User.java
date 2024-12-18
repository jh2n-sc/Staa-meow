package com.sta.account;

public class User extends Account{
    public User() {
        super();
    }
    public User(String email, String password) {
        super(email, password);
    }

    @Override
    public String toString() {
        return "User [username=" + super.getUsername() + ", password=" + super.getPassword() + "]";
    }
}
