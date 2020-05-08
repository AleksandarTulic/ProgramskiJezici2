import java.io.IOException;

public class test{
    public static void main(String []args){
        //kreiramo referencu na novi proces
        ProcessBuilder a = new ProcessBuilder();

        //taj proces treba da izvrsi sljedecu naredbu
        a.command("C:\\Program Files (x86)\\Free Cam 8\\freecam.exe");
        // ako navodimo samo jedno polje onda command naredba otvara to ako moze
        //ukoliko ne moze onda onda se desava IOException tj input output

        try{
            Process b = a.start();
            Thread.sleep(5000);
            System.out.println("Desava se bez obzira na rad aplikacije koja se otvara");

            System.out.println(b.isAlive());

            b.waitFor(); // ostatak koda se ne izvrsava dok se ne zatvori aplikacija

            System.out.println("Desava se tek nakon sto se izvrsi rad aplikacije");


            //Obe dole navedene naredbe i bez destroy su false jer on se vec zavrsio poslije waitFor()
            System.out.println(b.isAlive());
            b.destroy();
            System.out.println(b.isAlive());
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
