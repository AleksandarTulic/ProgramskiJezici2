package org.unibl.etf.pj2.proizvodi;

import org.unibl.etf.pj2.proizvodjac.Proizvodjac;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Proizvod implements Serializable {
    protected String password;
    protected double cost;
    protected String name;
    protected Proizvodjac user;

    public Proizvod(){
        super();
    }

    public Proizvod(String password, double cost, String name, Proizvodjac user){
        this.password = password;
        this.cost = cost;
        this.name = name;
        this.user = user;
    }

    public Proizvod(String password, double cost, String name, String name1, String country, String email){
        this.password = password;
        this.cost = cost;
        this.name = name;
        this.user = new Proizvodjac(name1, country, email);
    }

    public String FormatOutPut(){
        return "Sifra: " + password + "\nCijena" + cost + "\nNaziv: " + name + "\n" + user.print();
    }

    @Override
    public String toString(){
        return FormatOutPut();
    }

    @Override
    public boolean equals(Object a){
        if ( a instanceof Proizvod ){
            Proizvod b = (Proizvod)a;
            if ( password.equals(b.password) ){
                return true;
            }
        }

        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSifra(){
        return password;
    }

    public String getName() {
        return name;
    }

    public double getTrosak(){
        return cost;
    }

    public void setName(String name){
        this.name = name;
    }
}
