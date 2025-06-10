package com.pluralsight;

public interface  ICleaner {
    void clean();
    
    default void print(){
        System.out.println("I can clean");
    }
}
