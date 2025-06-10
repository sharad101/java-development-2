package com.pluralsight;



public class EtchaSketch implements IDrawable, ICleaner {
    private String drawing;

    public EtchaSketch(String drawing) {
        this.drawing = drawing;
    }

    public String getDrawing() {
        return drawing;
    }

    @Override
    public void draw(){
        this.drawing += "Drawing...";
        System.out.println("Drawing etch a sketch");

    }

    @Override
    public void print() {
        IDrawable.super.print();
    }

    @Override
    void clean() {
        this.drawing = " ";
        System.out.println("etch a sketch has been clean");
    }
}
