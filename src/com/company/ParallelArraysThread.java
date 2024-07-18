package com.company;


import java.util.Objects;

public class ParallelArraysThread implements Runnable {

    int [] myArray;
    ParallelArraysThread(int[] myArray){
        this.myArray = myArray;
    }


    @Override
    public void run() {
        synchronized (myArray) {
            System.out.println(Thread.currentThread().getName() + " started");
            if(Objects.equals(Thread.currentThread().getName(), "MyThread_1"))
            System.out.println("Thread one find max " + getMax());
            if(Thread.currentThread().getName().equals("MyThread_2"))
            System.out.println("Thread two find min " + getMin());
            System.out.println(Thread.currentThread().getName() + " finished");
        }
    }
        public int getMin () {
            int min;
            min = myArray[0];
            for (int x : myArray) {
                if (x <= min)
                    min = x;
            }
            return min;
        }

        public int getMax () {
            int max;
            max = myArray[0];
            for (int x : myArray) {
                if (x >= max)
                    max = x;
            }
            return max;
        }


    }