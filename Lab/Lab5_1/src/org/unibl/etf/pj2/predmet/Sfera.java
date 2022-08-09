package org.unibl.etf.pj2.predmet;

import org.unibl.etf.pj2.izuzetak.PredmetException;

import java.sql.SQLOutput;
import java.util.*;
import java.lang.Math;

public class Sfera extends Predmet{
    protected double r;

    public Sfera(double spec_weight){
        super(spec_weight);
        super.per_id = id;
    }

    @Override
    public void read() throws PredmetException {
        Scanner scan = new Scanner(System.in);
        System.out.print("r = ");
        this.r = scan.nextDouble();

        if ( r > 100 || r < 1 ){
            throw new PredmetException();
        }

        System.out.print("Specificna tezina = ");
        super.spec_weight = scan.nextDouble();
    }

    @Override
    public void print(){
        System.out.println("Id = " + super.per_id);
        System.out.println("Specificna tezina = " + super.spec_weight);
        System.out.println("Poluprecnik = " + r);
        System.out.println("Zapremina sfere = " + zapremina());
        System.out.println("Zapremina sa specificnom tezinom = " + super.tezina());
    }

    @Override
    public double zapremina(){
        return 4/3*3.14*Math.pow(r, 3);
    }
}
