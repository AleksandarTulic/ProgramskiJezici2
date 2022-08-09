import java.io.*;
import java.util.*;

public class Watch extends Thread{
	public File f = null;
	public Character ch = '-';
	public static Object o = new Object();
	public int num = 0;
	
	public Watch(File f, Character ch){
		this.f = f;
		this.ch = ch;
	}
	
	@Override
	public void run(){
		try{
			List<String> lines = new ArrayList<String>();
			
			Scanner scan = new Scanner(f);
			
			while(scan.hasNextLine())
				lines.add(scan.nextLine());
			
			for (String i : lines)
				for (int j=0;j<i.length();j++)
					if (i.charAt(j) == ch){
						synchronized(o){
							System.out.println("Karakter: " + ch + ", Broj Pojavljivanja: " + (++num));
						}
					}
			
			Main.map.put(ch, num);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}