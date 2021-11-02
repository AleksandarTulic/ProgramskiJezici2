package FileManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import elements.CommonObject;
import elements.Proizvod;
import elements.Proizvodjac;
import elements.Vrsta;

public class LookFile extends Thread{
	private String filePath;
	
	public LookFile(String filePath) {
		this.filePath = filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	@SuppressWarnings("resource")
	@Override
	public void run() {
		File f = new File(filePath);
		
		if ( f.exists() ) {
			try {
				Scanner scan = new Scanner(f);
				
				while ( scan.hasNextLine() ) {
					String line = scan.nextLine();
					String []sp = line.split("\\|");

					if ( ">>>Proizvod".equals(sp[0]) ) {
						Proizvod buffer = Proizvod.imporT(line);
						
						if ( buffer != null ) {
							CommonObject.cm.add(buffer);
						}
					}else if ( ">>>Vrsta".equals(sp[0]) ) {
						Vrsta buffer = Vrsta.imporT(line);
						
						if ( buffer != null ) {
							CommonObject.cm.add(buffer);
						}
					}else if (">>>Proizvodjac".equals(sp[0])) {
						Proizvodjac buffer = Proizvodjac.imporT(line);
						
						if ( buffer != null ) {
							CommonObject.cm.add(buffer);
						}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
