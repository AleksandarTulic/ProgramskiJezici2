package org.unibl.etf.pj2.org.unibl.etf.pj2;

import org.unibl.etf.pj2.proizvodi.*;

public class cjenovnik {
    public Proizvod []a;

    public cjenovnik(){
    }

    public void printProizvodi(){
        System.out.println("Cjenovnik: ");
        for (Proizvod niz : a){
            System.out.println(niz);
            System.out.println("------------------------------");
        }
    }

    public Proizvod getProizvodSaSifrom(String password){
        for (Proizvod niz : a){
            Proizvod c = new Proizvod();
            c.setPassword(password);

            if ( c.equals(niz) ){
                return niz;
            }
        }

        return null;
    }

    public void printProizvodiName(String name){
        System.out.println("Proizvodi sa imenom " + name + " su: ");
        for (int i=0;i<a.length;i++){
            if ( name.equals(a[i].getName()) ){
                System.out.println(a[i]);
                System.out.println("------------------------------");
            }
        }
    }

    public void printProizvodiPassword(String password){
        System.out.println("Proizvodi sa sifrom " + password + " su: ");
        for (Proizvod niz : a){
            if ( password.equals(niz.getSifra()) ){
                System.out.println(niz);
                System.out.println("------------------------------");
            }
        }
    }
}
