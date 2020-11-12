package net.etfbl.pj2;

import java.util.Random;
import java.util.Scanner;

public class CounterMain {
    public static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("Unesite broj niti: ");
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        for (int i=0;i<n;i++){
            CounterThread a = new CounterThread("NIT_" + String.valueOf(i), rand.nextInt(10000 - 5000 + 1) + 5000);
            a.start();
        }
    }
}

class CounterThread extends Thread{
    private String name;
    private int counter;

    public CounterThread(String name, int counter){
        super();
        this.name = name;
        this.counter = counter;
    }

    public void run(){
        int sum = 0;
        for (int i=0;i<counter;i++){
            sum+=i;
        }

        System.out.println("NAZIV: " + name + ", Suma: " + sum);
    }
}

