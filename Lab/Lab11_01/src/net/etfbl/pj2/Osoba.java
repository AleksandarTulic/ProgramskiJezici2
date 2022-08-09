package net.etfbl.pj2;

import java.util.Date;

public class Osoba extends Thread{
    private double visina;
    private String ime;
    private String oprema;
    public boolean stop = false;
    private int red;

    public Osoba(String ime, String oprema, double visina, int red){
        this.ime = ime;
        this.oprema = oprema;
        this.visina = visina;
        this.red = red;
    }

    public void run(){
        long time = new Date().getTime();
        for (int i=0;i<20;i++){
            System.out.println(this + "\nKolona: " + i);
            if ( stop ) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            try{
                sleep(1000);

                if ( Simulacija.m[red][i] instanceof Prepreka ){
                    String naziv = ((Prepreka) Simulacija.m[red][i]).getNaziv();
                    if ( naziv.equals("Stijena") && this instanceof StijenaPrepreka ){
                        Simulacija.m[red][i] = ((StijenaPrepreka) this).stijenaPrepreka();
                    }else if ( naziv.equals("Voda") && this instanceof PlivanjePrepreka ){
                        Simulacija.m[red][i] = ((PlivanjePrepreka) this).plivanjePrepreka();
                    }else if ( naziv.equals("Vatra") && this instanceof PozarPrepreka ){
                        Simulacija.m[red][i] = ((PozarPrepreka) this).pozarPrepreka();
                    }else{
                        System.out.println("------------------------------------------");
                        System.out.println(this + "\nOsoba ne moze da prevazidje prepreku: " + naziv);
                        System.out.println("------------------------------------------");
                        sleep(3000);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        long vrijeme = new Date().getTime() - time;
        System.out.println(this + "\nTrajanje: " + vrijeme);
    }

    public String toString(){
        return "Ime: " + ime + "\n" + "Visina: " + visina + "\n" + "Oprema: " + oprema;
    }
}
