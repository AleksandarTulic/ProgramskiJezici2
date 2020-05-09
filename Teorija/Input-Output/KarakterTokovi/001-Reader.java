import java.io.IOException;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.Arrays;

public class test{
    public static void main(String []args) throws Exception{
        try{
            Reader a = new FileReader("File.txt");
            char []b = new char[10];

            if ( a.ready() ){
                //cita sadrzaj b u niz char
                //dok kod prethodnih tokova smo morali koristiti byte pa pretvarati
                a.read(b);
                
                //pretvara niz u string pri cemu ispisuje i zareze i zagrade
                System.out.println(Arrays.toString(b));

                // ni ovde mark nije podrzano makar kod mene nije
                //ovde takodje postoji skip
                //cita sljedeci karakter
                System.out.println((char)a.read());
                System.out.println((char)a.read());
                System.out.println((char)a.read());
                System.out.println((char)a.read());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
