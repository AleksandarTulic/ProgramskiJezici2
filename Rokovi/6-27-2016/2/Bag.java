import java.io.*;
import java.util.*;

public class Bag extends Thread{
	public static boolean flag = true;
	private int numWords = 0;
	public static final String word = "LIMUNADE";
	private static List <String> choose = new ArrayList<String>();
	
	public Bag(int numWords){
		this.numWords = numWords;
	}
	
	//https://coderedirect.com/questions/182673/synchronized-block-not-working
	@Override
	public void run(){
		if ( numWords > 0 ){
			try{
				while (true){
					//zabrana biranja igracima
					//ovde nemoramo synchronized
					flag = false;
					
					//ovo samo jedan
					for (int i=0;i<word.length();i++){
						choose.add(getSubstring(word, i, i));
					}
					
					numWords--;
					
					if ( numWords > 0 ){
						for (int i=0;i<word.length()-1;i+=2){
							choose.add(getSubstring(word, i, i + 1));
						}
					}
					
					numWords--;
					
					if ( numWords > 0 ){
						for (int i=0;i<word.length()-4;i+=4){
							choose.add(getSubstring(word, i, i + 4));
						}
					}
					
					numWords--;
					
					flag = true;
					
					for (Gamer i : Main.plays){
						synchronized(i){
							i.notify();
						}
					}
					
					sleep(500);
				
					if ( numWords <= 0 ){
						break;
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	private String getSubstring(String a, int l, int r) throws Exception{
		String res = "";
		for (int i=l;i<=r;i++){
			res+=a.charAt(i);
		}
		
		return res;
	}
	
	public static synchronized String choosingWord() throws Exception{
		Random rand = new Random();
		//System.out.println("VRIJEDNOST: " + choose.size());
		int pos = rand.nextInt(choose.size());
		
		return choose.remove(pos);
	}
	
	public static boolean isEmpty(){
		return choose.size() == 0;
	}
}

/*
	- kako sam ja shvatio potrebno je da vrsimo podjelu svaki put maks 3 rijeci
		- jer to predstavlja jedan krug
		- a svaki krug se desava svakih 5 sekundi
*/