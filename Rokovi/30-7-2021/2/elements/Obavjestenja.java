package elements;

import java.util.*;

public class Obavjestenja implements Metod {
	public String naslov;
	public String opis;
	private static final List<String> arrNaslov = Arrays.asList("Naslov 1", "gdje", "opet", "a", "alo", "vi");
	private static final List<String> arrOpis = Arrays.asList("ne", "moram", "gdje", "kutija", "pegla");
	private static Random rand = new Random();
	
	public Obavjestenja() {
		naslov = arrNaslov.get(rand.nextInt(arrNaslov.size()));
		opis = arrOpis.get(rand.nextInt(arrOpis.size()));
	}
	
	public void metod() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String s = "Obavjestenje" + "\nNaslov: " + naslov;
		
		return s;
	}

	@Override
	public int get1() {
		return naslov.length();
	}

	@Override
	public int get2() {
		return opis.length();
	}
	
	@Override
	public int compare() {
		return this.hashCode();
	}
}
