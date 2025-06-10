package com.pluralsight;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();

        ArrayList<Object> things = new ArrayList<>();

        things.add(new Robot("Bolts"));
        things.add(new RobotVaccum("NotSweeper"));
        things.add(new EtchaSketch());

        for (Object thing : things) {
            if(thing instanceof ICleaner){
                ICleaner cleaner = (ICleaner) thing;
                cleaner.clean();
            }
            
        }

        System.out.println("================================");
        EtchaSketch sketch = new EtchaSketch();
        sketch.print();

        System.out.println("================================");

        RobotVaccuum robotVaccuum = new RobotVaccuum("Potato");
        robotVaccuum.goHome();

        List<String> names = new ArrayList<>();
        names = new LinkedList<>();
    }
}
