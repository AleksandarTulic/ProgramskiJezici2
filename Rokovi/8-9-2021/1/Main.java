import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{
	public static List<Element> arr = new ArrayList<Element>();
	public static List<String> arrFolder = new ArrayList<String>();
	public static Object o = new Object();
	public static final String WHERE_TO_LOOK = System.getProperty("user.dir") + File.separator + "PJ2";
	
	public static void main(String []args) throws Exception{
		ImportFile imp = new ImportFile();
		
		Watch watch = new Watch(WHERE_TO_LOOK);
		watch.start();
		
		do{
			System.out.println("----------------------------");
			System.out.println("IMPORT FAJL ----------------");
			System.out.println("AUTO_IMPORT FOLDER ---------");
			System.out.println("STATUS ---------------------");
			System.out.println("SAVE -----------------------");
			System.out.println("----------------------------");
		
			Scanner scan = new Scanner(System.in);
			System.out.print("Option: ");
			String option = scan.nextLine();
			
			if ("SAVE".equals(option)){
				serialization();
			}else if ("STATUS".equals(option)){
				status();
			}else if (option.startsWith("IMPORT")){
				String []sp = option.split(" ");
				imp.path = sp[1];
				imp.importFile();
			}else if (option.startsWith("AUTO_IMPORT")){
				String []sp = option.split(" ");
				Watch wa = new Watch(sp[1]);
				wa.start();
			}
		}while(true);
	}
	
	public static void status(){
		System.out.println("-------------------------------------------");
		System.out.println("Broj Objekata: " + arr.size());
		System.out.println("Folderi: ");
		arrFolder.stream().forEach(System.out::println);
		System.out.println("-------------------------------------------");
	}
	
	public static void serialization(){
		try {
			FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir") + File.separator + "podaci.ser");
			ObjectOutputStream obj = new ObjectOutputStream(fout);
			obj.writeObject(Main.arr);
			obj.close();
			fout.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}