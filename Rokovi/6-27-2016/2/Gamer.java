import java.io.*;
import java.util.*;

public class Gamer extends Thread{
	private int id;
	public static int num = 0;
	private List<String> coll = new ArrayList<String>();
	private boolean flagWord = false;
	
	public Gamer(){
		id = ++num;
	}
	
	@Override
	public void run(){
		//imat ce sta da radi sve dok bag nije prazan
		try{
			while (true){
				synchronized(Main.a){
					if ( !Bag.isEmpty() && Bag.flag ){
						//biramo rijec
						//samo jedan moze
						//System.out.println(Bag.flag + " " + Bag.isEmpty() + " " + Thread.currentThread().getId());
						String ch = "";
						ch = Bag.choosingWord();
						
						coll.add(ch);
					}else{
						if ( !Bag.flag ){
							synchronized(this){
								wait();
							}
						}else{
							break;
						}
					}
				}
				
				sleep(1000 * Bag.word.length());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		//ovo je ovde sinhronizovano jer zelimo da jedan igrac ispise sve podatke o sebi odjednom a ne da bude prekinut od ispisa drugog igraca
		synchronized(Main.a){
			System.out.println();
			System.out.println("IGRAC: " + id);
			System.out.println("Rijeci: ");
			for (String i : coll){
				System.out.println(i);
			}
			
			checkWord("", coll);
			if ( flagWord ){
				System.out.println("Rijec postoji.");
			}else{
				System.out.println("Rijec ne postoji.");
			}
			System.out.println();
		}
	}
	
	public void checkWord(String curr, List<String> rij){
		if ( curr.length() == Bag.word.length() ){
			//System.out.println(curr + " " + Bag.word);
			if ( Bag.word.equals(curr) ){
				flagWord = true;
			}
		}else if ( curr.length() > Bag.word.length() ){
			return;
		}
		
		for (int i=0;i<rij.size();i++){
			List <String> buf = new ArrayList<String>();
			for (int j=0;j<rij.size();j++){
				if ( i != j ){
					buf.add(rij.get(j));
				}
			}
			
			checkWord(curr+rij.get(i), buf);
		}
	}
}