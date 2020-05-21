/*

    - QUEUE
        - FIFO
        - P_QUEUE - po vrijednosti - sortirani
            - Konstruktori:
                PriorityQueue(Collection <? extends E> c)
                PriorityQueue(initCapacity)
                PriorityQueue(SortedSet <? extends E> c)

*/

import java.util.*;

public class Queue{
    public static void main(String []args){
        Queue<Integer> a = new LinkedList<Integer>();

        for (int i=0;i<=20;i+=2){
            a.add(i);
        }

        //vidimo da je element 0 prvi usao
        // i prvi je na redu za izlazak
        //FIFO
        System.out.println("Elementi queue su: " + a);

        //prikazuje element bez brisanja
        System.out.println("Prvi element: " + a.peek());
        System.out.println("Velicina queue je: " + a.size());
        a.remove();
        System.out.println("Prvi element nakon brisanja je: " + a.peek());

        PriorityQueue<Integer> b = new PriorityQueue<Integer>();

        for (int i=20;i>=0;i-=2){
            b.add(i);
        }

        //elementi se redjaju po vrijednosti
        System.out.println("Elementi p_queue su: " + b);

        //poll opcija nam vraca crijednost element kao i peek samo sto ga i brise
        //takodje je prisutna kod obicnog queue
        System.out.println("Prvi element je: " + b.poll());
        System.out.println("Prvi element je: " + b.poll());

        //prebacuje p_queue u niz objekata
        Object []c = b.toArray();
        for (Object cc : c){
            System.out.print(cc + " ");
        }

        System.out.println();

        System.out.println("Da li p_queue sadrzi element 14: " + b.contains(14));
    }
}
