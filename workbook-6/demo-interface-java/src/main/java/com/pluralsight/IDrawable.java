package com.pluralsight;

public interface IDrawable {
    void draw();

    default void print(){
        System.out.println("this object can draw things");
    }

}
