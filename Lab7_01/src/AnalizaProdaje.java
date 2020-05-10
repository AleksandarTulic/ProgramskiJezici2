import java.io.*;

public class AnalizaProdaje {
    public static void main(String []args) throws Exception {
        try{
            BufferedReader read = new BufferedReader(new FileReader("prodaja"));

            String line;
            String [][]members = new String[100][];
            int br = 0;

            while ( (line = read.readLine()) != null ){
                members[br++] = line.split("\\#");
            }

            read.close();

            Writer w1 = new FileWriter("prodajaRacunari.txt");
            Writer w2 = new FileWriter("prodajaMonitori.txt");
            Writer w3 = new FileWriter("prodajaTelefoni.txt");
            BufferedWriter write1 = new BufferedWriter(w1);
            BufferedWriter write2 = new BufferedWriter(w2);
            BufferedWriter write3 = new BufferedWriter(w3);

            double cost[] = new double[3];

            for (int i=0;i<br;i++){
                if ( members[i][0].equals("racunar") ){
                    write1.write(members[i][0] + " " + members[i][1] + " " + members[i][2] + " " + members[i][3] + "\n");
                    cost[0]+= Double.parseDouble(members[i][3]);
                }else if ( members[i][0].equals("monitor") ){
                    write2.write(members[i][0] + " " + members[i][1] + " " + members[i][2] + " " + members[i][3] + "\n");
                    cost[1]+= Double.parseDouble(members[i][3]);
                }else if ( members[i][0].equals("telefon") ){
                    write3.write(members[i][0] + " " + members[i][1] + " " + members[i][2] + " " + members[i][3] + "\n");
                    cost[2]+= Double.parseDouble(members[i][3]);
                }
            }

            write1.flush();
            write2.flush();
            write3.flush();
            write1.close();
            write2.close();
            write3.close();

            Writer w4 = new FileWriter("prodajaSumarno.txt");
            BufferedWriter write4 = new BufferedWriter(w4);
            write4.write("Racunar " + Double.toString(cost[0]) + "\n");
            write4.write("Monitor " + Double.toString(cost[1]) + "\n");
            write4.write("Telefon " + Double.toString(cost[2]) + "\n");
            write4.flush();
            write4.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

