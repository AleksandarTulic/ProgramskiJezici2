import java.util.*;

public class Knjiga{
	public String naslov = "";
	public String pisac;
	public int godina;
	public Zanr zanr;
	
	public static int num = 0;
	
	public Knjiga(){
		naslov = "NASLOV_" + num;
		pisac = "PISAC_" + num;
		godina = 1999 + num;
		zanr = getRandomZanr();
		num++;
	}
	
	@Override
	public boolean equals(Object o){
		if (o == this)
			return true;
		
		if (!(o instanceof Knjiga))
			return false;
		
		Knjiga knjiga = (Knjiga)o;
		
		return godina==knjiga.godina && naslov.equals(knjiga.naslov);
	}
	
	@Override
	public String toString(){
		return "Naslov: " + naslov + ", Pisac: " + pisac + ", Godina: " + godina + ", Zanr: " + zanr;
	}
	
	public Integer getNaslovLength(){
		return naslov.length();
	}
	
	public Integer getGodina(){
		return godina;
	}
	
	public Zanr getZanr(){
		return zanr;
	}
	
	public static Zanr getRandomZanr(){
		Random rand = new Random();
		int value = rand.nextInt(4);
		
		if (value == 0)
			return Zanr.beletristika;
		else if (value == 1)
			return Zanr.putopis;
		else if (value == 2)
			return Zanr.triler;
		
		return Zanr.poezija;
	}
}