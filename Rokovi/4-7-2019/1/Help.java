import java.util.*;

public class Help{
	private static Random rand = new Random();
	
	public static List<Osoba> getRandomPeople(TipOsobe tip, int l, int r){
		int broj = rand.nextInt(r - l + 1) + l;
		
		List<Osoba> arr = new ArrayList<Osoba>();
		for (int i=0;i<broj;i++)
			arr.add(new Osoba(tip));
		
		return arr;
	}
}