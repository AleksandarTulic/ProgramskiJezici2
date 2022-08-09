package help;

import java.io.*;
import java.util.logging.*;

public class Log{
	public Logger logger;
	FileHandler fh;
	
	public Log(String fileName){
		try{
			File f = new File(fileName);
			
			if (!f.exists()){
				f.createNewFile();
			}
			
			fh = new FileHandler(fileName, true);
			logger = Logger.getLogger(fileName);
			logger.addHandler(fh);
			SimpleFormatter sf = new SimpleFormatter();
			fh.setFormatter(sf);
			logger.setUseParentHandlers(false);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}