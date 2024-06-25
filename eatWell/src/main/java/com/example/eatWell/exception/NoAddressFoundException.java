package com.example.eatWell.exception;

public class NoAddressFoundException extends Exception{

    public NoAddressFoundException(){
        super("No Address found with the given detail");
    }
}
