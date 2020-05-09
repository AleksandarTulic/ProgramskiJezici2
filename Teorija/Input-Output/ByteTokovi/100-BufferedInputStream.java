import java.io.IOException;
import java.io.*;

public class test{
    public static void main(String []args) throws Exception{
        try{
            FileInputStream a = new FileInputStream("File.txt");

            //bolje kada koristimo reset i mark
            //ima bolje perforamnse a iste principe
            //slicno i BufferedOutputStream
            BufferedInputStream b = new BufferedInputStream(a);

            System.out.println("Memorije u bajtovima ostalo: " + b.available());

            b.skip(6);
            System.out.println("Sazdzaj fajla: ");

            int c = b.read();

            b.mark(11);

            while ( c != -1 ){
                System.out.println((char)c);
                c = b.read();
            }

            //resetuje polozaj na mjesto gdje smo oznacili mark tj pri proslom citanju gdje smo oznacili
            //sa ovim primjerom smo oznacili da nakon prvog procitanog karaktera stavi mark
            //tako da sada kada ispisuje ispisivat ce od markera gdje smo stavili
            //da smo stavili poslije while petlje onda ne bidmo sa drugom while petljom nista ni ispisivali
            //zato sto je stavit na kraj
            b.reset();

            System.out.println("------------------------------");

            c = b.read();
            while ( c != -1 ){
                System.out.println((char)c);
                c = b.read();
            }

            a.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
