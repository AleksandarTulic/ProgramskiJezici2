package elements;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Alarmi implements Metod{
	public int id;
	public String opis;
	public Date date;
	private static final List<String> arrOpis = Arrays.asList("ne", "coban", "gdje", "kutija", "pegla");
	private static final List<String> arrDate = Arrays.asList("2021-07-07", "1999-01-01", "1987-05-05");
	private static Random rand = new Random();
	private static int NUM = 1;
	
	public Alarmi() {
		id = NUM;
		opis = arrOpis.get(rand.nextInt(arrOpis.size()));
		date = Date.valueOf(arrDate.get(rand.nextInt(arrDate.size())));
		NUM++;
	}
	
	public void metod() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String s = "ALARM\n" + "ID: " + id + "\nOPIS: " + opis;
		
		return s;
	}

	@Override
	public int get1() {
		return id;
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
