package net.etfbl.pj2;

public class Vatrogasac extends Osoba implements PozarPrepreka, StijenaPrepreka {
    public Vatrogasac(String ime, String oprema, double visina, int red){
        super(ime, oprema, visina, red);
    }

    @Override
    public String pozarPrepreka() {
        return new String("Pozar Ugasen.");
    }

    @Override
    public Object stijenaPrepreka() {
        return null;
    }
}
