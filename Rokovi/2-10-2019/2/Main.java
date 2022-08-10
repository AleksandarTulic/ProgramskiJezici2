import java.util.*;
import java.util.stream.*;
import java.util.Map.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

/*

	ZURIO SAM - LOSE NAPISANO ALI RADI

*/

public class Main{
	public static First first = new First();
	public static Second second = new Second();
	public static Third third = new Third();
	public static Fourth fourth = new Fourth();

	public static void main(String ... args) throws Exception{
		first.start();
		second.start();
		third.start();
		fourth.start();
		first.join();
		
		synchronized(second){
			second.notify();
		}
	}
}

class First extends Thread{
	public Map<Character, List<String>> map = new HashMap<>();
	
	@Override
	public void run(){
		try{
			List <String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + File.separator + "dictionary.txt"));
			map = lines.stream().collect(Collectors.groupingBy(t -> t.charAt(0)));
			
			/*
			for (Entry<Character, List<String>> entry : map.entrySet()){
				System.out.println(entry.getKey());
			}
			*/
			
			System.out.println("Broj rijeci: " + lines.size());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

class Second extends Thread{
	public char v = 'a';
	private Random rand = new Random();
	public boolean flag = false;
	
	@Override
	public void run(){
		do{
			try{
				synchronized(this){
					wait();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
			
			if (flag){
				return;
			}
			
			v = 'a';
			
			do{
				v = (char)(rand.nextInt(26) + (int)'a'); 
			}while(!Main.first.map.entrySet().stream().map(t -> t.getKey()).collect(Collectors.toList()).contains(v));
			synchronized(Main.third){
				Main.third.notify();
			}
		}while(true);
	}
}

class Third extends Thread{
	public Random rand = new Random();
	public String rijec = "";
	public static List<Character> arrSamo = Arrays.asList('a', 'e', 'i', 'o', 'u');
	public List<Character> arrChar = new ArrayList<>();
	public boolean flag = false;
	
	@Override
	public void run(){
		do{
			try{
				synchronized(this){
					wait();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
			
			if (flag){
				return;
			}
			
			rijec = "";
			arrChar.clear();
			
			System.out.println("Rijec Pocinje slovom: " + Main.second.v);
			List<String> arr = Main.first.map.get(Main.second.v);
			rijec = arr.get(rand.nextInt(arr.size()));
			
			System.out.print("rijec: ");
			int br = 0;
			for (int i=0;i<rijec.length();i++){
				if ( i == 0 || arrSamo.contains(rijec.charAt(i))){
					System.out.print(rijec.charAt(i));
				}else{
					br++;
					System.out.print("*");
				}
			}
			
			System.out.println("\nUnesi suglasnike: ");
			Scanner scan = new Scanner(System.in);
			do{
				char val = scan.nextLine().charAt(0);
				
				if (!arrSamo.contains(val) && (val >= 'a' && val <= 'z')){
					arrChar.add(val);
					br--;
				}else{
					System.out.println("Lose pogadjanje ...");
				}
			}while(br > 0);
			
			synchronized(Main.fourth){
				Main.fourth.notify();
			}
		}while(true);
	}
}

class Fourth extends Thread{
	@Override
	public void run(){
		do{
			try{
				synchronized(this){
					wait();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
			
			String rijec = Main.third.rijec;
			String pogadjanje = "";
			
			int br = 0;
			for (int i=0;i<rijec.length();i++){
				if (i == 0 || Main.third.arrSamo.contains(rijec.charAt(i))){
					pogadjanje+=rijec.charAt(i);
				}else{
					pogadjanje+=Main.third.arrChar.get(br);
					br++;
				}
			}
			
			System.out.println("Inicijalna Rijec: " + rijec);
			System.out.println("Vasa Rijec: " + pogadjanje);
			
			if (rijec.equals(pogadjanje)){
				System.out.println("Pobijedili ste ...");
			
				break;
			}else{
				System.out.println("Izgubili ste ...");
				
				synchronized(Main.second){
					Main.second.notify();
				}
			}
		}while(true);
		
		Main.second.flag = true;
		Main.third.flag = true;
		synchronized(Main.second){
			Main.second.notify();
		}
		
		synchronized(Main.third){
			Main.third.notify();
		}
		
	}
}