package com.pluralsight;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //polymorphism- the eat method is the one that is overriding,
        //Human class is the parent class, and caveman and modernperson are the child class
        //The eat method is taking on other forms in the child class derived from the parent class

        System.out.println("Human");
        Human human = new Human("Ray" , 55);
//        human.eat();
        feed("Human", human);

        System.out.println("============================");
        System.out.println("Caveman");
        Caveman caveman = new Caveman("Rocko", 35, 99, "Attack");
//        caveman.eat();
        feed("Caveman", caveman);


        System.out.println("============================");
        System.out.println("Modern Person");
        ModernPerson modernPerson = new ModernPerson("Hank", 18, 45, 789);
//        modernPerson.eat();
        feed("ModernPerson", modernPerson);

        System.out.println("============================");

        List<Human> people = new ArrayList<>();
        people.add(human);
        people.add(caveman);
        people.add(modernPerson);

        for (Human person : people) {
            System.out.println(person.getClass().getSimpleName());
            
        }

//        for (Human person : people) {
//
//            if (person instanceof Caveman) {
//                System.out.println("This is a caveman");
//            } else if (person instanceof ModernPerson) {
//                System.out.println("this is modern person");
                  // ModernPerson moderPerson1 = (ModernPerson) person;
                  // modernPerson1.drive();


//            }  else if (person instanceof Human) {
//                    System.out.println("this is human");
//                }
//
//            }
//            if (person instanceof Human){
//                System.out.println("This is a human");
//            }
//
//            if (person instanceof ModernPerson){
//                System.out.println("This is a human");
//            }
//
//            if (person instanceof Caveman){
//                System.out.println("This is a human");
//            }
        }

            System.out.println();
        }

//        for (Human person : people) {
//            person.eat();
//
//        }


//        Human human1;
//
//        human1 = new ModernPerson("Paul", 57, 15 , 67);
//        human1 = new Caveman("Fred", 56, 89, "Eating");


    }

    public static void feed(String label, Human human){
        System.out.println(label + "--->");
        human.eat();
    }

}
