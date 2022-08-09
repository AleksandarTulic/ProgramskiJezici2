package ispis;

import help.*;
import reklama.*;
import korisnik.*;

public class Ispis extends Thread{
	public static Object o = new Object();
	private Reklama r;
	
	public Ispis(Reklama r){
		this.r = r;
	}
	
	@Override
	public void run(){
		if ( r instanceof Humanitarna ){
			Random rand = new Random();
			int option = rand.nextInt(2 - 1 + 1) + 1;
			
			if (option == 1){
				Ispis.tekstIspis(r.getOpis());
			}else{
				Ispis.animatedIspis(r.getOpis());
			}
		}else if (r instanceof Ciljana){
			Ispis.tekstIspis(r.getOpis());
		}
	}
	
	public static tekstIspis(String opis){
		synchronized(o){
			System.out.println(opis);
		}
	}
	
	public static animatedIspis(String opis){
		synchronized(o){
			AnimationIspis ai = new AnimationIspis(opis);
			ai.start();
		}
	}
}