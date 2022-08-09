package ispis;

import help.*;
import reklama.*;
import korisnik.*;

public class AnimationIspis{
	private static final int minRandWord = 1;
	private static final int maxRandWord = 5;
	private String []opis = null;
	
	public AnimationIspis(String opis){
		this.opis = opis.split(" ");
	}
	
	@Override
	public void run(){
		Random rand = new Random();
		for (int i=0;i<opis.length;i++){
			try{
				System.out.println(opis[i] + " ");
				int n = opis[i].length() * (rand.nextInt(maxRandWord - minRandWord + 1) + minRandWord) * 1000;
				Thread.sleep(n);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		System.out.println();
	}
}