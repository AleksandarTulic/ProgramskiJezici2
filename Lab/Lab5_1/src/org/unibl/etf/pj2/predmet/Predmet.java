package org.unibl.etf.pj2.predmet;

import org.unibl.etf.pj2.izuzetak.*;

public abstract class Predmet {
    protected double spec_weight;
    protected static int id;
    protected int per_id;

    public Predmet(double weight){
        this.spec_weight = weight;
        id++;
    }

    public abstract void print();
    public abstract void read() throws PredmetException;
    public abstract double zapremina();

    public double tezina(){
        return spec_weight * zapremina();
    }

    public static boolean poredjenje(Predmet a, Predmet b) {
        return a.zapremina() > b.zapremina();
    }
}
