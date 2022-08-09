import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class TXT_Adapter extends Adapter{
	public TXT_Adapter(String path){
		super(path);
		
		super.createObjects(getAllElements());
	}
	
	public List<List<String> > getAllElements(){
		List<List<String>> ar = new ArrayList<List<String>>();
		
		try{
			List<String> lines = Files.readAllLines(Paths.get(super.path));
			
			for (String i : lines){
				List<String> arFill = new ArrayList<String>();
				String e = i.substring(2, i.length() - 2);
				String []sp = e.split("\\|\\|");
				for (String j : sp){
					arFill.add(j);
					//System.out.println(j + " " + e + " " + sp.length);
				}
				
				ar.add(arFill);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return ar;
	}
}