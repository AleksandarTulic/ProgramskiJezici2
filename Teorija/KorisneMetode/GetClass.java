/*

    - getClass() metoda vraca primjer Klase class
    - Najcesce koristimo da bismo dobili neke informacije iz te klase za koju smo pozvali
    - potrebno je da se importuju dole navedene 3 package-a
    - Da bi smo mogli definisati objekte pomocu kojih razgledamo te vrijednosti klase

*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test{
    public static void main(String []args){
        Class a = new ComputingMachine().getClass();
        Method b[] = a.getDeclaredMethods();
        for (Method c : b){
            System.out.println(c);
        }

        System.out.println("\n-----------------------------\n");

        Field c[] = a.getDeclaredFields();
        for (Field d : c){
            System.out.println(d);
        }

        System.out.println("\n-----------------------------\n");

        Constructor d[] = a.getDeclaredConstructors();
        for (Constructor e : d){
            System.out.println(e);
        }

        System.out.println("\n-----------------------------\n");

        a = new NewVersion().getClass();
        b = a.getDeclaredMethods();

        for (Method dd : b){
            System.out.println(dd);
        }

        System.out.println("\n-----------------------------\n");

        NewVersion e = new NewVersion(12, 0);
        try{
            e.dijeljenje();
        }catch (ZeroException ff){
            ff.printStackTrace();
        }
    }
}

class ComputingMachine{
    double a;
    double b;

    /*--------- KONSTRUKTORI ----------*/
    public ComputingMachine(){
    }

    public ComputingMachine(double a, double b){
        this.a = a;
        this.b = b;
    }

    /*--------- GET I SET ----------*/
    public void setA(double a){
        this.a = a;
    }

    public void setB(double b){
        this.b = b;
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }

    /*--------- OPERACIJE ----------*/

    public double saberi(){
        return a+b;
    }

    public double oduzmi(boolean flag){
        return flag ? a-b : b-a;
    }
}

class NewVersion extends ComputingMachine{
    public NewVersion(){
        super();
    }

    public NewVersion(double a, double b) {
        super(a, b);
    }

    public double mnozi(){
        return a*b;
    }

    public double dijeljenje() throws ZeroException{
        if ( b == 0.0 ) throw new ZeroException("Dijeljenje sa nulom1!!!");

        return a/b;
    }
}

class ZeroException extends Exception{
    public ZeroException(){
        super("Imamo dijeljenje sa nulom");
    }

    public ZeroException(String a){
        super(a);
    }
}
