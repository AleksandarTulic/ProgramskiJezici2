package fileOperations;

import java.io.*;
import java.util.*;

public class Operation {
	public List<String> arr = new ArrayList<>();
	public String ext;
	
	public Operation(String ext) {
		this.ext = ext;
	}
	
	public void findAll(String path) {
		File f = new File(path);
		
		if (f.exists()) {
			if (f.isDirectory()) {
				File []l = f.listFiles();
				
				for (File i : l) {
					findAll(i.getPath());
				}
			}else if (f.getName().endsWith(ext)) {
				arr.add(f.getPath());
			}
		}
	}
	
	public void copyAll(String to) {
		for (String i : arr) {
			copy(i, to);
		}
	}
	
	private void copy(String from, String to) {
		File f1 = new File(from);
		File f2 = new File(to);
		
		if (f1.exists() && f2.exists()) {
			try {
				InputStream in = new FileInputStream(f1.getPath());
				OutputStream out = new FileOutputStream(f2.getPath() + File.separator + f1.getName());
				
				byte []buffer = new byte[4096];
				
				while (in.read(buffer) != -1) {
					out.write(buffer);
				}
				
				in.close();
				out.flush();
				out.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
