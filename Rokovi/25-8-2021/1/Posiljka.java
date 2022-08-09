import java.util.*;
import java.io.*;

public class Posiljka implements Serializable{
	public String aPrimaoca;
	public String aPosiljaoca;
	public double tezina;
	
	private static Random rand = new Random();
	public Posiljka(String aPrimaoca, String aPosiljaoca, int l, int r){
		this.aPrimaoca = aPrimaoca;
		this.aPosiljaoca = aPosiljaoca;

		tezina = (rand.nextInt(r - l + 1) + l) * 1.0;
	}

	@Override
	public String toString(){
		return "Adresa Primaoca: " + aPrimaoca + ", Adresa Posiljaoca: " + aPosiljaoca + ", Tezina: " + tezina;
	}
	
	public static TipFajla getRandomTipFajla(){
		int value = rand.nextInt(3);
		
		if (value == 0)
			return TipFajla.jpg;
		else if (value == 1)
			return TipFajla.png;
		
		return TipFajla.jpeg;
	}
	
	public static Valuta getRandomValuta(){
		int value = rand.nextInt(3);
		
		if (value == 0)
			return Valuta.km;
		else if (value == 1)
			return Valuta.evro;
		
		return Valuta.dolar;
	}
}