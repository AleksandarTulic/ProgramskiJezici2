import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.*;

public class Database extends Thread{
	public String path;
	public List<Character> arr = new ArrayList<Character>();
	
	public Database(){
	}
	
	public Database(String path){
		this.path = path;
	}
	
	@Override
	public void run(){
		try{
			File f = deserialization();
			
			List<String> lines = new ArrayList<String>();
			
			Scanner scan = new Scanner(f);
			
			while(scan.hasNextLine())
				lines.add(scan.nextLine());
			
			for (String i : lines)
				for (int j=0;j<i.length();j++)
					if (!arr.contains(i.charAt(j)))
						arr.add(i.charAt(j));
					
			List<Watch> arrWatch = new ArrayList<Watch>();
			for (Character i : arr)
				arrWatch.add(new Watch(f, i));
			
			for (Watch i : arrWatch)
				i.start();
			
			for (Watch i : arrWatch)
				i.join();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private File deserialization() throws Exception{
		FileInputStream fin = new FileInputStream(path);
		ObjectInputStream in = new ObjectInputStream(fin);
	
		File f = (File)in.readObject();
		in.close();
		return f;
	}
}