/*

    - SET
        - LinkedHashSet
            - ulancana struktura
            - slicna implementacija kao za dole hashSet-a samo drugacije izvrsavanje operacija
        - HashSet
            - ima najbolje performanse - hash tabela
            - ne mozemo pregledati kapacitet trenutni

*/

import java.util.*;

public class Set{
    public static void main(String []args){
        Collection<Integer> aa = new ArrayList<Integer>();
        aa.add(12); aa.add(45); aa.add(788);

        //mogli smo deklarisati i kao Set<Integer> ai = new HashSet<Integer>();
        //postoje tri tipa konstruktora
        //jedan bez parametara
        //drugi koji se inicijalizuje sa listom
        //treci kome se preda pocetni kapacitet i load factor tj kada se napuni 500 % 100(u slucaju 1) onda se povecava kapacitet
        HashSet<Integer> a1 = new HashSet<Integer>();
        HashSet<Integer> a2 = new HashSet<Integer>(aa);
        HashSet<Integer> a3 = new HashSet<Integer>(500, 1);

        a1.add(10);a1.add(100);a1.add(1000);

        for (int i=0;i<=1000;i++){
            a3.add(i);
        }

        System.out.println("\na1: \n");
        a1.stream().forEach(e -> System.out.println(e));
        System.out.println("\na2: \n");
        a2.stream().forEach(e -> System.out.println(e));
        System.out.println("\na3: \n");
        a3.stream().forEach(e -> System.out.println(e));

        //brise sve elemente hashset-a a3
        a3.clear();

        System.out.println("Da li je u hashset-u broj 100: " + a1.contains(100));

        //brise elemente sa zadatim kljucem
        a1.remove(100);

        System.out.println("Da li je u hashset-u broj 100: " + a1.contains(100));

        //plitko kopiranje - kopira samo reference
        a3 = (HashSet<Integer>)a1.clone();

        System.out.println("\na3: \n");
        a3.stream().forEach(e -> System.out.println(e));

        a1.add(123);

        //iako smo prethodno dodali element 123 tj referencu
        //u a3 se nije promijnio sadrzaj
        //zato sto hashset se sastoji od niza referenci
        //u ovom smo slucaju samo dodali referencu u a1
        //da bi doslo do promjene bilo bi potrebno samo da se promjeni vrijednost npr 1000 na 10001
        //ali kod seta to nema potrebe jer on ima jedinstvene elemente
        //pa se to najcesce radi tako sto obrisemo npr 1000 i dodamo 1001
        //ali tada se dodaje nova referenca u a3 se nece nista promjeniti
        System.out.println("\na3: \n");
        a3.stream().forEach(e -> System.out.println(e));
    }
}
