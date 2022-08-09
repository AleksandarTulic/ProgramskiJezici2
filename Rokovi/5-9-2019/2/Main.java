import baza.*;
import registar.*;
import artikal.*;

import java.util.*;
import java.io.*;

public class Main{
	private static final String fileName = "info.txt";
	
	public static Map<String, Registrator<Artikal> > map = new HashMap<String, Registrator<Artikal> >();
	
	public static void main(String []args){
		Baza <Artikal>
	}
	
	public static fillMap(){
		try{
			File f = new file(System.getProperty("user.dir") + File.separator + fileName);
			
			if (f.exists()){
				Scanner scan = new Scanner(f);
				
				while (scan.hasNextLine()){
					String []line = scan.nextLine().split(",");
					
					String prodavnica = line[0];
					String naziv = line[1];
					String opis = line[2];
					String barCode = line[5];
					
					Artikal a = null;
					
					if ("k".equals(line[4])){
						a = new ROprema(barCode, naziv, opis);
					}else if ("h".equals(line[4])){
						a = new Hrana(barCode, naziv, opis);
					}else if ("b".equals(line[4])){
						a = new BTehnika(barCode, naziv, opis);
					}
					
					if (!map.containsKey(prodavnica)){
						map.put(prodavnica, new Registrator<Artikal>);
					}
					
					map[prodavnica].add(a);
				}
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}