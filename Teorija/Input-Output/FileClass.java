import java.io.File;
import java.io.IOException;

/*

    - File klasa je namijenjena za:
        - kreiranje datoteka i direktorijuma
        - brisanje
        - pristup atributima
        - modifikaciju naziva i atributa
    - Objekti ne mogu da mijenjaju putanju
    - Konstruktori:
        - File(Path)
        - File(directoryPath, fileName)


*/
public class test{
    public static void main(String []args) throws IOException {
        File a = new File("d:\\FAKULTET");
        //Dobijamo naziv direktorijuma u kojem se nalazimo
        System.out.println(a.getName());

        //dobijamo putanju direktorijuma u kojem se nalazimo
        // potrebno je navesto da ova putanja ne mora biti apsolutna
        System.out.println(a.getPath());

        //apsolutna putanja i uvijek krece od istog mjesta
        System.out.println(a.getAbsolutePath());

        //dobijamo roditeljski direktorijum
        //ukoliko nema roditelja onda dobijamo null vrijednost
        System.out.println(a.getParent());

        //gledamo da li app moze izvrsiti fajl
        System.out.println(a.canExecute());

        //gledamo da li app moze citati fajl
        System.out.println(a.canRead());

        //gledamo da li app moze pisati fajl
        System.out.println(a.canWrite());

        //dole navedene 3 metode vrse postavljanje operacija na true ili false
        // tj moze li se izvrsavati ili ne moze
        //ali potrebno je da imamo pravo pristupa za to
        //ukoliko nemamo onda se nece nista desiti a vratit ce true
        //takodje mogu biti metoda istog tipa samo sto ima je drugi parametar OWNER
        a.setWritable(true);
        a.setExecutable(true);
        a.setReadable(true);

        //provjera da li je fajl
        System.out.println(a.isFile());

        //provjera da li je direktorijum
        System.out.println(a.isDirectory());

        //provjerava da li postoji fajl ili direktorijum
        System.out.println(a.exists());

        //vraca nam listu direktorijuma i fajlova u datom direktorijumu
        String []arr = a.list();

        System.out.println();
        for (String arr1 : arr){
            System.out.println(arr1);
        }
        System.out.println();

        //isto kao prethodno samo sto ispisuje sa putanjama
        File []niz = a.listFiles();

        System.out.println();
        for (File niz1 : niz){
            System.out.println(niz1);
        }
        System.out.println();

        //kreira fajl ukoliko ga vec nema
        //fajl bi se nazvao kao zadnji element poslije \\
        a.createNewFile();

        //isto kao i prethodno samo za direktorijume
        a.mkdir();

        //brise fajl preko putanje kada zadajemo
        a.delete();
    }
}
