import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.io.*;

public class Main{
	public static final int SIZE_X = 50;
	public static final int SIZE_Y = 50;
	public static Object[][] map = new Object[SIZE_X][SIZE_Y];
	public static List<Muzej> arrMuzej = new ArrayList<Muzej>();
	private static Random rand = new Random();
	
	public static void main(String []args){
		//creating Turista
		List<Turista> arrTurista = new ArrayList<Turista>();
		
		//nije receno da na istom polju moze biti vise turista
		//a i logicno je da na jednom polju moze biti vise turista
		//dok ne moze vise greadjevina biti na istom polju
		for (int i=0;i<50;i++)
			arrTurista.add(new Turista(rand.nextInt(50), rand.nextInt(50)));
		
		//creating Spomenik
		Main.createSpomenik();
		
		//creating ZabavniPark
		Main.createZabavniPark();
		
		//creating files for museums
		Main.createFilesForMuseums();
		
		//creating Muzej
		Main.createMuzej();
		
		//creating Crkva
		Main.createCrkva();
		
		//change days for museums
		PromijeniDan promijeniDan = new PromijeniDan();
		promijeniDan.start();
		
		for (Turista i : arrTurista)
			i.start();
		
		try{
			for (Turista i : arrTurista)
				i.join();
			
			promijeniDan.stopWorking();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		Collections.sort(arrTurista, (a, b) -> {return a.getNumberOfFiles() > b.getNumberOfFiles() ? -1 : 
		a.getNumberOfFiles() == b.getNumberOfFiles() ? 0 : 1;});
		
		System.out.println("==========================================");
		System.out.println();
		
		for (Turista i : arrTurista)
			System.out.println(i);
		
		System.out.println();
		System.out.println("==========================================");
	}
	
	public static void createSpomenik(){
		for (int i=0;i<20;i++){
			do{
				int x = rand.nextInt(50);
				int y = rand.nextInt(50);
				
				if (Main.map[x][y] == null){
					Main.map[x][y] = new Spomenik("Spomenik_" + i, x, y, "Posvecen_" + i);
					break;
				}
			}while(true);
		}
	}
	
	public static void createZabavniPark(){
		for (int i=0;i<20;i++){
			do{
				int x = rand.nextInt(50);
				int y = rand.nextInt(50);
				
				if (Main.map[x][y] == null){
					Main.map[x][y] = new ZabavniPark("ZabavniPark_" + i, x, y);
					break;
				}
			}while(true);
		}
	}
	
	public static void createMuzej(){
		for (int i=0;i<20;i++){
			do{
				int x = rand.nextInt(50);
				int y = rand.nextInt(50);
				
				if (Main.map[x][y] == null){
					Main.map[x][y] = new Muzej("Muzej_" + i, x, y, new File(System.getProperty("user.dir") + 
					File.separator + Muzej.path + File.separator + i + ".txt"));
					break;
				}
			}while(true);
		}
	}
	
	public static void createCrkva(){
		for (int i=0;i<20;i++){
			do{
				int x = rand.nextInt(50);
				int y = rand.nextInt(50);
				
				if (Main.map[x][y] == null){
					Main.map[x][y] = new Crkva("Crkva_" + i, x, y);
					break;
				}
			}while(true);
		}
	}
	
	public static void createFilesForMuseums(){
		try{
			for (int i=0;i<20;i++){
				String value = "opis Muzeja " + i;
				Files.write(Paths.get(System.getProperty("user.dir") + File.separator + Muzej.path + File.separator
				+ i + ".txt"), value.getBytes());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}