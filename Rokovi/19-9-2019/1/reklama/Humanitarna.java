package reklama;

import java.util.*;
import ispis.*;
import help.*;
import korisnik.*;

public class Humanitarna extends Reklama{
	private double cash = 0.0;
	private static final int minCash = 20;
	private static final int maxCash = 100;
	
	public Humanitarna(String naslov, String opis){
		super(naslov, opis);
	
		Random rand = new Random();
		int val = rand.nextInt(maxCash - minCash + 1) + minCash;
		cash = (double)(System.currentTimeMillis() / 10000) + (val * naslov.length());
	}
	
	public double getCash(){
		return cash;
	}
}