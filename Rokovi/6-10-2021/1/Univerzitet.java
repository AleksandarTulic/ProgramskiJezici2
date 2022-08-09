import java.util.*;
import java.util.stream.*;

public class Univerzitet{
	public String name;
	public List<Fakultet> arr = new ArrayList<Fakultet>();
	
	public Univerzitet(String name, List<String> arr){
		this.name = name;
		
		List<String> names = arr.stream().map(t -> t.split(";")[3]).distinct().collect(Collectors.toList());
		
		for (String i : names){
			List<String> students = arr.stream().filter(t -> t.split(";")[3].equals(i)).map(t -> t.split(";")[0] + ";" + t.split(";")[1] + ";" + t.split(";")[2]).distinct().collect(Collectors.toList());
			this.arr.add(new Fakultet(i, students));
		}
	}
}