/*

    protected Object clone() throws CloneNotSupportedException

    - Vrsi plitko kopiranje - vrsi se kopiranje vrijednosti referenci a ne samih vrijednosti na koje
reference pokazuju
    - Ako se redefinise bilo bi pozeljno da bude tipa public
    - Ukoliko redeklarisemo metodu CLONE potrebno je da implementiramo interface Cloneable jer
u suprotnom moze da se deci Exception prethodno navedeni

*/

public class test{
    int a;
    boolean flag;

    test test(){
        try{
            return (test)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return this;
        }
    }

    public static void main(String []args){
        test a = new test();
        test b;
        a.a = 12;
        a.flag = false;
        b = a.test();

        System.out.println(a.a + " " + a.flag);
        System.out.println(b.a + " " + b.flag);

        a.flag = true;
        System.out.println(a.a + " " + a.flag);
        System.out.println(b.a + " " + b.flag);

        /*

            - vidimo da ukoliko promjenimo vrijednost jedne promjenljive da sadrzaj ostaje isti kod druge
            - Sto zanci da se ne kopiraju reference vec samo vrijednosti a stvara se nova referenca
            - Ali vazno je napomenuti da OVO VAZI SAMO ZA PRIMITIVNE TIPOVE I REFERENCE

        */
    }
}

--------------------------------------------------------------------------------------------------------------------------------

public class test{
    Auto a;

    public test(){
        a = new Auto();
    }

    public test(String name, int maxSpeed){
        a = new Auto(name, maxSpeed);
    }

    test clone1(){
        try{
            return (test)super.clone(); // poziva clone metodu iz nadklase sa super.
        }catch (CloneNotSupportedException e){ //ukoliko se nemogne kopirati baca se ova greska
            System.out.println("Ovde nesto ne valja!!!");
            return this;
        }
    }

    public static void main(String []args){
        test some1 = new test("BMW", 210);
        System.out.println(some1.a);
        test some2;
        some2 = some1.clone1();
        System.out.println(some2.a);
        some1.a.setMaxSpeed(245);
        System.out.println(some1.a);
        System.out.println(some2.a);

        /*

            - Sada mozemo vidjeti da kada promjenimo vrijednost u some1 onda se mijenja i vrijednost u some2
            - Ovo sto smo predstvaljali u prethodna dva primjera je Plitko Kopiranje
            - Ukoliko su neke slozenije klase tj nisu primitivne onda se kopira po referenci

        */
    }
}

class Auto{
    public String name;
    public int maxSpeed;

    public Auto(){
    }

    public Auto(String name, int maxSpeed){
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString(){
        return "Naziv: " + name + "\n" + "Maksimalna brzina: " + maxSpeed + "\n\n";
    }
}

--------------------------------------------------------------------------------------------------------------------------------

import javax.xml.catalog.Catalog;
import java.util.Calendar;

public class test implements Cloneable{
    int a;
    double b;
    /*
        u prethodnom primjeru imali smo try pa ono bi pozivalo clone metodu od nadklase i pokusalo kopirati ako nema greske
        a ovde mi implementiramo clone metodu pa je potrebno da bacamo izuzetak
    */

    public test(){
    }

    public test(int a, double b){
        this.a = a;
        this.b = b;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        test a = new test();
        a.a = this.a;
        a.b = this.b;
        return (Object)a;
    }

    public static void main(String []args){
        test a = new test(12, 4.56);

        System.out.println(a.a + " | " + a.b);

        test b;

        try{
            b = (test)a.clone();
            System.out.println(a.a + " | " + a.b);
            System.out.println(b.a + " | " + b.b);
            /*
            
                - Gore navedena clone metoda je implementirana tako da kreira novu referencu tipo objekta test
                - Tako da i kada kloniramo slozenije oblike nece se samo referenca kopirati vec se stvoriti nova referenca
            koja ima kopirani sadrzaj iz a objekta
            
                - A mogli smo ostaviti kao i u proslom slucaju return (Object)super.clone()
                - Ali onda bi se desio npr slucaj kao u proslom primjeru
            
            */
        } catch ( CloneNotSupportedException e ){
            System.out.println("Nesto nevalja !!!");
        }
    }
}
