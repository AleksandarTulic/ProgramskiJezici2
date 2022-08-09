import java.time.*;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class JavaWorld {
    public static void serijalizacija(Zaposleni a) {
        try {
            ObjectOutputStream b = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Tula\\IdeaProjects\\Lab7_05\\" + a.getRealName() + ".ser"));

            b.writeObject(a);
            b.flush();
            b.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Zaposleni> odSerijalizuj(){
        List<Zaposleni> arr = new ArrayList<Zaposleni>();

        try{
            String []niz = new File("C:\\Users\\Tula\\IdeaProjects\\Lab7_05").list();

            for (String a : niz){
                if ( a.endsWith(".ser") ){
                    ObjectInputStream b = new ObjectInputStream(new FileInputStream("C:\\Users\\Tula\\IdeaProjects\\Lab7_05\\" + a));
                    arr.add((Zaposleni)b.readObject());
                    b.close();
                }
            }

            return arr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }

    public static void printData(Zaposleni a) {
        try {
            BufferedWriter b = new BufferedWriter(new FileWriter("C:\\Users\\Tula\\IdeaProjects\\Lab7_05\\korisnik" + a.getRealName() + ".txt"));

            b.write( "Ime: " + a.getRealName() + "|" );
            b.write( "Prezime: " + a.getSurnName() + "|" );
            b.write("Korisnicko ime: " + a.getUserName() + "|" );
            b.write( "Sekundi: " + a.getNumHours() + "|");

            b.flush();
            b.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int option;

        List<Zaposleni> niz = odSerijalizuj();

        do {

            System.out.println("Kreirajte radnika [1]");
            System.out.println("Login Radnik      [2]");
            System.out.println("EXIT              [3]");

            System.out.print("Unesite opciju: ");
            option = Integer.parseInt(scan.nextLine());

            if (option == 1) {
                String name1;
                String name2;
                String name3;
                boolean flag;

                do {
                    flag = true;
                    System.out.print("Unesite ime: ");
                    name1 = scan.nextLine();
                    System.out.print("Unesite prezime: ");
                    name2 = scan.nextLine();
                    System.out.print("Unesite korisnicko ime: ");
                    name3 = scan.nextLine();

                    for (Zaposleni buff : niz){
                        if ( buff.getUserName().equals(name3) ){
                            flag = false;
                            break;
                        }
                    }
                }while( !flag );

                niz.add(new Zaposleni(name1, name2, name3, LocalTime.now().getSecond()));
            } else if (option == 2) {
                int opt;
                int o;

                do{
                    List<Zaposleni> buff1 = odSerijalizuj();

                    for (Zaposleni buff2 : buff1){
                        boolean flag = true;
                        for (Zaposleni buff3 : niz){
                            if ( buff2.getUserName().equals(buff3.getUserName()) ){
                                flag = false;
                                break;
                            }
                        }

                        if ( flag ){
                            niz.add(buff2);
                        }
                    }

                    System.out.println("Korisnici: ");
                    int br = 1;
                    for (Zaposleni buff : niz) {
                        System.out.println(buff.getUserName() + "[" + String.valueOf(br++) + "]");
                    }

                    do {
                        System.out.print("Unesite opciju: ");
                        opt = Integer.parseInt(scan.nextLine());

                        if (opt >= br) {
                            System.out.println("Korisnik ne postoji!!!");
                        }
                    } while (opt >= br);

                    System.out.println("Naredbe: ");
                    System.out.println("PAUZA      [1]");
                    System.out.println("EXIT       [2]");

                    System.out.print("Unesite opciju: ");
                    o = Integer.parseInt(scan.nextLine());

                    if ( o == 1 ){
                        System.out.println("Serijalizacija!!!");
                        serijalizacija(niz.get(opt-1));
                    }else if ( o == 2 ){
                        System.out.println("Korisnik se odjavljuje!!!");
                        printData(niz.get(opt-1));
                    }else{
                        System.out.println("Niste unijeli validnu komandu!!!");
                    }
                }while( o != 2 );
            }
        }while( option != 3 );
    }
}
