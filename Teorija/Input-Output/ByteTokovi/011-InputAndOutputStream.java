import java.io.IOException;
import java.io.*;
/*

    TOKOVI
        - INPUTSTREAM
        - OUTPUTSTREAM
            - bajtove
        - READER
        - WRITER
            - string

*/
public class test{
    public static void main(String []args) throws Exception {
        InputStream a = null;
        try{
            //definisemo odaklen citamo
            a = new FileInputStream("File.txt");
            //citamo samo jedan karakter
            System.out.println((char)a.read());
            System.out.println((char)a.read());

            //napravimo niz bajtova
            //proslijedimo ga kao prametar citanja
            //dobijemo vrijednost string u bajtovima
            byte []num = new byte[5];
            System.out.println(a.read(num));
            System.out.println(new String(num));

            //preskace odgovarajuci broj bajtova
            a.skip(2);

            //zatvara output stream
            a.close();

            OutputStream b = new FileOutputStream("File.txt");

            String sentence = "Sta ima kod vas?\nDanas necu nista uciti, al moram zato sutra nadoknaditi!";

            //ispisujemo sadrzaj string sentence u datoteku pri cemu je potrebno konvertovati u []byte
            b.write(sentence.getBytes());

            //primorava da se sve ispise
            b.flush();

            //zatvarom output tok
            b.close();
        } catch (NumberFormatException ee){
            ee.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
