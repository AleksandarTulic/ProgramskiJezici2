package org.unibl.etf.pj2.proizvodjac;

import org.unibl.etf.pj2.proizvodi.Proizvod;

import java.io.Serializable;

public class Softver extends Proizvod implements Serializable {
    protected String desc;

    public Softver(){
        super();
    }

    public Softver(String password, double cost, String name, Proizvodjac user, String desc){
        super(password, cost, name, user);
        this.desc = desc;
    }

    public Softver(String password, double cost, String name, String name1, String country, String email, String desc){
        super(password, cost, name, name1, country, email);
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String conf) {
        this.desc = conf;
    }

    @Override
    public String toString(){
        return FormatOutPut() + "Opis: " + desc + "\n";
    }
}
