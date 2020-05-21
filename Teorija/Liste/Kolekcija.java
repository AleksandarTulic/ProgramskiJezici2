/*

    - COLLECTION
        - SET
            - SORTEDSET
                - NAVIGABLE MAP
        - LIST
        - QUEUE
        - DEQUE

*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
        b.add(3); b.add(6); b.add(12);

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
    }
}
