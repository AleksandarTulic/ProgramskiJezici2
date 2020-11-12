package net.etfbl.pj2;

public class Prepreka {
    private String naziv;

    public Prepreka(String naziv){
        this.naziv = naziv;
    }

    //SET

    public void setNaziv(String naziv){
        this.naziv = naziv;
    }

    //GET

    public String getNaziv(){
        return naziv;
    }

    //OUTPUT

    public String toString(){
        return "Vrsta prepreke: " + naziv;
    }
}
