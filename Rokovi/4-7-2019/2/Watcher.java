import java.nio.file.*;
import java.io.*;
import java.util.*;

public class Watcher extends Thread{
	public static final String conf = "partneri.txt";
	
	@Override
	public void run(){
		try{
			while (true){
				File f = new File(conf);
				
				if ( f.exists() ){
					Scanner scan = new Scanner(f);
					
					while (scan.hasNextLine()){
						String line = scan.nextLine();
						
						Partner p = new Partner(line);
						if ( checkExist(p.getIme()) ){
							FileWriter fw = new FileWriter("pozivnice" + File.separator + p.getIme() + ".txt");
							
							String []ispis = new String[5];
							ispis[0] = "Postovani partneru " + p.getIme() + " kompanije JAVA";
							ispis[1] = "Pozivamo Vas na svecanu proslavu godisnjice nase kompanije koja ce se odrzati u nasim prostorijama";
							ispis[2] = "u petak, 05.07.2019. godine, sa pocetkom u 18:00 casova.";
							ispis[3] = "*****************************************";
							ispis[4] = "Java kompanija, jun 2019.";
							
							int maks = -1;
							for (String i : ispis){
								maks = Math.max(maks, i.length());
							}
							
							maks+=20;
							for (int j=0;j<maks+2;j++){
								fw.write("-");
							}
							
							for (String i : ispis){
								
								String lijevo = "";
								String desno = "";
								
								int duzina = i.length();
								int pola = maks / 2;
								int sl = pola - (duzina / 2);
								int sd = maks - (sl + duzina);
								
								for (int j=0;j<sl;j++){
									lijevo+=" ";
								}
								
								for (int j=0;j<sd;j++){
									desno+=" ";
								}
								
								fw.write('\n');
								fw.write("|" + lijevo + i + desno + "|");
								fw.write('\n');
								
								for (int j=0;j<maks+2;j++){
									fw.write("-");
								}
								
								fw.write('\n');
							}
							
							fw.close();
							
							File fOut = new File("pozivnice" + File.separator + p.getIme() + ".txt");
							
							if ( fOut.exists() ){
								fOut.setWritable(false);
								Slanje s = new Slanje(p.getIme() + ".txt");
								s.start();
							}
						}
					}
					
					scan.close();
				}
				
				sleep(2000);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean checkExist(String ime){
		ime+=".txt";
		File f = new File("pozivnice");
		String []files = f.list();
		
		for (String i : files){
			if ( ime.equals(i) ){
				return false;
			}
		}
		
		return true;
	}
}