import java.io.*;
import java.time.LocalDate;

public class SerializationUtil<T> {
    public static <T> T readObject(String fullPath){
        try {
            ObjectInputStream a = new ObjectInputStream(new FileInputStream(fullPath));
            return (T)a.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static <T> boolean save(T object, String path, String filename){
        try{
            ObjectOutputStream a = new ObjectOutputStream(new FileOutputStream(path + "\\" +
                    filename));
            a.writeObject(object);
            a.close();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String []args){
        Auto a = new Auto(210, LocalDate.now(), "Mercedes MClaren", "Someone", "Something");
        Telefon b = new Telefon(455.7, "Camera: 17MP, weight: 230g, size: 5,5 inc...");

        System.out.println("Prije serijalizacije: ");
        System.out.println(a);
        System.out.println(b);

        try {
            if (save(a, "C:\\Users\\Tula\\IdeaProjects\\Lab9_03", "auto.ser")) {
                System.out.println("Uspjesno smo izvrsili serijalizaciju :)");
            }

            if (save(b, "C:\\Users\\Tula\\IdeaProjects\\Lab9_03", "telefon.ser")) {
                System.out.println("Uspjesno smo izvrsili serijalizaciju :)");
            }

            Auto c = readObject("C:\\Users\\Tula\\IdeaProjects\\Lab9_03\\auto.ser");
            Telefon d = readObject("C:\\Users\\Tula\\IdeaProjects\\Lab9_03\\telefon.ser");
            System.out.println("Poslije serijalizacije: ");
            System.out.println(c);
            System.out.println(d);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Auto implements Serializable {
    private int maxSpeed;
    private String name;
    private LocalDate when;
    private String ownerName;
    private String ownerSurnName;

    public Auto(){
    }

    public Auto(int maxSpeed, LocalDate when, String name, String ownerName, String ownerSurnName){
        this.maxSpeed = maxSpeed;
        this.when = when;
        this.name = name;
        this.ownerName = ownerName;
        this.ownerSurnName = ownerSurnName;
    }

    @Override
    public String toString(){
        return "Maks. brzina: " + maxSpeed + "\nKupljeno[yy-mm-dd]: " + when.getYear() + "-" + when.getMonth() + "-" + when.getDayOfWeek() + "\nNaziv auta: " + name + "\nKupac: " + ownerName + "\nPrezime: " + ownerSurnName + "\n";
    }
}

class Telefon implements Serializable{
    private double cost;
    private String desc;

    public Telefon(){
    }

    public Telefon(double cost, String desc){
        this.cost = cost;
        this.desc = desc;
    }

    @Override
    public String toString(){
        return "Cijena: " + cost + "\nOpis: " + desc + "\n";
    }
}
