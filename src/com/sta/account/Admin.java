package com.sta.account;

public class Admin extends Account {
    public Admin() {
        super();
    }
    public Admin(String email, String password) {
        super(email, password);
    }

    @Override
    public String toString() {
        return "Admin [username=" + super.getUsername() + ", password=" + super.getPassword() + "]";
    }
}
