import java.sql.Date;
import java.util.*;
import java.util.stream.*;
import java.util.Map.*;

public class Main{
	public static Random rand = new Random();
	
	public static void main(String []args){
		List<Oglas> arr = new ArrayList<Oglas>();
		
		for (int i=0;i<60;i++)
			arr.add(new Oglas());
		
		//a
		
		Map<Integer, List<Oglas>> map1 = arr.stream().collect(Collectors.groupingBy(Oglas::getDay));
		
		for (Entry<Integer, List<Oglas>> entry : map1.entrySet()){
			System.out.println("Dan: " + entry.getKey() + ", Broj: " + entry.getValue().size());
		}
		
		//b
		
		System.out.println("Prosjecna Plata IT: " + (arr.stream().filter(t -> t.kategorija == Kategorija.IT)).mapToDouble(t -> t.plata).average());
		
		//c
		
		arr.stream().collect(Collectors.groupingBy(Oglas::getGrad)).entrySet().stream().forEach(t -> System.out.println(t.getKey() + " " + t.getValue().size()));
		System.out.println(arr.stream().collect(Collectors.groupingBy(Oglas::getGrad)).entrySet().stream().max((a, b) -> a.getValue().size() > b.getValue().size() ? 1 :
		a.getValue().size() == b.getValue().size() ? 0 : -1).get().getKey());
		
		//d
		
		arr.stream().collect(Collectors.groupingBy(Oglas::getMonth)).entrySet().stream().forEach(t -> {
			System.out.println(t.getKey());
			t.getValue().stream().forEach(System.out::println);
			});
			
		//e
		
		arr.stream().sorted(Comparator.comparing(Oglas::getDaniTrajanja, Comparator.reverseOrder())).forEach(System.out::println);
		
		//f
		
		arr.stream().collect(Collectors.groupingBy(Oglas::getKategorija)).entrySet().stream().forEach(
		
			t -> {
				System.out.println("Kategorija: " + t.getKey());
				System.out.println("Najbolja Plata: " + t.getValue().stream().max((a, b) -> a.plata > b.plata ? 1 : 
				a.plata == b.plata ? 0 : -1).get().plata);
			}
		);
		
		//g
		
		System.out.println("Prosjecna godina rada: " + arr.stream().mapToInt(t -> t.godinaRada).average());
		arr.stream().collect(Collectors.groupingBy(Oglas::getKategorija)).entrySet().stream().forEach(
		
			t -> {
				System.out.println("Kategorija: " + t.getKey());
				System.out.println("Godina Rada: " + t.getValue().stream().mapToInt(k -> k.godinaRada).average());
			}
		);
	}
}

class Oglas{
	public String naziv;
	public String opis;
	public Calendar calendar = Calendar.getInstance();
	public int daniTrajanja;
	public double plata;
	public int godinaRada;
	public String grad;
	public Kategorija kategorija;
	
	private static int num = 0;
	
	public Oglas(){
		naziv = "NAZIV_" + num;
		opis = "OPIS_" + num;
		getRandomDate();
		daniTrajanja = num;
		plata = (Main.rand.nextInt(1000) + 1) * 1.0;
		godinaRada = num;
		grad = getRandomGrad();
		kategorija = getRandomKategorija();
		
		num++;
	}
	
	public Kategorija getKategorija(){
		return kategorija;
	}
	
	public String getGrad(){
		return grad;
	}
	
	public int getMonth(){
		return calendar.get(Calendar.MONTH);
	}
	
	public int getDaniTrajanja(){
		return daniTrajanja;
	}
	
	public int getDay(){
		return calendar.get(Calendar.DATE);
	}
	
	public void getRandomDate(){
		calendar.add(Calendar.DATE, -Main.rand.nextInt(10));
		calendar.add(Calendar.MONTH, -Main.rand.nextInt(6));
	}
	
	public static Kategorija getRandomKategorija(){
		int value = Main.rand.nextInt(4);
		
		if (value == 0)
			return Kategorija.IT;
		else if (value == 1)
			return Kategorija.ekonomija;
		else if (value == 2)
			return Kategorija.medicina;
		
		return Kategorija.pravo;
	}
	
	public static String getRandomGrad(){
		int value = Main.rand.nextInt(3);
		
		if (value == 0)
			return "Chicago";
		else if (value == 1)
			return "Tokyo";
		
		return "Budapest";
	}
	
	@Override
	public String toString(){
		return "Naziv: " + naziv + ", Opis: " + opis + ", Datum: " + calendar + ", Dani Trajanja: " + daniTrajanja + ", Plata: " + plata + ", Godina Rada: " + godinaRada + ", Grad: " + grad + ", Kategorija: " + kategorija;
	}
}

enum Kategorija{
	IT,
	ekonomija,
	medicina,
	novinarstvo,
	pravo
}