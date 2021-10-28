import java.nio.file.*;
import java.io.*;
import java.util.*;

public class Slanje extends Thread{
	//za svaki fajl kreiran tj pozivnicu kreira se jedna niit za slanje koja onda obavlja posao navedeni
	private String fileName;
	
	public Slanje(String fileName){
		this.fileName = fileName;
	}
	
	@Override
	public void run(){
		File f = new File("partneri.txt");
		File fCopy = new File("pozivnice" + File.separator + fileName);
		boolean flag = false;
		
		try{
			if ( f.exists() && fCopy.exists() ){
				Scanner scan = new Scanner(f);
				String emailP = "";
				
				while ( scan.hasNextLine() ){
					String line = scan.nextLine();
					Partner p = new Partner(line);
					
					if ( fileName.equals(p.getIme() + ".txt") ){
						flag = true;
						emailP = p.getEmailP();
						break;
					}
				}
				
				scan.close();
				
				if ( flag ){
					(new File(emailP)).mkdir();
					copyFile(fCopy, (new File(emailP + File.separator + fileName)));
					Pair buffer = numAccept(emailP);
					System.out.println("Provajder: " + emailP);
					System.out.println("Od pozvanih " + buffer.getY() + " kompanija " + buffer.getX() + " je prihavtilo poziv.");
				}
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static Pair numAccept(String emailP){
		File f = new File(emailP);
		int numFiles = f.list().length;
		
		Random rand  = new Random();
		int accept = rand.nextInt(numFiles);
		
		return new Pair(accept, numFiles);
	}
	
	private static void copyFile(File src, File dest) throws IOException{
		InputStream is = new FileInputStream(src);
		OutputStream os = new FileOutputStream(dest);
		
		byte[]buffer = new byte[1024];
		int length;
		
		while ((length = is.read(buffer)) > 0){
			os.write(buffer, 0 , length);
		}
		
		is.close();
		os.close();
	}
}

//tekst zadatka je malo konfuzan
/*
	- receno je sljedece: Slanje obavlja nit tako da cim se pojavi novi fajl u pozivnicima vrsi njegovo kopiranje u odgovarajuci folder.
		- sto znaci da ovaj proces sljanja kao i pregled da li je dodat neki fajl treba da stalno bude aktivno da stalno radi, ali onda nikad nece biti kraju procesu
		- tj ne znamo kada proces slanja staje pa ne mozemo reci koliko kompanija je prihvatilo pozivnicu
		- sto znaci da onda nakog svakog pojedinacnog slanja trebam gledati koliko je njih prihvatilo pozivnicu od trenutnog broja fajlova(pozivnica) u folderu
	- takodje na osnovu prethodno opisanog moramo onda i da provjeravamo da li fajl koji se nalazi u pozivnicama postoji u fajlu partneri.txt jer na onovu toga nalazimo
emailP koji predstavlja folderu u koji se smjesta odgovarajuca pozivnica
*/