package com.example.eatWell.enums;

public enum OrderStatus {

    ORDERED("ORDERED"), ONTHEWAY("ONTHEWAY"), DELIVERED("DELIVERED"), CANCELED("CANCELED");
    private final String type;
    OrderStatus(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
}
