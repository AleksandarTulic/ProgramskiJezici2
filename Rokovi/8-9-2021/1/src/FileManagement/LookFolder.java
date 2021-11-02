package FileManagement;

import java.io.File;
import java.nio.file.*;

public class LookFolder extends Thread{
	private String folderPath;
	private boolean flag = false;
	
	public LookFolder(String folderPath) {
		this.folderPath = folderPath;
	}
	
	@Override
	public void run() {
		File f = new File(folderPath);
		
		if ( f.exists() ) {
			flag = true;
			try {
				WatchService ws = FileSystems.getDefault().newWatchService();
				
				Path path = Paths.get(folderPath);
				path.register(ws, StandardWatchEventKinds.ENTRY_CREATE);
				
				boolean poll = true;
				
				while (poll) {
					WatchKey key = ws.take();
					for (WatchEvent <?> event : key.pollEvents()) {
						LookFile lf = new LookFile(folderPath + File.separator + event.context());
						lf.start();
					}
					
					poll = key.reset();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean getFlag() {
		return flag;
	}
}
