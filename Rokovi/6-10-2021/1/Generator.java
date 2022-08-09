import java.io.*;
import java.util.*;

public class Generator{
	public static Random rand = new Random();
	public static List<String> uni = new ArrayList<String>();
	public static List<String> fakultet = new ArrayList<String>();
	public static List<String> student = new ArrayList<String>();
	
	public static void main(String []args){
		try{
			createUniverzitetZaDrzavu();

			for (String i : uni)
				createFakultetZaUniverzitet(i);
			
			for (String i : fakultet)
				createStudentsForFakultet(i);
			
			PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + File.separator + "studenti.txt");
			for (String i : student)
				pw.println(i);
			pw.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void createUniverzitetZaDrzavu(){
		int value = rand.nextInt(4 - 2 + 1) + 2;
		
		for (char a='A';a<='A'+value;a++)
			uni.add("UNIVERZITET_" + a);
	}
	
	public static void createFakultetZaUniverzitet(String uni){
		int value = rand.nextInt(10 - 2 + 1) + 2;
		
		for (char a='A';a<='A'+value;a++)
			fakultet.add("FAKULTET_" + a + ";" + uni);
	}
	
	public static void createStudentsForFakultet(String faku){
		int value = rand.nextInt(100 - 20 + 1) + 20;
		
		for (int a=1;a<=value;a++)
			student.add("IME_" + a + ";PREZIME_" + a + ";INDEKS_" + a + ";" + faku);
	}
}