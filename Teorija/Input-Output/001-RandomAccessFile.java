import java.io.IOException;
import java.io.RandomAccessFile;
/*

    - Write i Read koriste binarno zapisivanje
    - Length ispisuje broj karaktera kojih ima upisano
    - Seek vrsi pomjeranje od pocetka
    - Vidimo da ako uzmamo vise nego sto mozemo staviti u niz byte onda se skladisti Max moguce od pocetka
    - Gledali su kao karaktere kao prelazne elemente

*/
public class test{
    static final String Path = "File.txt";

    public static void main(String []args){
        try{
            RandomAccessFile a = new RandomAccessFile(Path, "rw");
            String b = "Sta ima kod vas!!!";
            a.write(b.getBytes());
            a.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            RandomAccessFile a = new RandomAccessFile(Path, "r");
            a.seek(1); //pomjeraj poslije starta
            byte []b = new byte[20];
            a.read(b);
            System.out.println(new String(b));
            System.out.println(a.length()); //iako je gore seek ovde ce ispisati duzinu 18 jer on ima dva dodatna slova
            a.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
