import java.io.*;

public class ImportFile{
	public String path;
	
	public ImportFile(){
	}
	
	public ImportFile(String path){
		this.path = path;
	}
	
	public void importFile(){
		if (path.endsWith(".csv")){
			CSV_Adapter csv = new CSV_Adapter(Main.WHERE_TO_LOOK + File.separator + path);
		}else if (path.endsWith(".txt")){
			TXT_Adapter csv = new TXT_Adapter(Main.WHERE_TO_LOOK + File.separator + path);
		}
	}
}