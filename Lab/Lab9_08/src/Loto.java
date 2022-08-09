import java.io.*;
import java.nio.channels.FileLockInterruptionException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loto {
    public static void serialization(Kolo a) throws FileNotFoundException {
        try {
            ObjectOutputStream b = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Tula\\IdeaProjects\\Lab9_08\\" + "Kolo" + a.id + ".ser"));
            b.writeObject(a);
            b.flush();
            b.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Kolo> odSerijalizuj() throws FileNotFoundException{
        try{
            List<Kolo> niz = new ArrayList<Kolo>();

            File b = new File("C:\\Users\\Tula\\IdeaProjects\\Lab9_08");
            String []arr = b.list();

            for (String name : arr) {
                System.out.println(name);
                if (name.endsWith(".ser")) {
                    ObjectInputStream a = new ObjectInputStream(new FileInputStream("C:\\Users\\Tula\\IdeaProjects\\Lab9_08" + "\\" + name));

                    Kolo buff = (Kolo)a.readObject();
                    a.close();
                    niz.add(buff);
                }
            }

            return niz;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String []args){
        boolean flag = false;

        do{
            try{
                System.out.println("MENI: \n");
                System.out.println("NOVO KOLO      [1]");
                System.out.println("PREGLED TIKETA [2]");
                System.out.println("IZLAZ          [3]");

                Scanner scan = new Scanner(System.in);
                System.out.print("Unesite opciju: ");
                int option = scan.nextInt();

                if ( option == 1 ){
                    Kolo a = new Kolo();

                    a.chooseNumbers();
                    a.playTiket();
                    serialization(a);
                }else if ( option == 2 ){
                    List<Kolo> niz = odSerijalizuj();

                    for (Kolo a : niz){
                        a.resolve();
                        a.printKolo();
                    }
                }else if ( option == 3 ){
                    System.out.println("Dovidjenja :)");
                    flag = true;
                }else{
                    System.out.println("Opcija nije podrzana!!!\nPokusajte ponovo!!!");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }while ( !flag );
    }
}
