import static java.lang.Integer.toBinaryString;

public class test{
    public static void main(String []args){
        /*
            Transformacija Stringa u primitivni tip
            Drugi parametar kod integer.valuof nam govori po kojoj bazi je string
        */

        boolean a1 = Boolean.valueOf("true");
        int b1 = Integer.valueOf("10010111", 2);
        System.out.println(a1 + " " + b1);

        // Transformacija stringa u primitivni tip
        // Pri cemu se baca greska ukoliko je neuspjesno
        // Exception: NumberFormatException

        int a2 = Integer.parseInt("123321");
        double b2 = Double.parseDouble("2.55");
        System.out.println(a2 + " " + b2);

        //prebacivanje iz primitivnog tipa u string
        //to(Binary | Hex | Octal)String(vrijednost);
        //potrebno je ukljuciti paket java.lang.Integer.toBinaryString;

        String dou = Double.toString(2.45);
        String in = Integer.toString(12);
        String bin = toBinaryString(12);
        System.out.println(dou + " " + in + " " + bin);

        //Funkcije sa STRING-OM

        String a = new String("  Danas je fin dan!");
        System.out.println(a);

        //indeks odakle - dokle uzimamo elemente iz stringa
        System.out.println(a.substring(2, 7));

        //odkidamo prazna mjesta sa prijeda i sa zada
        //dobro za sifru kada korisnik unosi jer mozda pogresno unese naprijed mjesta
        System.out.println(a.trim());

        //pretvori sve u mala slova
        System.out.println(a.toLowerCase());

        //pretvori sve u velika slova
        System.out.println(a.toUpperCase());

        //ispisuje duzinu stringa
        System.out.println(a.length());

        //provjerava da li je string prazan
        System.out.println(a.isEmpty());

        //vraca string koji je string s kojim smo pozvali + string koji smo proslijedili
        a = a.concat(" Ali ipak dolaze oblaci!");
        System.out.println(a);

        //provjerava da li postoji string u stringu sa kojim smo pozvali
        System.out.println(a.contains("fin23"));
        System.out.println(a.contains("fin"));
    }
}
