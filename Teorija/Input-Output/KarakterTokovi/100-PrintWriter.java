import java.io.IOException;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.Arrays;

public class test{
    public static void main(String []args) throws Exception{
        try{
            Writer a = new FileWriter("File.txt");
            PrintWriter b = new PrintWriter(a);

            b.println(123);
            b.println(2.1113997);
            b.println("Sta ima novo kod vas?");
            b.flush();
            b.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
