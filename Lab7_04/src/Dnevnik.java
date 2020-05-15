import java.io.*;
import java.util.*;

public class Dnevnik {
    public static void outputData(String []niz) {
        try {
            FileWriter a = new FileWriter("C:\\Users\\Tula\\IdeaProjects\\Lab7_04\\dnevnik.txt", true);
            BufferedWriter b = new BufferedWriter(a);

            for (String i : niz){
                b.append(i + " ");
            }

            b.append("\n");

            b.flush();
            b.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String> inputData(){
        try {
            FileReader a = new FileReader("C:\\Users\\Tula\\IdeaProjects\\Lab7_04\\dnevnik.txt");
            BufferedReader b = new BufferedReader(a);

            List <String> niz = new ArrayList<String>();

            String buff;
            while ( (buff = b.readLine()) != null ){
                String []buff1 = buff.split("\\ ");
                for (String buff2 : buff1){
                    niz.add(buff2);
                }
            }

            return niz;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String []args){
        String [][]a = new String[4][5];

        a[0][0] = "1234/05"; a[0][1] = "7.23";
        a[0][2] = "8.91"; a[0][3] = "6.23"; a[0][4] = "8.22";

        a[1][0] = "1107/02"; a[1][1] = "9.23";
        a[1][2] = "8.91"; a[1][3] = "9.11"; a[1][4] = "7.22";

        a[2][0] = "1330/11"; a[2][1] = "6.23";
        a[2][2] = "8.01"; a[2][3] = "8.23"; a[2][4] = "7.68";

        a[3][0] = "1155/10"; a[3][1] = "7.77";
        a[3][2] = "8.91"; a[3][3] = "6.48"; a[3][4] = "9.99";

        System.out.println("Prije upisa: ");
        for (int i=0;i<4;i++){
            printData(a[i]);
            outputData(a[i]);
        }

        System.out.println("Poslije upisa: ");
        List<String> b = inputData();

        String []arr = new String[5];
        int i = 0;

        for (String buff : b){
            arr[i++] = buff;

            if ( i == 5 ){
                i=0;
                printData(arr);
            }
        }
    }

    public static void printData(String []a){
        try{
            System.out.println();
            System.out.println("Indeks: " + a[0]);
            System.out.println("Godina 1: " + a[1]);
            System.out.println("Godina 2: " + a[2]);
            System.out.println("Godina 3: " + a[3]);
            System.out.println("Godina 4: " + a[4]);
            System.out.println();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
