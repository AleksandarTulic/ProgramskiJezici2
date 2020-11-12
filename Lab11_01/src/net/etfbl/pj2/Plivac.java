package net.etfbl.pj2;

public class Plivac extends Osoba implements PlivanjePrepreka, StijenaPrepreka{
    public Plivac(String ime, String oprema, double visina, int red){
        super(ime, oprema, visina, red);
    }

    @Override
    public Object plivanjePrepreka() {
        return null;
    }

    @Override
    public Object stijenaPrepreka() {
        return null;
    }
}
