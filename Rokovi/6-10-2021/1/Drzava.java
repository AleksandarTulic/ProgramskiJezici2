import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.stream.*;

public class Drzava{
	public String name;
	public List<Univerzitet> arr = new ArrayList<Univerzitet>();
	
	public Drzava(){
		try{
			List<String> lines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + File.separator + "studenti.txt"));
			
			List<String> arrUni = lines.stream().map(t -> t.split(";")[4]).distinct().collect(Collectors.toList());
			for (String i : arrUni){
				//List<String> arrFakulteti = lines.stream().filter(t -> t.split(";")[4].equals(i)).map(t -> t.split(";")[3]).distinct().collect(Collectors.toList());
				List<String> arrFakulteti = lines.stream().filter(t -> t.split(";")[4].equals(i)).collect(Collectors.toList());
				//arrFakulteti.stream().forEach(System.out::println);
				arr.add(new Univerzitet(i, arrFakulteti));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}