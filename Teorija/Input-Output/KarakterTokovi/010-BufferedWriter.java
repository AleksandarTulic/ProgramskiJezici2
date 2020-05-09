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
            
            //odaklen doklen ce string upisivati u datoteku
            b.append("Evo danas kise ko da vidim !", 4, 10);

            b.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
