/*

    - ArrayList - niz promjenljive duzine
        - slicno vector samo sto nije sinhronizovano
        - kapacitet = kapacitet + 1/2*kapacitet

    - KONSTRUKTORI:
        - ArrayList();
        - ArrayList(Collection <? extends E> c);
        - ArrayList(capacity);
            - kapacitet pocetni(pocetni 10)
            - factor = 1


*/

import java.util.*;

public class ArrayList{
    public static void main(String []args){
        //stavili smo da je velicina jednaka 100
        List <Integer> a = new ArrayList<Integer>(100);

        //dodajemo elemente na mjesta koja su kreirana prethodnih 100
        for (int i=0;i<=20;i+=2){
            a.add(i);
        }

        System.out.println("Elementi vektora su: ");
        a.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println("Velicina vektora je: " + a.size());

        //smanjuje velicinu vektora tj njegove reference koje su vec definisane 100
        //ali size ispisuje isto
        ((ArrayList<Integer>) a).trimToSize();

        //u oba puta ispisuje isto jer size ispisuje trenutnih elemenata a ne njen kapacitet
        System.out.println("Velicina vektora je: " + a.size());

        //postavlja elemente na odg. vrijednosti poz - vrijednost
        a.set(2, 128);
        a.set(1, 120);

        System.out.println("Elementi vektora su: ");
        a.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();

        System.out.println("Elemente na zadnjoj poziciji je: " + a.get(a.size()-1));

        //sortira listu
        Collections.sort(a);
        
        /*

        Collections.sort(a, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return a > b ? 1 : a == b ? 0 : -1;
            }
        });
        
        */

        System.out.println("Elementi vektora su: ");
        a.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();

        //obrtanje liste
        Collections.reverse(a);

        //brise element na drugoj poziviji indeks
        a.remove(2);

        System.out.println("Elementi vektora su: ");
        a.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();

        //cisti listu - prazna
        a.clear();
    }
}
