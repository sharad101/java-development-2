package com.pluralsight;

public class Violinst extends Muscian{

    public Violinst(String name, String instrument) {
        super(name, instrument);
    }

    @Override
    public void perform() {
        System.out.println("I am a violin");
    }
}
