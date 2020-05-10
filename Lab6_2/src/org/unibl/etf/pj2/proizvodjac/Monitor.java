package org.unibl.etf.pj2.proizvodjac;

import org.unibl.etf.pj2.proizvodi.Proizvod;

public class Monitor extends Proizvod {
    protected String conf;
    protected String model;

    public Monitor(){
        super();
    }

    public Monitor(String password, double cost, String name, Proizvodjac user, String conf, String model){
        super(password, cost, name, user);
        this.conf = conf;
        this.model = model;
    }

    public Monitor(String password, double cost, String name, String name1, String country, String email, String conf, String model){
        super(password, cost, name, name1, country, email);
        this.conf = conf;
        this.model = model;
    }

    public String getConf() {
        return conf;
    }

    public String getModel() {
        return model;
    }

    public void setConf(String conf) {
        this.conf = conf;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString(){
        return FormatOutPut() + "Konfiguracija: " + conf + "\nModel: " + model + "\n";
    }
}
