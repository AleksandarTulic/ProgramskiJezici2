/*

    - MAP
        - NIJE NASLJEDNIK KOLEKCIJE
        - NA OSNOVU NEKOG KLJUCA DOBIJAMO VRIJEDNOST ILI DODJELJUJEMO
        - KLJUCEVI SU JEDINSTVENI
        - REDOSLIJED ZAVISI OD NJENE IMEPLEMENTACIJE
            - HASHMAP
                - KONSTRUKTORI:
                    HashMap()
                    HashMap(intialCapacity)
                    HashMap(intialCapacity, load factor)
                        - pocetni kapacitet je 16
                        - load factor podrazumijevani je 0.75
            - TREEMAP

*/

import java.util.*;

public class Map{
    public static void main(String []args){
        HashMap<String, Integer> a = new HashMap<String, Integer>();

        //put koristimo za dodavanje elemenata
        a.put("alo1", 11); a.put("alo2", 12); a.put("alo3", 121);

        //ukoliko je vec dodijeljena vrijednost tom kljucu ne mijenja se vrijednost
        //da je bilo samo put onda bi prepisalo proslu vrijednost
        a.putIfAbsent("alo1", 112);
        a.put("alo4", 112);

        System.out.println("Vrijednost kljuca alo1: " + a.get("alo1"));

        System.out.println("Prije brisanja alo4: " + a);

        a.remove("alo4");

        System.out.println("Poslije brisanja alo4: " + a);

        System.out.println("Da li mapa ima kljuc alo2: " + a.containsKey("alo1"));
        System.out.println("Da li mapa ima vrijednost 121: " + a.containsValue(121));
        System.out.println("Da li mapa ima vrijednost 121: " + a.containsValue(125));

        System.out.println("Velicina mape: " + a.size());
        System.out.println("Da li je prazna mapa: " + a.isEmpty());

        System.out.println("Prije mijenjanja vrijednost elementa sa kljucom alo2: " + a.get("alo2"));

        //mijenja vrijednost polja(na koje pokazuje referenca) sa drugim parametrom
        a.replace("alo2", -45);
        System.out.println("Poslije mijenjanja vrijednost elementa sa kljucom alo2: " + a.get("alo2"));

        /*

            - konverzija u kolekciju je posebno jer mapa ima dvije vrijednosti kljuc i value
                - zbog toga mozemo u listu pretvoriti
                    Map <String, String> a = new HashMap<String, String>();
                    - kljuc:
                        List<String> b = new ArrayList<String>(a.keySet());
                    - value:
                        List<String> b = new ArrayList<String>(a.values())

        */

        List <String> keys = new ArrayList<String>(a.keySet());
        System.out.println("Vrijednosti niza kljuceva: " + keys);
        List <Integer> values = new ArrayList<Integer>(a.values());
        System.out.println("Vrijednosti niza elemenata: " + values);

        //cisti mapu
        a.clear();

        SortedMap <String, Integer> m = new TreeMap<String, Integer>();
        m.put("alo1", 11); m.put("alo3", 12); m.put("alo2", -45); m.put("alo8", 1109); m.put("alo4", -99);

        //sortirana po kljucevima
        System.out.println("Sortirana mapa: " + m);

        System.out.println("Prvi kljuc: " + m.firstKey());
        System.out.println("Zadnji kljuc: " + m.lastKey());

        //pri cemu se ne ukljuceje desni kljuc
        System.out.println("Kljucevi u range[1-3] su: " + m.subMap("alo1", "alo4"));

        System.out.println("Kljucevi koji su veci ili jedanki od alo3: "  + m.tailMap("alo3"));
        System.out.println("Kljucevi koji su manji od alo3: "  + m.headMap("alo3"));
        m.clear();
    }
}
