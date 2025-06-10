package com.pluralsight;

public class Main {
    public static void main(String[] args) {
//       int  i= 0;
//
//        while (i < 10) {
//            System.out.println(i);
//            i++;
//
//        }

//        for(int i = 0; i < 10; i++){
//            System.out.println(i);
//        }

        int sum = 0;
        for (int i = 0; i <=10 ; i++) {
            if( i % 3 ==0) {
                break;
            }

            sum += i;
        }

        System.out.println(sum);
    }
}
