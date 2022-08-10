package drugi.help;

import drugi.myEnums.Zanr;
import java.util.*;

public class Help {
	private static Random rand = new Random();
	
	public static Zanr getRandomZanr() {
		int value = rand.nextInt(4);
		
		switch(value) {
			case 0:
				return Zanr.beletristika;
			case 1: 
				return Zanr.poezija;
			case 2: 
				return Zanr.putopis;
			case 3:
				return Zanr.triler;
		}
		
		return Zanr.beletristika;
	}
}
