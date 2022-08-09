package org.unibl.etf.pj2.proizvodjac;

enum Status{
    Active,
    Closed,
    Blocked
}

public class Proizvodjac {
    private String name;
    private String country;
    private String email;
    private Status status;

    public Proizvodjac(){
    }

    public Proizvodjac(String name, String country, String email){
        this.name = name;
        this.country = country;
        this.email = email;
        this.status = Status.Active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName(){
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String print(){
        return "Ime proizvodjaca: " + name + "\nDrzava: " + country + "\nEmail: " + email + "\nStatus: " + status + "\n";
    }
}
