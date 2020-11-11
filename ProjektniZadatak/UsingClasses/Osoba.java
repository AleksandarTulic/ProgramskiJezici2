import java.util.Random;

public class Osoba{
    private String name, surnName, id;
    private int year;
    private boolean gender;
    private Pair id_House;
    private double temp;
    private Human type;

    Osoba(){
    }

    Osoba(String id, String name, String surnName, int year, boolean gender, Human type){
        this.id = id;
        this.name = name;
        this.surnName = surnName;
        this.year = year;
        this.gender = gender;
        this.type = type;
    }

    Osoba(String id, String name, String surnName, int year, boolean gender, Pair id_House){
        this.id = id;
        this.name = name;
        this.surnName = surnName;
        this.year = year;
        this.gender = gender;
        this.id_House = id_House;
    }

    public void setTemp(double temp){
        this.temp = temp;
    }

    public double getTemp(){
        return temp;
    }

    public void randomTemp(){
        setTemp((double)Math.round(((new Random()).nextDouble() * 6 + 35) * 10)/10);
    }

    public void setId_House(Pair id_House){
        this.id_House = id_House;
    }
}
