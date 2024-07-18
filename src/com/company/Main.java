package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int[] myArray = new int[5];
        System.out.println("Put array");
        for (int x = 0; x<5; x++)
            myArray[x] = sc.nextInt();

        Thread myThread_1 = new Thread(new ParallelArraysThread(myArray));
        myThread_1.setName("MyThread_1");
        myThread_1.start();
        try {
            myThread_1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread myThread_2 = new Thread(new ParallelArraysThread(myArray));
        myThread_2.setName("MyThread_2");
        myThread_2.start();
        try {
            myThread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
