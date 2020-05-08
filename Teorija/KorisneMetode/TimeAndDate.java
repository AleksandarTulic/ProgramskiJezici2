import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class test{
    public static void main(String []args){
        //Uzimamo lokalno vrijeme sa naseg racunara(ili datum)
        //Potrebno je da se pozovu prethodno navedena 4 paketa
        LocalTime a = LocalTime.now();
        LocalDate b = LocalDate.now();

        System.out.println(b);
        System.out.println("Godina: " + b.getYear());
        System.out.println("Mjesec: " + b.getMonth()); //da bismo dobili int vrijdnost potrebno je b.getMonthValue()
        System.out.println("Dan u sedmici: " + b.getDayOfWeek());
        System.out.println("Dan u mjesecu: " + b.getDayOfMonth());
        System.out.println("Dan u godini: " + b.getDayOfYear());

        System.out.println("\n----------------------------\n");

        System.out.println(a);
        System.out.println("Sati: " + a.getHour());
        System.out.println("Minute: " + a.getMinute());
        System.out.println("Sekunde: " + a.getSecond());
        System.out.println("Milisekunde: " + a.getNano());

        System.out.println("\n----------------------------\n");

        LocalDateTime c = LocalDateTime.now();
        System.out.println("Tekst bez formatiranja: " + c);
        DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Tekst poslije formatiranja: " + c.format(d));
        d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Tekst poslije formatiranja: " + c.format(d));
    }
}
