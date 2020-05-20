import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Kolo implements Serializable {
    private static int pov = 1;
    public int id;
    private List<Tiket> niz = new ArrayList<Tiket>();
    private List<Integer> winning = new ArrayList<Integer>();

    public Kolo(){
        id = pov++;
    }

    public void chooseNumbers() throws NoDimension{
        int option;

        do {
            boolean flag = true;
            System.out.println("MENI KOLO: \n");
            System.out.println("KUPITE TIKET [1]");
            System.out.println("KRAJ KOLA    [2]");

            Scanner scan = new Scanner(System.in);
            option = scan.nextInt();

            if ( option == 1  ) {
                System.out.println("Unesite 6 brojeva: ");

                scan = new Scanner(System.in);
                Tiket buffer = new Tiket();

                for (int i = 0; i < 6; i++) {
                    int number;

                    do {
                        System.out.print("Unesite [" + (i + 1) + "] broj: ");
                        number = scan.nextInt();

                        if (number >= 1 && number <= 45) {
                            buffer.addNumber(number);
                        } else {
                            throw new NoDimension("Nije u dimenzijama zadatim!!![1-45]");
                        }
                    } while (!buffer.addNumber(number));
                }

                niz.add(buffer);
            }else if ( option == 2 ){
                System.out.println("Kraj ovog kola :)");
            }else{
                System.out.println("Opcija nije podrzana!!!");
            }
        }while ( option != 2 );
    }

    public boolean check(Tiket a){
        int br = 0;
        List<Integer> buffer = a.getNumbers();

        for (int i : winning){
            for (int j : buffer){
                if ( i == j ){
                    br++;
                    break;
                }
            }
        }

        return br == 6;
    }

    public boolean checkWin(){
        boolean flag = false;
        for (Tiket a : niz){
            flag = check(a);
            if ( flag ){
                return flag;
            }
        }

        return flag;
    }

    public void generateWinning(){
        Random rand = new Random();

        for (int i=0;i<6;i++){
            try {
                int number = rand.nextInt(45) + 1;
                System.out.println("Izvuceni [" + (i + 1) + "] broj je: " + number);
                winning.add(number);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void playTiket(){
        generateWinning();

        if ( checkWin() ){
            System.out.println("Korisnik je dobio na lutriji :)");
        }else{
            System.out.println("Nazalost korisnik nije dobio na lutriji!!!");
        }
    }

    public void printKolo(){
        System.out.println("id Kola: " + id + "\n");

        for (Tiket a : niz){
            System.out.println(a);
        }

        System.out.println("Dobitna kombinacija: ");
        for (int i : winning){
            System.out.print(i + " ");
        }

        System.out.println();
    }

    public void resolve(){
        for (Tiket a : niz){
            a.resolveProblem();
        }
    }
}
