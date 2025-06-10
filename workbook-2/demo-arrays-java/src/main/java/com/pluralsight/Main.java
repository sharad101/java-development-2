package com.pluralsight;

public class Main {
    public static void main(String[] args) {


        int [] listofNum = {10, 23, 45 ,65 ,34, 12};

        int [] num = new int[6];

        System.out.println(listofNum[3]);


//        for (int i = 0; i < listofNum.length; i++) {
//            System.out.println(listofNum[i]);
//
//        }
//
//        int i = 0;
//
//        while( i< listofNum.length){
//            System.out.println(listofNum[i]);
//            i ++;
//        }

        System.out.println();
        System.out.println("====================");

//        newArrayofNumbers[2] = 15;
//
//        for (int i = 0; i < ; i++) {
//
//        }

        int[] list = {63, 65, 60, 53, 58, 37, 35, 31};
        displayNumbers(list);

        System.out.println("====================");

        int[] arrayFromMethod = getNumbers();
        displayNumbers(arrayFromMethod);
    }

    public static void displayNumbers(int[] list){

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + " ");

        }

        System.out.println();

    }

    public static int [] getNumbers(){
        int[] num = {63, 65, 60, 53, 58, 37, 35, 31};
        return num;
    }
}
