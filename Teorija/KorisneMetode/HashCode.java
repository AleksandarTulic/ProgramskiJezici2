/*
public int HashCode()
  - vraca hash vrijednost objekta u int
  - ako su dva objekta ista po EQUALS metodi onda oni trebaju imati iste hash-ove

Primjeri: 
*/  

// provjerava da li u set-u phones postoji telefon blackberry sa datim tipom
// set je sekvenca hash vrijednosti objekata
// i kada radimo .add onda dodajemo hash vrijednosti objekata

public class SearchingObject(){
  public static void main(String []args){
    Set <Phones> phones = new HashSet<>();
    Phone s1 = new Phone("Iphone", "T99");
    Phone s2 = new Phone("BlackBerry", "M01");
    phones.add(s1);
    phones.add(s2);
    boolean res = phones.contains(new Phone("BlackBerry", "M01"));
    System.out.println(res);
  }
}

public class test{
    public static void main(String []args){
        Phone a1 = new Phone("Nokia", "Galaxy");
        Phone a2 = new Phone("Iphone", "X");
        Phone a3 = new Phone("Nokia", "G9");
        Phone a4 = new Phone("Nokia", "G9");
        System.out.println(a1.HashCode());
        System.out.println(a2.HashCode());
        System.out.println(a3.HashCode());
        System.out.println(a4.hashCode());
        System.out.println(a4.equals(a3));

        /*
            primjecujemo da a3 i a4 nemaju isti hash jer to su reference na memorijske lokacije
            a samo ukoliko pokazuju na istu lokaciju onda ce imati isti hash kao sto vidimo dalje u primjerima
        */
        a4 = a3;
        System.out.println(a4.hashCode() + " " + a3.hashCode());
        
        /*
            Posto smo redefinisali metodu equals tako da
                - ukoliko su vrijednosti na koje pokazuju reference iste onda je to isto
            Da nismo ovo implementirali odna bi na liniji 24 bilo FALSE a u ovom slucaju je TR UE
        */
    }
}

class Phone{
    private String manu;
    private String module;

    public Phone(){
    }

    public Phone(String a, String b){
        manu = a;
        module = b;
    }

    public int HashCode(){
        int hash = 7;

        hash = 11 * hash + manu.hashCode();
        hash = 11 * hash + module.hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object a){
        if ( a instanceof Phone ){ //provjeravali smo da li je a tipa klase Phone jer ako nije nemamo atribute za porediti pa kada bi smo htjeli dohvatiti bila bi greska
            Phone b = (Phone)a; //eksplicitna konverzija objekta tipa Object u Objekat tipa Phone
            return manu.equals(b.manu) && module.equals(b.module); // poredimo da li su vrijednosti iste objekta b koji je parametar i vrijednosti od strane objekta od kog je pozvano tj this.
        }

        return false;
    }
}

