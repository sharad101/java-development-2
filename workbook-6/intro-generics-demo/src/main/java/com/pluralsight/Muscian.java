package com.pluralsight;

public class Muscian {
    private String name;
    private String instrument;

    public Muscian(String name, String instrument) {
        this.name = name;
        this.instrument = instrument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public void perform(){
        System.out.println("I am performing");

    }




}
