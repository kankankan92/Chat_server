package com.company;

public class User {
    private String name;
    private boolean status;

    User(String name){
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName(){
        return name;
    }
}
