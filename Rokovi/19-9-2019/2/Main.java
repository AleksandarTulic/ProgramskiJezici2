import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.stream.*;

public class Main{
	private static final String STRING_SRC = "-src";
	private static final String STRING_DEST = "-dest";
	private static final String STRING_UNIQUE = "-unique";
	private static final String STRING_LIMIT = "-limit";
	
	public static void main(String ... args){
		List<String> src = getSrc(args);
		String dest = getDest(args);
		boolean flagUnique = checkUnique(args);
		int limit = getLimit(args);
		
		/*
		for (String i : src){
			System.out.println(i);
		}
		
		System.out.println(limit);
		System.out.println(flagUnique);
		System.out.println(dest);
		*/
		
		File ff = new File(dest);
		if (src.size() >= 1 && !"".equals(dest)){
			List<String> global = new ArrayList<>();
			for (String i : src){
				File f = new File(i);
				List<String> arr = new ArrayList<>();
				
				if (f.exists()){
					try{
						arr = Files.readAllLines(Paths.get(f.getPath()));
					}catch (Exception e){
						//ako se desi greska da se ne ispisuje jer program jos treba da radi - ljepse izgleda
					}
				}
				
				if (limit == -1 || limit == 0){
					global.addAll(arr);
				}else{
					for (int j=0;j<Math.min(limit, arr.size());j++){
						global.add(arr.get(j));
					}
				}
			}
			
			if (flagUnique){
				global = global.stream().distinct().collect(Collectors.toList());
			}
			
			try{
				PrintWriter pw = new PrintWriter(ff);
				
				for (String i : global){
					pw.println(i);
				}
				
				pw.flush();
				pw.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}else{
			System.out.println("Not valid ....");
		}
	}
	
	private static List<String> getSrc(String ... args){
		List<String> arr = new ArrayList<>();
		boolean flag = false;
		
		for (String i : args){
			if (STRING_SRC.equals(i)){
				flag = true;
			}else if (STRING_DEST.equals(i) || STRING_LIMIT.equals(i) || STRING_UNIQUE.equals(i)){
				flag = false;
			}else if (flag){
				arr.add(i);
			}
		}
		
		return arr;
	}
	
	private static String getDest(String ... args){
		boolean flag = false;
		
		for (String i : args){
			if (STRING_DEST.equals(i)){
				flag = true;
			}else if (STRING_SRC.equals(i) || STRING_LIMIT.equals(i) || STRING_UNIQUE.equals(i)){
				flag = false;
			}else if (flag){
				return i;
			}
		}
		
		return "";
	}
	
	private static int getLimit(String ... args){
		boolean flag = false;
		int res = -1;
		
		for (String i : args){
			if (STRING_LIMIT.equals(i)){
				flag = true;
			}else if (STRING_SRC.equals(i) || STRING_DEST.equals(i) || STRING_UNIQUE.equals(i)){
				flag = false;
			}else if (flag){
				try{
					res = Integer.parseInt(i);
				}catch (Exception e){
					res = -1;
				}
				
				return res;
			}
		}
		
		return res;
	}
	
	private static boolean checkUnique(String ... args){
		for (String i : args)
			if (STRING_UNIQUE.equals(i))
				return true;
			
		return false;
	}
}