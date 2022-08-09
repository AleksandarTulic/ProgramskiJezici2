import java.util.*;
import java.util.stream.*;

public class Fakultet{
	public String name;
	public List<Student> arr = new ArrayList<Student>();
	
	public Fakultet(String name, List<String> students){
		this.name = name;
		
		//students.stream().forEach(System.out::println);
		for (String i : students){
			String []sp = i.split(";");
			arr.add(new Student(sp[0], sp[1], sp[2]));
		}
	}
}