import java.io.IOException;
import java.io.*;

/*

    - PrintStream
    - Nema IOException vec se koristi interni flag koji se dohvata sa .checkError metodom

    -PrintStream(File filename)
    - posjeduje opcije:
        - print
        - println
        - append
    - I to sve za razlicite tipove

*/

public class test{
    public static void main(String []args) throws FileNotFoundException{
        try{
            FileOutputStream aa = new FileOutputStream("file.txt");
            PrintStream a = new PrintStream(aa);

            if ( !a.checkError() ){
                a.println(true);
                a.println(123321);
                a.println(4.5333f);

                a.append("Sta ima kod vas?");
                a.flush();
                a.close();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
