import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.Map.*;

public class Main{
	public static List<File> arr = new ArrayList<File>();
	public static List<String> arrPack = new ArrayList<String>();
	public static Map<String, List<File>> map = new HashMap<String, List<File>>();
	
	public static void main(String []args){
		try{
			getAllFiles(args[0]);
			System.out.println(numPackages());
			
			int value = 0;
			for (String i : arrPack){
				int curr = numClassesPerPack(i);
				value += curr;
				
				System.out.println(i + " " + curr);
			}
			
			System.out.println("UKUPAN BROJ KLASA: " + value);
			System.out.println("UKUPAN BROJ LINIJA KODA: " + allLinesOfCode());
			System.out.println("UKUPAN BROJ KOMENTARA: " + findAllComments());
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void getAllFiles(String path) throws Exception{
		File f = new File(path);
		File []list = f.listFiles();
		
		for (File i : list){
			if (i.isDirectory())
				getAllFiles(i.getPath());
			else if (i.getPath().endsWith(".java"))
				arr.add(i);
		}
	}
	
	//smatram da se cijeli package i naziv nalaze na istoj liniji
	public static int numPackages() throws Exception{
		for (File i : arr){
			List<String> lines = Files.readAllLines(Paths.get(i.getPath()));
			String eve = "";
			
			for (String j : lines)
				eve += " " + j;
			
			eve = eve.substring(1, eve.length());
			String []sp = eve.split(";");
			for (String j : sp){
				if (j.contains("package")){
					if (!arrPack.contains(j)){
						arrPack.add(j);
						map.put(j, Arrays.asList(i));
					}
					
					List<File> arrF = map.get(j);
					List<File> aa = new ArrayList<File>();
					for (File k : arrF)
						aa.add(k);
					aa.add(i);
					map.put(j, aa);
					break;
				}
			}
		}
		
		return arrPack.size();
	}
	
	public static int numClassesPerPack(String pack) throws Exception{
		int num = 0;
		
		for (Entry<String, List<File>> entry : map.entrySet()){
			if (pack.equals(entry.getKey())){
				for (File i : entry.getValue()){
					List<String> lines = Files.readAllLines(Paths.get(i.getPath()));
					String eve = "";
					
					for (String j : lines)
						eve += " " + j;
				
					num += compareStringClass(eve, " class ");
				}
			}
		}
		
		return num;
	}
	
	private static int compareStringClass(String a, String b){
		int num = 0;
		for (int i=0;i<=a.length()-b.length();i++){
			String sub = a.substring(i, i + b.length());
			//System.out.println(sub);
			if (sub.equals(b))
				num++;
		}
		
		return num;
	}
	
	public static int allLinesOfCode() throws Exception{
		int num = 0;
		for (File i : arr){
			List<String> lines = Files.readAllLines(Paths.get(i.getPath()));
			
			num += lines.size();
		}
		
		return num;
	}
	
	public static int findAllComments() throws Exception{
		int num = 0;
		
		for (File i : arr){
			List<String> lines = Files.readAllLines(Paths.get(i.getPath()));
			
			boolean flagMul = false;
			for (String j : lines){
				boolean flag = false;
				for (int k=0;k<j.length() - 1;k++){
					//System.out.println();
					if (j.charAt(k) == '/' && j.charAt(k + 1) == '/'){
						flag = true;
					}else if (j.charAt(k) == '/' && j.charAt(k + 1) == '*'){
						flag = true;
						flagMul = true;
					}else if (j.charAt(k) == '*' && j.charAt(k + 1) == '/'){
						flag = true;
						flagMul = false;
					}
				}
				
				if (flag || flagMul)
					num++;
			}
		}
		
		return num;
	}
}