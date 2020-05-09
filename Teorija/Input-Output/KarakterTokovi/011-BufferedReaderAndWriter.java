import java.io.IOException;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.Arrays;

public class test{
    public static void main(String []args) throws Exception{
        try{
            Writer a = new FileWriter("File.txt");
            BufferedWriter b = new BufferedWriter(a);

            b.write("Alo\n");

            b.write("Pa sto to uradi!!!");

            //prelazi u novi red
            b.newLine();

            //odaklen doklen ce string upisivati u datoteku
            b.append("Evo danas kise ko da vidim !");

            b.close();

            Reader c = new FileReader("File.txt");
            BufferedReader d = new BufferedReader(c);

            //citamo samo jedan karakter
            System.out.println((char)d.read());
            System.out.println((char)d.read());

            //citamo u niz char
            char []ff = new char[20];
            d.read(ff);

            System.out.println(Arrays.toString(ff));

            //citamo cijelu liniju
            String line;
            //pri cemu se nastavlja citati gdje smo stali
            //ako smo procitali par karaktera u nekoj liniji i onda pozvali readLine onda ce iscitati ostatak bez onih prethodnih
            while ( (line = d.readLine()) != null ){
                System.out.println(line);
            }

            d.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
