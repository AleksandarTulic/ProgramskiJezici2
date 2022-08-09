package file;

import kupac.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import kasa.*;

public class FileOperations {
	public static List<String> paths = new ArrayList<String>();
	
	public static void writeChild(Kupac kupac, Kasa kasa) {
		write(kupac, kasa, "child_");
	}
	
	public static void writeBuyer(Kupac kupac, Kasa kasa) {
		write(kupac, kasa, "buyer_");
	}
	
	private static void write(Kupac kupac, Kasa kasa, String str) {
		try {
			String where = System.getProperty("user.dir") + File.separator + str + System.currentTimeMillis() + ".txt";
			paths.add(where);
			Path path = Paths.get(where);
			byte []bytes = (kasa.toString() + "\n" + kupac.toString()).getBytes();
			
			Files.write(path, bytes);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> getElements() {
		List<String> arr = new ArrayList<String>();
		
		try {
			for (String i : paths) {
				byte[] value = Files.readAllBytes(Paths.get(i));
				arr.add(new String(value));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return arr;
	}
}
