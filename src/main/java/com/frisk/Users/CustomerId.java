package com.frisk.Users;

public class CustomerId {

    private static CustomerId instance;
    private static int nextId = 1001;

    private CustomerId(){}

    public static synchronized CustomerId getInstance(){
        if(instance == null){
            instance = new CustomerId();
        }
        return instance;
    }

    public synchronized int generateId(){
        return nextId++;
    }
}
