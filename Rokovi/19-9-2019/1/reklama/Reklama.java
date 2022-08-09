package reklama;

import ispis.*;
import help.*;
import korisnik.*;

public abstract class Reklama extends Thread{
	protected String naslov;
	protected String opis;
	protected int vrijeme;
	private int x;
	private int y;
	
	private static final int minVrijeme = 15;
	private static final int maxVrijeme = 20;
	
	public Reklama(String naslov, String opis){
		this.naslov = naslov;
		this.vrijeme = vrijeme;
		
		Random rand = new Random();
		vrijeme = rand.nextInt(maxVrijeme - minVrijeme + 1) + minVrijeme;
	}
	
	public setXY(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public void run(){
		try{
			Thread.sleep(vrijeme);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		synchronized(Init.map[x][y]){
			Init.map[x][y] = null;
		}
	}
	
	public String getOpis(){
		return opis;
	}
}