package org.unibl.etf.pj2.test;

import org.unibl.etf.pj2.izuzetak.PredmetException;
import org.unibl.etf.pj2.predmet.*;

public class TestPredmeti {
    public static void main(String []args) {
        Sfera a1 = new Sfera(2.49);
        Sfera b1 = new Sfera(12.16);

        try {
            a1.read();
            a1.print();
            b1.read();
            b1.print();
            System.out.println("Vecu zapremina ima " + (Predmet.poredjenje(a1, b1) == false ? 2 : 1) + " Sfera!");
        } catch (PredmetException e) {
            e.printStackTrace();
        }

        Kvadar a2 = new Kvadar(7.99);
        Kvadar b2 = new Kvadar(74.11);

        try {
            a2.read();
            a2.print();
            b2.read();
            b2.print();
            System.out.println("Vecu zapremina ima " + (Predmet.poredjenje(a1, b1) == false ? 2 : 1) + 1 + " Kvadar!");
        }catch (PredmetException e){
            e.printStackTrace();
        }
    }
}
