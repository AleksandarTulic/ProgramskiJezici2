import java.util.*;
import java.nio.file.*;
import java.nio.*;
import java.io.*;
import java.util.stream.*;

public class ParserPolja{
	public void getMapuKretanja(){
		try{
			List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + File.separator + "staza.csv"));
			
			Main.map = new Polje[lines.size()];
			
			int br = 0;
			for (String i : lines){
				String []sp = i.split(";");
				Main.map[br++] = new Polje(getTipPolja(sp[0]), sp.length > 1 ? Integer.parseInt(sp[1].split("%")[0]) : -1);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private TipPolja getTipPolja(String tip){
		if ("".equals(tip))
			return TipPolja.obicno;
		else if ("".equals(tip))
			return TipPolja.neravno;
		
		return TipPolja.klizavo;
	}
}