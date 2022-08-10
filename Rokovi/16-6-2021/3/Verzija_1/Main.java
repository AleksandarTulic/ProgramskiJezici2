import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{
	public static List<String> arr = new ArrayList<String>();
	public static List<String> arrName = new ArrayList<String>();
	public static String ext = "";
	public static String whereToCopy = "";
	
	public static void main(String []args){
		try{
			ext = args[2];
			whereToCopy = args[1];
			findAll(args[0]);
			arr.stream().forEach(System.out::println);
			
			for (int i=0;i<arr.size();i++){
				copy(arr.get(i), whereToCopy + File.separator + arrName.get(i));
			}
		}catch (Exception e){
		}
	}
	
	public static void findAll(String path) throws Exception{
		File f = new File(path);
		
		if (f.isDirectory()){
			File []list = f.listFiles();
			
			for (File  i : list)
				findAll(i.getPath());
		}else
			if (path.endsWith(ext)){
				arr.add(path);
				arrName.add(f.getName());
			}
	}
	
	public static void copy(String inFile, String outFile) throws Exception{
		InputStream in = new FileInputStream(inFile);
		OutputStream out = new FileOutputStream(outFile);
	
		byte []buffer = new byte[4096];
		
		while(in.read(buffer) != -1){
			out.write(buffer);
		}
		
		in.close();
		out.close();
	}
}