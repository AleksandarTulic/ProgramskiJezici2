package drugi;

import java.util.*;
import java.util.stream.*;
import drugi.knjiga.*;
import drugi.myEnums.*;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
	public static void main(String []args) {
		GrupaKnjiga gp1 = new GrupaKnjiga();
		GrupaKnjiga gp2 = new GrupaKnjiga();
		
		//========================================================
		//=== A
		//========================================================
		
		Consumer <Knjiga> con = (n) -> {
			gp1.set.add(n);
		};
		
		gp2.set.stream().forEach(t -> {
			con.accept(t);
		});
		gp2.set.clear();
		
		System.out.println("GRUPA KNJIGA 1");
		System.out.println("Broj knjiga: " + gp1.set.size());
		System.out.println("Razliciti pisci: ");
		gp1.set.stream().map(t -> t.pisac).distinct().forEach(System.out::println);
		
		System.out.println("GRUPA KNJIGA 2");
		System.out.println("Broj knjiga: " + gp2.set.size());
		System.out.println("Razliciti pisci: ");
		gp2.set.stream().map(t -> t.pisac).distinct().forEach(System.out::println);
		
		//========================================================
		//=== B
		//========================================================
		
		Map<Zanr, Set<Knjiga>> flag = gp1.set.stream().collect(Collectors.groupingBy(Knjiga::getZanr, Collectors.toSet()));
		for (Entry <Zanr, Set<Knjiga>> entry: flag.entrySet()) {
			System.out.println("Zanr: " + entry.getKey());
			
			for (Knjiga i : entry.getValue()) {
				System.out.println(i);
			}
		}
		
		//========================================================
		//=== C
		//========================================================
		
		gp1.set.stream().sorted(Comparator.comparing(Knjiga::getGodina, Comparator.reverseOrder())).forEach(System.out::println);
		
		//========================================================
		//=== D
		//========================================================
		
		Function <Knjiga, Boolean> fun = (n) -> {
			return n.zanr == Zanr.putopis && n.godina % 3 == 0;
		};
		
		int result = gp1.set.stream().filter(t -> fun.apply(t)).mapToInt(t -> t.godina).reduce(0, (a, b) -> a + b);
		System.out.println("Suma: " + result);
		
		//========================================================
		//=== E
		//========================================================
		
		Knjiga knjigaMAX = gp1.set.stream().max(Comparator.comparing(Knjiga::naslovLength)).orElse(null);
		System.out.println("MAX: " + knjigaMAX);
		Knjiga knjigaMIN = gp1.set.stream().min(Comparator.comparing(Knjiga::naslovLength)).orElse(null); //ne moze ovde findFirst tj za optional<?>
		System.out.println("MIN: " + knjigaMIN);
	}
}
