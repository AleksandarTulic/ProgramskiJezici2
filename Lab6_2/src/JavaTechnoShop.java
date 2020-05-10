import org.unibl.etf.pj2.org.unibl.etf.pj2.cjenovnik;
import org.unibl.etf.pj2.org.unibl.etf.pj2.racun;
import org.unibl.etf.pj2.proizvodi.Proizvod;
import org.unibl.etf.pj2.proizvodjac.*;

import java.util.Scanner;

public class JavaTechnoShop{
    public static void main(String []args){
        System.out.println("Shop :)");

        Proizvodjac samsung = new Proizvodjac("Samsung", "South Korea", "samsung@gmail.com");
        Proizvodjac lg = new Proizvodjac("LG", "South Korea", "Lginfo@gmail.com");
        Proizvodjac nokia = new Proizvodjac("Nokia", "Finland", "groundBroken@hotmail.com");
        Proizvodjac iphone = new Proizvodjac("Iphone", "United States of America", "IphoneInfo@gmail.us");

        Monitor m1 = new Monitor("001", 250, "Lg smart screen", lg, "Resolution: 21:9", "001 Screen");
        Monitor m2 = new Monitor("010", 120, "Lg screen", lg, "Resolution: 16:9", "010 Screen");
        Monitor m3 = new Monitor("011", 419.9, "Lg smart screen X2", lg, "Resolution: 30:9", "011 Screen");
        Softver a1 = new Softver("100", 31.9, "OS",iphone, "Very bad");
        Telefon b1 = new Telefon("101", 788.1, "Iphone X", iphone, "weight: 100mg", "Model X");
        Telefon b2 = new Telefon("110", 450, "Nokia 7799", nokia, "weight: 220mg, camera MP: 12px", "7799");
        Racunar c1 = new Racunar("111", 1999.9, "Wargaming Extreme", samsung, "CPU: i7, 2.7GHz");
        Racunar c2 = new Racunar("1000", 1431.4, "Office machine", iphone, "CPU: double core, 2.1GHz");

        cjenovnik a = new cjenovnik();
        a.a = new Proizvod[]{m1, m2, a1, m3, b1, b2, c1, c2};

        a.printProizvodi();
        if ( a.getProizvodSaSifrom("010") == null ){
            System.out.println("Proizvod sa sifrom 010 ne postoji.");
        }else{
            System.out.println("Proizvod sa sifrom 010 postoji.");
        }

        racun arr = new racun();
        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("Pregled cjenovnika                 [1]");
            System.out.println("Pregled proizvoda po sifri         [2]");
            System.out.println("Pregled Proizvoda po nazivu        [3]");
            System.out.println("Kupovina proizvoda                 [4]");
            System.out.println("Prikaz kupovie                     [5]");
            System.out.println("Ukloniti proizod sa liste kupovine [6]");
            System.out.println("Zakljuci kupovinu                  [7]");

            System.out.print("Unesite opciju: ");
            int option = scan.nextInt();

            if ( option == 1 ){
                a.printProizvodi();
            }else if ( option == 2 ){
                System.out.println("Unesite sifru: ");
                Scanner s = new Scanner(System.in);
                String b = s.nextLine();
                System.out.println(b);
                a.printProizvodiPassword(b);
            }else if ( option == 3 ){
                System.out.println("Unesite naziv: ");
                Scanner s = new Scanner(System.in);
                String b = s.nextLine();
                a.printProizvodiName(b);
            }else if ( option == 4 ){
                System.out.println("Unesite sifru proizvoda sto kupujete: ");
                Scanner s = new Scanner(System.in);
                String b = s.nextLine();
                arr.addProizvod(a.getProizvodSaSifrom(b));
            }else if ( option == 5 ){
                arr.showList();
            }else if ( option == 6 ){
                System.out.println("Unesite sifru proizvoda koji zelite da obrisete: ");
                Scanner s = new Scanner(System.in);
                String b = s.nextLine();
                arr.deleteProizvod(a.getProizvodSaSifrom(b));
            }else if (option == 7){
                arr.buy();
                break;
            }else{
                System.out.println("niste nesto dobro unijeli!!!\nPokusajte ponovo!!!");
            }
        }
    }
}
