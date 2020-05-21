/*

    - GENERICI:
        - IZBJEGAVAMO KASTOVANJE
            ArrayList<String> a = new ArrayList<String>();
            a.add("Nesto1");
            a.add("Nesto2");
            String s = a.get(0); - NIJE POTREBAN CAST

        - MOZEMO DETEKTOVATI RAZNE GRESKE
            - ZNA SE U VRIJEME KOMPJALIRANJA DA JE GRESKA(DOK OVAKO SE INACE DESAVA ZA VRIJEME RUN TIME)

        - NPR. AKO IMAMO ARRAYLIST KOJA JE TIP STRING-A KADA SE UNESE U NJEGA TIP INT ON CE NORMALNO RADITI ALI KADA BUDE
    TREBALO DOHVATITI ONDA CE DOCI DO GRESKE
            ArrayList a = new ArrayList();
            a.add("Nesto1");
            a.add("Nesto2");
            a.add(10);
            String s = (String)a.get(2) - GRESKA!!! RUN TIME - KOMPAJLER ODOBRAVA

        - PARAMETRIZOVANI TIP:
            - KORISTENJE GENERICKOG TIPA GDJE SU TIPSKE PROMJENLJIVE ZAMIJENJENE PARAMETRIMA STVARNOG TIPA
            - POTREBNO JE IZBJEGAVATI KORISTENJE RAW TIPA - Integer, String, Boolean ...

        - GENERICKI TIP KOJI NIJE DEKLARISAN KAO FINAL MOZE BITI PROSLIJEDJEN
            - FINAL ZNACI DA SE VRIJEDNOST NE MOZE MIJENJATI - UKOLIKO SE POKUSA GRESKA
            - UKOLIKO JE NEKA METODA FINAL ONA SE NE MOZE OVERRIDE
            - UKOLIKO JE NEKA KLASA FINAL ONDA SE ONA NE MOZE EXTEND-OVATI

        - NASLJEDJIVANJE:
            - MOGUCE JE DA GENERICKI TIP NASLIJEDI NEGENERICKI

                public class Something1<T> extends Something2{...}

            - MOGUCE JE DA KONKRETAN TIP NASLIEDI GENERICKI

                public class Something2 extends Something1<t>{...}
         - OGRANICAVANJE

            public class Something1<T extends Something2> extends Something3<T>{...}
                - ZNACI DA KAO PARAMETAR MOZE BITI SAMO SOMETHING2 ILI NJEGOVI NASLJEDNICI I KLASE SOMETHING3


         - METODE

            static <T> void somethingHappened(){...}

         - WILDCARDS - ?

            - MOZE SE KORISTIT:
                - KAO TIP PARAMETRA, POLJA, LOKALNE VARIJABLE

            - UPPER BOUNDED:
                - SMANJIMO RESTRIKCIJE NA VARIJABLAMA

                public static void add(List <? extends Number> list){...}
                    - gornja granica je NUMBER, i obuhvata tipove kao sto su double, int

            - LOWER BOUND:

                public static void something(List <? super Integer> list){...}
                    - uzima samo int i njegovu nad klasu koja je number - nece double

            - UNBOUNDED:
                - KADA SADRZAJ STO RADIMO NE ZAVISI OD TIPA KAO NPR ISPIS NIZA NEKIH ELEMENATA

                public static void something(List <?> list){ sout(list) }
                

*/
public class generic {
    public static void ispis(List <?> list){
        System.out.println(list);
    }

    public static void main(String []args){
        List<Integer> a = new ArrayList<Integer>();
        for (int i=1;i<=9;i++){
            a.add(i);
        }

        List<Double> b = new ArrayList<Double>();
        for (double i=1.0;i<=2;i+=0.1) {
            b.add(i);
        }

        ispis(a);
        ispis(b);
    }
}
