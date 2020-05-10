import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSystem {
    public File currentPath = new File("ads");

    public void changeDir(String name){
        boolean flag = false;
        if ( "..".equals(name) && currentPath.getParentFile() != null ){
            //GETPARRENTFILE uzima putanju prethodnika
            currentPath = currentPath.getParentFile();
            flag = true;
        }else{
            File check = new File(currentPath.getAbsolutePath() + File.separator + name);
            if ( check.exists() ){
                currentPath = check;
                flag = true;
            }
        }

        if ( flag ){
            System.out.println("Izmjenili smo poziciju: " + currentPath.getAbsolutePath());
        }else{
            System.out.println("Nismo uspjeli izmjeniti poziciju!!!");
        }
    }

    public void listFiles(){
        if ( currentPath.isDirectory() ){
            File []niz = currentPath.listFiles();
            if ( niz.length != 0 ){
                System.out.println("Elementi direktorijuma su: ");
                for (File a : niz){
                    if ( a.isDirectory() ){
                        System.out.println("<DIR> " + a.getName());
                    }else if ( a.isFile() ){
                        System.out.println(a.getName());
                    }
                }
            }else{
                System.out.println("Direktorijum nema elemenata.");
            }
        }
    }

    public void createDirectory(String name){
        if ( currentPath.isDirectory() ){
            File buffer = new File(currentPath.getAbsolutePath() + File.separator + name);
            buffer.mkdir();
            System.out.println("Uspjesno ste kreirali direktorijum sa nazivom: " + name);
        }else{
            System.out.println("Direktorijum nije kreiran!!!");
        }
    }

    public void listWordDoc(){
        if ( currentPath.isDirectory() ){
            String []niz = currentPath.list();
            String matrix[][] = new String[niz.length][];

            for (int i=0;i<niz.length;i++){
                matrix[i] = niz[i].split("\\.");
            }

            System.out.println("Word dokumenti su: ");
            for (int i=0;i<niz.length;i++){
                if ( matrix.length >= 2 ){
                    String buff = matrix[i][matrix[i].length-1];
                    if ( buff.equals("doc") || buff.equals("docx") ){
                        System.out.println(niz[i]);
                    }
                }
            }
        }
    }

    public void delete(String name){
        if ( currentPath.isDirectory() ){
            File a = new File(currentPath.getAbsolutePath() + File.separator + name);
            if ( !a.exists() ){
                System.out.println("Ne postoji direktorijum ili fajl!!!");
            }

            if ( a.isDirectory() || a.isFile() ){
                System.out.println("Uspjesno ste izbrisali :)");
                a.delete();
            }
        }
    }

    //vrsi kpiranje source slike u destionatio i minjea naravno ime sa destination imenom
    //kreirali smo prvo putanje do tih fajlova
    //pa smo onda izvrsili upis i ispis bajtova na odgovarajuce mjesto i tako dobili kopiranu sliku
    //ch je taj bajt
    public void copyImageFile(String sourceName, String destinationName) throws IOException {
        if ( sourceName.endsWith("jpg") && destinationName.endsWith("jpg") ){
            File a = new File(currentPath.getAbsolutePath() + File.separator + sourceName);
            File b = new File(currentPath.getAbsolutePath() + File.separator + destinationName);

            if ( a.exists() ){
                FileInputStream aa = new FileInputStream(a);
                FileOutputStream bb = new FileOutputStream(b);

                int ch;
                while ( ( ch = aa.read() ) != -1){
                    bb.write(ch);
                }

                aa.close();
                bb.close();
            }else{
                System.out.println("Ne postoji putanja!!!");
            }
        }else{
            System.out.println("Fajlovi nisu formata .jpg!!!");
        }
    }

    public static void main(String []args){
        FileSystem a= new FileSystem();
        a.currentPath = new File("D:\\FAKULTET");
        a.listFiles();
        a.listWordDoc();
        a.createDirectory("HomeHome");
        a.listFiles();
        a.delete("HomeHome");
        try{
            a.copyImageFile("Chrysanthemum.jpg", "alo.jpg");
        }catch (Exception e){
            e.printStackTrace();
        }

        a.changeDir("PROGRAMSKI JEZICI 1");
    }
}
