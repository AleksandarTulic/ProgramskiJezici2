package org.unibl.etf.pj2.org.unibl.etf.pj2;

import org.unibl.etf.pj2.proizvodi.Proizvod;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class racun implements Serializable {
    public Proizvod []a = new Proizvod[0]; //da prikaze a.length = 0
    LocalDate b = LocalDate.now();
    public double cost;

    public racun(){
    }

    public void addProizvod(Proizvod p) {
        if (p != null){
            Proizvod[] tmp = new Proizvod[a.length + 1];
            System.arraycopy(a, 0, tmp, 0, a.length);
            tmp[a.length] = p;
            a = tmp;
        }
    }

    public void deleteProizvod(Proizvod p){
        if ( p != null ){
            Proizvod []tmp = new Proizvod[a.length-1];
            int i = 0;
            for (i=0;i<a.length;i++){
                if ( p.equals(a[i]) ){
                    break;
                }

                tmp[i] = a[i];
            }

            for (i++;i<a.length;i++){
                tmp[i] = a[i];
            }

            a = tmp;
        }
    }

    public void showList(){
        System.out.println("Kupovina dosadasnja: ");
        for (Proizvod niz : a){
            System.out.println("Naizv: " + niz.getName() + "\nSifra: " + niz.getSifra() + "\nTrosak: " + niz.getTrosak());
        }
    }

    public void buy(){
        System.out.println("Datum: " + b.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println("----------------------------------");

        for (Proizvod niz : a){
            cost+=niz.getTrosak();
            System.out.println("Naizv: " + niz.getName() + "\nSifra: " + niz.getSifra() + "\nTrosak: " + niz.getTrosak());
        }

        System.out.println("Ukupna potrosnja: " + cost);
        System.out.println("----------------------------------");
    }
}
