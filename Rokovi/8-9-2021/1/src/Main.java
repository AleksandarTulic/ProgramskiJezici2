
import java.io.File;
import java.io.*;
import java.util.*;

import FileManagement.LookFile;
import FileManagement.LookFolder;
import elements.CommonObject;

public class Main {
	public static String homeDir = System.getProperty("user.home");
	public static List<String> folder = new ArrayList<String>();
	
	public static void serialization(){
		try {
			FileOutputStream fout = new FileOutputStream(homeDir + File.separator + "podaci.ser");
			ObjectOutputStream obj = new ObjectOutputStream(fout);
			obj.writeObject(CommonObject.cm);
			obj.close();
			fout.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("--------------------------");
			System.out.println("IMPORT fajl---------------");
			System.out.println("AUTO_IMPORT FOLDER--------");
			System.out.println("STATUS--------------------");
			System.out.println("SAVE----------------------");
			System.out.println("--------------------------");
			
			System.out.print("Unesite Opciju: ");
			
			String option = scan.nextLine();
			
			String []line = option.split(" ");
			
			if ( line.length == 2 ) {
				if ( "IMPORT".equals(line[0]) ) {
					LookFile lf = new LookFile(System.getProperty("user.dir") + File.separator + "PJ2_exam_data" + File.separator + line[1]);
					lf.start();
				}else if ( "AUTO_IMPORT".equals(line[0]) ) {
					LookFolder lf = new LookFolder(System.getProperty("user.dir") + File.separator + "PJ2_exam_data" + File.separator + line[1]);
					lf.start();
					
					//ne mora znaciti da putanja postoji
					if ( lf.getFlag() ) {
						folder.add(line[1]);
					}
				}else {
					System.out.println("GRESKA!!!");
				}
			}else if ( line.length == 1 ) {
				if ( "STATUS".equals(line[0]) ) {
					System.out.println("Folderi koji se prate: ");
					folder.stream().forEach(t -> System.out.println(t));
					System.out.println("Broj stavki u kolekciji: " + CommonObject.cm.size());
				}else if ( "SAVE".equals(line[0]) ) {
					serialization();
				}else {
					System.out.println("GRESKA!!!");
				}
			}else {
				System.out.println("GRESKA!!!");
			}
		}while(true);
	}
}
