import java.util.*;
import java.io.*;
import java.nio.*;
import java.nio.file.*;

public class Watch extends Thread{
	public String path = "";
	
	public Watch(String path){
		Main.arrFolder.add(path);
		this.path = path;
	}
	
	@Override
	public void run(){
		try{
			WatchService ws = FileSystems.getDefault().newWatchService();
			
			Path currPath = Paths.get(path);
			
			currPath.register(
				ws,
				StandardWatchEventKinds.ENTRY_CREATE
			);
			
			WatchKey key;
			while((key = ws.take()) != null){
				for (WatchEvent<?> event : key.pollEvents()){
						//da bi se podaci zapisali koreknto kada se kopira
						Thread.sleep(10);
						
						//System.out.println(path + File.separator + event.context().toString());
						if (event.context().toString().endsWith(".csv")){
							CSV_Adapter csv = new CSV_Adapter(path + File.separator + event.context().toString());
						}else if (event.context().toString().endsWith(".txt")){
							TXT_Adapter txt = new TXT_Adapter(path + File.separator + event.context().toString());
						}
				}
				
				key.reset();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}