package net.etfbl;

import java.util.Random;

public class Trka {
    public static void main(String[] args) {
        Object [][]m = new Object[3][15];

        Random rand = new Random();
        for (int i=0;i<4;i++){
            int row = rand.nextInt(3);
            int column = rand.nextInt(15);

            m[row][column] = new String("Stop");
        }

        Automobil a = new Automobil(m, 0, "Mercedes");
        Automobil b = new Automobil(m, 1, "Ford");
        Automobil c = new Automobil(m, 2, "Volvo");
        a.start();
        b.start();
        c.start();
    }
}

class Automobil extends Thread{
    private int id;
    private String type;
    private Object [][]m;
    private int red;
    public static Boolean flag = false;

    public Automobil(Object [][]m, int red, String type){
        this.m = m;
        this.red = red;
        this.type = type;

        id = (new Random()).nextInt(10000 - 5000 + 1) + 5000;
    }

    public void run(){
        for (int i=0;i<15;i++){
            if ( "Stop".equals(m[red][i]) ){
                System.out.println("Auto tipa: " + type + " ceka 5 sekundi!!!");
                try{
                    sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            m[red][i] = this;

            System.out.println(this + "Kolona: " + i);

            try{
                sleep(2000);
            }catch (Exception e){
                e.printStackTrace();
            }

            if ( i == 14 ){
                synchronized (flag){
                    if ( !flag ){
                        flag = true;
                        System.out.println("Pobijedio je: " + this);
                        break;
                    }
                }
            }

            if ( flag ){
                System.out.println("Izgubio je: " + this);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Auto tip: " + type + ", id: " + String.valueOf(id);
    }
}
