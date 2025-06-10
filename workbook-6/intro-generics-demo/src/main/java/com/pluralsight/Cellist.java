package com.pluralsight;

public class Cellist extends Muscian{


    public Cellist(String name, String instrument) {
        super(name, instrument);
    }

    @Override
    public void perform() {
        System.out.println("I am a cellist");
    }
}
