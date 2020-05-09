import java.io.IOException;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws Exception {
        Auto a = new Auto("Mercedes", "C200", 189.4, 77);
        System.out.println(a.getName());
        System.out.println(a.getModel());
        System.out.println(a.kmTravel(45)); //ispisuje na satima

        try {
            FileOutputStream b = new FileOutputStream("D:\\FAKULTET\\a.ser");
            ObjectOutputStream c = new ObjectOutputStream(b);
            c.writeObject(a);
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            FileInputStream b = new FileInputStream("D:\\FAKULTET\\a.ser");
            ObjectInputStream c = new ObjectInputStream(b);
            Auto d = (Auto)c.readObject();
            c.close();
            System.out.println(d.getModel());
            System.out.println(d.getName());
            System.out.println(d.kmTravel(90));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

//ZNACI POTREBNO JE IMPLEMENTIRATI KAO SERIAZIBLE
//U SUPROTNOM CE BITI NOTSERIAZIBLEEXCEPTION
class Auto implements Serializable{
    private String name;
    private String model;
    private double maxSpeed;
    private double maxFuel;

    public Auto(){
    }

    public Auto(String name, String model, double maxSpeed, double maxFuel){
        this.name = name;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFuel = maxFuel;
    }

    //koristeci makiskmalnu brzinu za koliko ce preci zadatu klilometrazu
    public double kmTravel(int km){
        return (double)km/maxSpeed;
    }

    public String getModel(){
        return model;
    }

    public String getName(){
        return name;
    }
}
