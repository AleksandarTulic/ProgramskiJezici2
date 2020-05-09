import java.io.IOException;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.Arrays;

public class test{
    public static void main(String []args) throws IOException {
        BufferedReader a = new BufferedReader(new InputStreamReader(System.in));
        try{
            String name = a.readLine();
            String password = a.readLine();

            System.out.println("Username: " + name);
            System.out.println("Password: " + password);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
