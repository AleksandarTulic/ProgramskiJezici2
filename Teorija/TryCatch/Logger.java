/*

        - Logger su objekti koji trigeruju log dogadjaj
        - Kreiranje novog logera:
            private final static Logger logger = Logger.getLogger(Naziv_Klase.class.getName())
        - Uzima string kao parametar koji identifikuje taj logger
        - Prije nego sto se log-uje neki event potrebno je da se dodijeli level(ozbiljnost poruke)

        - Log leveli:
            - OFF
            - SEVERE
            - WARNING
            - INFO
            - CONFIG
            - FINE
            - FINER
            - FINEST
            - ALL
        - Sintaksa: logger.log(Level.nekiodozgo, "poruka");

        - Ako je nivo postavljen na INFO onda ce se logovati i INFO i WARNING i SEVERE

        - Handeleri prosljedjuju log zapise na output destinaciju

        - Handler dobija log poruke od logger-a i exportuje ih na specifican cilj
            - hadler se moze:
                - iskljuciti setLevel(Level.OFF)
                - ukljuciti setLevel()

        - Koristeni handler-i :
            - ConsoleHandler - pise log poruke na konzolu
            - FileHandler - pise log poruke u fajl

        - Sintaksa f = new FileHandler("fajl", true | false)
            true - append
            false - no append

        - Svaki izlaz handler-a se moze konfigurisati sa FORMATTER
            - SimpleFormatter
            - XMLFormatter

*/

import java.io.IOException;
import java.util.logging.*;

public class test{
    private static final Logger logger = Logger.getLogger(test.class.getName());
    private static FileHandler f = null;

    public static void main(String []args){
        try{ //moramo da obavljamo input/output exception
            f = new FileHandler("test.log", true);
        }catch (IOException e){
            e.printStackTrace();
        }

        f.setFormatter(new SimpleFormatter()); //kazemo handleru kog formata treba da bude 
        logger.addHandler(f); //dodajemo objektu loggera handler
        logger.log(Level.SEVERE, "Treba za sada ici polako..."); //stavljamo nivo logera i pporuku koja se prosljeduje u fajl
        logger.log(Level.SEVERE, "gdje ste narode!!!"); //ova poruka ce se takodje proslijediti u fajl jer je istog levela
    }
}

import java.io.IOException;
import java.util.logging.*;

public class test{
    private static final Logger logger = Logger.getLogger(test.class.getName());
    private static FileHandler f = null;

    public static void main(String []args){
        try{ //moramo da obavljamo input/output exception
            f = new FileHandler("test2.log", false);
        }catch (IOException e){
            e.printStackTrace();
        }

        f.setFormatter(new SimpleFormatter()); //kazemo handleru kog formata treba da bude
        logger.addHandler(f); //dodajemo objektu loggera handler
        logger.log(Level.INFO, "000"); //ova poruka ce se takodje proslijediti u fajl jer je istog levela
        logger.log(Level.WARNING, "001"); //ova poruka je levela iznad INFO pa se prosljedjuje
    }
}

import java.io.IOException;
import java.util.logging.*;

public class test{
    private static final Logger logger = Logger.getLogger(test.class.getName());
    private static FileHandler f = null;

    public static void main(String []args){
        try{ //moramo da obavljamo input/output exception
            f = new FileHandler("test2.log", false);
        }catch (IOException e){
            e.printStackTrace();
        }

        f.setFormatter(new SimpleFormatter()); //kazemo handleru kog formata treba da bude
        logger.addHandler(f); //dodajemo objektu loggera handler
        
        // sa ovim kodom smo postavili sve handlere na NIVO FINER I SVI KOJI SU >= se ispisuju jedino FINEST NECE
        Logger root = Logger.getLogger("");
        root.setLevel(Level.FINER);
        for (Handler a : root.getHandlers()){
            a.setLevel(Level.FINER);
        }

        logger.log(Level.FINE, "000");
        logger.log(Level.WARNING, "001");
        logger.log(Level.SEVERE, "010");
        logger.log(Level.CONFIG, "011");
    }
}
