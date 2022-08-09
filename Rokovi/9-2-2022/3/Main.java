import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.io.*;

public class Main{
	public static List<File> arr = new ArrayList<File>();
	public static String ext = "";
	public static String word = "";
	
	public static void main(String []args){
		try{
			ext = "." + args[2];
			word = args[1].toUpperCase();
			find(args[0]);
			
			for (File i : arr){
				System.out.println("PATH: " + i.getPath() + ",NUMBER OF WORDS: " + countWords(i));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void find(String path) throws Exception{
		File f = new File(path);
		
		if (f.isDirectory()){
			File []arrFile = f.listFiles();
			for (File i : arrFile)
				find(i.getPath());
		}else if (f.isFile() && f.getPath().endsWith(ext)){
			arr.add(f);
		}
	}
	
	public static int countWords(File f) throws Exception{
		List<String> lines = Files.readAllLines(Paths.get(f.getPath()));
		
		int num = 0;
		for (String i : lines){
			String []sp = i.split(" ");
			
			for (String j : sp){
				//System.out.println(j);
				String tt = j.trim().toUpperCase();
				if (tt.equals(word))
					num++;
			}
		}
		
		return num;
	}
}