/*

    - OBILAZAK LISTE
        1. POMOCU PETLJE
        2. POMOCU ITERATORA
        3. POMOCU SPLITERATORA
        4. POMOCU STREAM-OVA

*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Obilazak{
    public static void main(String []args){
        Collection<Integer> a = new ArrayList<Integer>();
        a.add(100); a.add(1000); a.add(10);

        System.out.println("Petlja: \n");

        //pomocu for petlje
        for (Integer b : a){
            System.out.println(b);
        }

        System.out.println("\nIterator: \n");

        //pomocu iteratora
        Iterator<Integer> it = a.iterator();
        while (it.hasNext()){
            System.out.println(it.next());

            //brisemo jedan element po jedan
            //it.remove();
        }

        System.out.println("\nStream: \n");

        //pomocu stream
        a.stream().forEach(pok-> System.out.println(pok));
    }
}
