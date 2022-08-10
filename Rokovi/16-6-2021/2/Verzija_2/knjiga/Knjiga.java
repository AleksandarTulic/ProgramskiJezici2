package drugi.knjiga;

import drugi.help.Help;
import drugi.myEnums.Zanr;
import java.util.*;

public class Knjiga {
	public String naslov;
	public String pisac;
	public int godina;
	public Zanr zanr;
	
	private static int NUM = 1;
	private static Random rand = new Random();
	
	public Knjiga() {
		naslov = "NASLOV_" + NUM;
		pisac = "PISAC_" + NUM;
		godina = rand.nextInt(2010 - 1990 + 1) + 1990;
		zanr = Help.getRandomZanr();
		NUM++;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		
		if (!(o instanceof Knjiga))
			return false;
		
		Knjiga knjiga = (Knjiga)o;
		
		return knjiga.godina == this.godina && knjiga.naslov.equals(this.naslov);
	}
	
	public Zanr getZanr() {
		return zanr;
	}
	
	public int getGodina() {
		return godina;
	}
	
	public int naslovLength() {
		return naslov.length();
	}

	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", pisac=" + pisac + ", godina=" + godina + ", zanr=" + zanr + "]";
	}
	
}
