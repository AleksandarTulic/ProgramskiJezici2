package net.etfbl.pj2;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class Pair{
    private int x,y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Simulacija {
    public static Object [][]m = new Object[3][20];
    private static HashMap<Pair, Boolean> flag = new HashMap<Pair, Boolean>();

    public static void createTraps(String naziv){
        Random rand = new Random();

        int br = 0;
        while ( br < 4 ){
            int x = rand.nextInt(3);
            int y = rand.nextInt(20);

            if ( !flag.containsKey(new Pair(x, y)) ){
                br++;
                m[x][y] = new Prepreka(naziv);
                flag.put(new Pair(x, y), true);
            }
        }
    }

    public static void main(String[] args) {
        createTraps("Voda");
        createTraps("Stijena");
        createTraps("Vatra");

        Plivac a = new Plivac("Aleksandar", "Naocare",1.85 , 0);
        Vatrogasac b = new Vatrogasac("David", "Maska", 1.73, 1);
        Planinar c = new Planinar("Eskobar", "Rukavice", 1.91, 2);
        a.start();
        b.start();
        c.start();

        Scanner scan = new Scanner(System.in);

        while ( "EXIT".equals(scan) ){
            String option = scan.nextLine();
            if ( "NASTAVAK".equals(option) ){
                try {
                    a.stop = b.stop = c.stop = false;
                    synchronized (a) {
                        a.notify();
                    }

                    synchronized (b) {
                        b.notify();
                    }

                    synchronized (c) {
                        c.notify();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if ( "PREKID".equals(option) ){
                a.stop = b.stop = c.stop = true;
            }
        }
    }
}
