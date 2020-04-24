package org.unibl.etf.pj2.predmet;

import java.util.*;
import org.unibl.etf.pj2.izuzetak.*;

public class Kvadar extends Predmet {
    protected double a,b,c;

    public Kvadar(double spec_weight){
        super(spec_weight);
        super.per_id = id;
    }

    @Override
    public void print() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("Zapremina = " + zapremina());
        System.out.println("Zapremina sa specificnom tezinom = " + super.tezina());
        System.out.println("Specificna tezina = " + super.spec_weight);
        System.out.println("Id = " + super.per_id);
    }

    @Override
    public void read() throws PredmetException {
        Scanner scan = new Scanner(System.in);

        System.out.print("a = ");
        a = scan.nextDouble();

        if ( a > 100 || a < 1 ) {
            throw new PredmetException();
        }

        System.out.print("b = ");
        b = scan.nextDouble();

        if ( b > 100 || b < 1 ){
            throw new PredmetException();
        }

        System.out.print("c = ");
        c = scan.nextDouble();

        if ( c > 100 || c < 1 ){
            throw new PredmetException();
        }
    }

    @Override
    public double zapremina() {
        return a*b*c;
    }
}
