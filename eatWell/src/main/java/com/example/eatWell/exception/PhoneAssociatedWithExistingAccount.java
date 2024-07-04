package com.example.eatWell.exception;

public class PhoneAssociatedWithExistingAccount extends Exception{

    public PhoneAssociatedWithExistingAccount(){
        super("Phone already Associated with a existing account");
    }
}
