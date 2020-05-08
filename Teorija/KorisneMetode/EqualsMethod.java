/*

    - EQUALS
        - vraca true ukoliko reference imaju istu vrijednost tj referenciraju isti objekat

*/

public class test{
    public static void main(String []args){
        Vozilo a = new Vozilo("Car", "T99", "Ford", 755.7);
        Vozilo b = new Vozilo("Car", "T99", "Ford", 756.7);
        Vozilo c = new Vozilo("Truck", "F201", "Mercedes", 12401.1);
        Vozilo d = new Vozilo("Car", "T99", "Ford", 755.7);

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
        System.out.println(a.equals(d));

        System.out.println(a.getType());
        System.out.println(d.getType());
        d = a; //vidimo da sada imaju iste reference pa kad smo promjenili vrijednost tipa kod a onda se promjenilo i kod B
               // ali equals opet vraca false zato sto smo napravili GRESKU kod weight poredjenja tj pretvorili smo jedno u String ali nismo drugo

        a.setType("Car12");
        System.out.println(a.getType());
        System.out.println(d.getType());
        System.out.println(a.equals(d));
    }
}

class Vozilo{
    private String type;
    private String model;
    private String name;
    private double weight;

    public Vozilo(){
    }

    public Vozilo(String a, String b, String c, double d){
        this.type = a;
        this.model = b;
        this.name = c;
        this.weight = d;
    }

    @Override
    public boolean equals(Object a){
        if ( a instanceof Vozilo ){
            Vozilo b = (Vozilo)a;
            if ( Double.toString(weight).equals(b.weight) && type.equals(b.type) && name.equals(name) && model.equals(model) ){
                return true;
            }
        }

        return false;
    }

    public String getType(){
        return type;
    }

    public void setType(String a){
        type = a;
    }
}

------------------------------------------------------------------------------------------------------------------------------

public class test{
    public static void main(String []args){
        Vozilo a = new Vozilo("Car", "T99", "Ford", 755.7);
        Vozilo b = new Vozilo("Car", "T99", "Ford", 756.7);
        Vozilo c = new Vozilo("Truck", "F201", "Mercedes", 12401.1);
        Vozilo d = new Vozilo("Car", "T99", "Ford", 755.7);

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
        System.out.println(a.equals(d));

        System.out.println(a.getType());
        System.out.println(d.getType());
        d = a;

        a.setType("Car12");
        System.out.println(a.getType());
        System.out.println(d.getType());
        System.out.println(a.equals(d));
        
        /*
        
          - Vraca true ma liniji 81 jer imaju iste vrijednosti kao i na liniji 90 jer sad referenciraju isto
        
        */
    }
}

class Vozilo{
    private String type;
    private String model;
    private String name;
    private double weight;

    public Vozilo(){
    }

    public Vozilo(String a, String b, String c, double d){
        this.type = a;
        this.model = b;
        this.name = c;
        this.weight = d;
    }

    @Override
    public boolean equals(Object a){
        if ( a instanceof Vozilo ){
            Vozilo b = (Vozilo)a;
            if ( Double.toString(weight).equals(Double.toString(b.weight)) && type.equals(b.type) && name.equals(name) && model.equals(model) ){
                return true;
            }
        }

        return false;
    }

    public String getType(){
        return type;
    }

    public void setType(String a){
        type = a;
    }
}

------------------------------------------------------------------------------------------------------------------------------

public class test{
    public static void main(String []args){
        Vozilo a = new Vozilo("Car", "T99", "Ford", 755.7);
        Vozilo b = new Vozilo("Car", "T99", "Ford", 756.7);
        Vozilo c = new Vozilo("Truck", "F201", "Mercedes", 12401.1);
        Vozilo d = new Vozilo("Car", "T99", "Ford", 755.7);

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));
        System.out.println(a.equals(d));

        System.out.println(a.getType());
        System.out.println(d.getType());
        d = a;

        a.setType("Car12");
        System.out.println(a.getType());
        System.out.println(d.getType());
        System.out.println(a.equals(d));
        
        /*
        
          - U ovom zadnjem slucaju nismo redefinisali metodu pa onda ce biti samo true na liniji 158 jer oni imaju istu referencu 
          - Dok ostali nemaju najbolji primjer a i d
          - Vidimo iako imaju iste vrijednosti opet ce biti equals razlicite
        
        */
    }
}

class Vozilo{
    private String type;
    private String model;
    private String name;
    private double weight;

    public Vozilo(){
    }

    public Vozilo(String a, String b, String c, double d){
        this.type = a;
        this.model = b;
        this.name = c;
        this.weight = d;
    }

    public String getType(){
        return type;
    }

    public void setType(String a){
        type = a;
    }
}
