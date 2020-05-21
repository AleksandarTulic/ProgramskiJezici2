/*
    - COLLECTION
        - SET
            - SORTEDSET
                - NAVIGABLE MAP
        - LIST
        - QUEUE
        - DEQUE
*/

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.UnaryOperator;

public class Kolekcija{
    public static void main(String []args){
        Collection<Integer> a = new ArrayList<Integer>();
        for (int i=0;i<=100;i+=3){
            a.add(i);
        }

        System.out.println("Da li je lista prazna: " + a.isEmpty());

        System.out.println("Velicina kolekcije: " + a.size());

        System.out.println("Da li sadrzi element 60: " + a.contains(60));

        System.out.println("Da li smo uspjesno obrisali element 60: " + a.remove(60));

        System.out.println("Da li sadrzi element 60: " + a.contains(60));

        System.out.println("Da li smo uspjesno dodali element 60: " + a.add(60)); //samo sto se sada dodaje na kraj

        System.out.println("Da li sadrzi element 60: " + a.contains(60));

        //na osnovu nekog uslova izbacuje elemente
        a.removeIf(n -> (n == 60));

        System.out.println("Da li sadrzi element 60: " + a.contains(60));

        Collection<Integer> b = new ArrayList<Integer>();
        b.add(3); b.add(6); b.add(12); b.add(45); b.add(789); b.add(-450); b.add(12);

        Collection<Integer> c = new ArrayList<Integer>();
        c.add(60); c.add(6); c.add(12);

        System.out.println("Da li sadrzi sve elemente iz b: " + a.containsAll(b));

        System.out.println("Da li sadrzi sve elemente iz c: " + a.containsAll(c));

        a.removeAll(c);

        System.out.println("Da li imamo element 6 i 12: " + a.contains(6) + " " + a.contains(12));

        Object []niz = b.toArray();
        for (Object buff : niz){
            System.out.println(buff);
        }

        String arr = "Danas je suncan dan :)";
        System.out.println("Stari String je: " + arr);

        //zamjenjuje sve instance a sa A
        System.out.println("Novi String je: " + arr.replaceAll("a", "A"));

        List<String> arr1 = new ArrayList<String>(Arrays.asList("Kuca", "PA VeLis", "Ovde VRUce"));

        System.out.println(arr1);

        //dva razlicita nacina da se implementira transformacija u mala slova
        //arr1.replaceAll(e->e.toLowerCase());
        arr1.replaceAll(new MyOperator());

        System.out.println(arr1);

        //popunjava niz sa elementima drugog parametra sa onolikom velicinom koliku imaju
        //u nasem slucaju tri
        Collections.fill(arr1, "Something has happened");

        System.out.println(arr1);

        List <String> arr2 = new ArrayList<String>(100);
        Collections.fill(arr2, "DO");

        //iako smo gore inijalizovali da je kapacitet 100 ono nece staviti vrijednosti
        //zato sto prethodno nije bilo nikakvih elemenata
        //tj referenci na koje da pokazuje
        System.out.println(arr2);
    }
}

class MyOperator implements UnaryOperator<String> {
    @Override
    public String apply(String t){
        return t.toLowerCase();
    }
}
