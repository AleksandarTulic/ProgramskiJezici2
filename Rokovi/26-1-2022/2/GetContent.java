import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class GetContent extends Thread{
	public String path;
	
	public GetContent(String path){
		this.path = path;
	}
	
	@Override
	public void run(){
		try{
			File f = new File(path);
			
			if (f.exists()){
				String allPath = serialization(f);
				Database db = new Database(allPath);
				db.start();
				db.join();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public String serialization(File f) throws Exception{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime ldt = LocalDateTime.now();
		
		String date = dtf.format(ldt).toString();
		
		File folder = new File(f.getParent() + File.separator + date);
		if (!folder.exists())
			folder.mkdir();
		
		String name = f.getName().substring(0, f.getName().length() - 4);
		String allPath = f.getParent() + File.separator + File.separator + date + File.separator + name + ".ser";
		FileOutputStream fout = new FileOutputStream(allPath);
		ObjectOutputStream out = new ObjectOutputStream(fout);
		
		out.writeObject(f);
		out.flush();
		out.close();
		
		return allPath;
	}
}