import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.file.*;

public abstract class Adapter{
	private static final int CURR_NUMBERS_OF_ELEMENTS = 6;
	public String path = "";
	public List<String> lines = new ArrayList<String>();
	
	public Adapter(String path){
		this.path = path;
		
		try{
			lines = Files.readAllLines(Paths.get(path));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public abstract List<List<String> > getAllElements();
	
	public void createObjects(List<List<String> > arr){
		int num = 0;
		
		try{
			//ne razumijem kako funkcionise ovo sa nazivom
			//u jednom redu moze postojati vise objekata: vrsta, proizvodjac, proizvod
			for (List<String> i : arr){
				if (i.size() == CURR_NUMBERS_OF_ELEMENTS){
					Element pro = new Proizvod(i.get(0), i.get(1), Double.parseDouble(i.get(2)), Double.parseDouble(i.get(3)));
					Element proi = new Proizvodjac(i.get(4));
					Element vrsta = new Vrsta(i.get(5));
					
					synchronized(Main.o){
						Main.arr.add(pro);
						Main.arr.add(proi);
						Main.arr.add(vrsta);
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}