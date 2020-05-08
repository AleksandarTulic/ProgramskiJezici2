/*

    - public String toString()
        - vraca string reprezentaciju objekta
        - ukoliko nije redefinisana izlaz kada se pozove je ljedeci:
            - <naziv klase>@<hash vrijednost objekta>
        - zato se najcesce i redefinise za nase potrebe kao na primjer ispis elemenata neke klase za odgovarajuci objekat

*/

public class test{
    public static void main(String []args){
        Phone a = new Phone("Nokia", "3399", 0);
        System.out.println(a);

        a.setName("Samsung");
        a.setType("Galaxy");
        a.setMp(12);

        System.out.println(a);
    }
}

class Phone{
    private String type;
    private String name;
    private int mp;

    public Phone(){}

    public void setType(String type) {
        this.type = type;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone(String type, String name, int mp){
        this.type = type;
        this.name = name;
        this.mp = mp;
    }

    @Override
    public String toString(){
        return "Naziv telefona: " + name + "\nTip telefona: " + type + "\nMegapiksela kamera: " + mp + "\n";
    }
}

-----------------------------------------------------------------------------------------------------------------------------

public class test{
    public static void main(String []args){
        Phone a = new Phone("Nokia", "3399", 0);
        System.out.println(a);

        a.setName("Samsung");
        a.setType("Galaxy");
        a.setMp(12);

        System.out.println(a);
    }
}

class Phone{
    private String type;
    private String name;
    private int mp;

    public Phone(){}

    public void setType(String type) {
        this.type = type;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone(String type, String name, int mp){
        this.type = type;
        this.name = name;
        this.mp = mp;
    }
}
