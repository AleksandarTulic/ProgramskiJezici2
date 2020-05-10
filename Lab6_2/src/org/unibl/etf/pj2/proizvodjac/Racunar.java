package org.unibl.etf.pj2.proizvodjac;

import org.unibl.etf.pj2.proizvodi.Proizvod;

public class Racunar extends Proizvod {
    protected String conf;

    public Racunar(){
        super();
    }

    public Racunar(String password, double cost, String name, Proizvodjac user, String conf){
        super(password, cost, name, user);
        this.conf = conf;
    }

    public Racunar(String password, double cost, String name, String name1, String country, String email, String conf){
        super(password, cost, name, name1, country, email);
        this.conf = conf;
    }

    public String getConf() {
        return conf;
    }

    public void setConf(String conf) {
        this.conf = conf;
    }

    @Override
    public String toString(){
        return FormatOutPut() + "Konfiguracija: " + conf + "\n";
    }
}
