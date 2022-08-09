import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.util.Map.*;

public class Main{
	public static void main(String []args){
		HashSet <Knjiga> arr = new HashSet<Knjiga>();
		
		for (int i=0;i<20;i++)
			arr.add(new Knjiga());
		
		arr.stream().forEach(System.out::println);
		
		Map<Zanr, List<Knjiga>> map = arr.stream().collect(Collectors.groupingBy(Knjiga::getZanr));
		
		System.out.println("ZANR FILTRIRANJE");
		for (Entry<Zanr, List<Knjiga>> entry : map.entrySet()){
			System.out.println("Zanr - " + entry.getKey());
			for (Knjiga j : entry.getValue()){
				System.out.println(j);
			}
		}
		
		System.out.println("SORT");
		arr.stream().sorted(Comparator.comparing(Knjiga::getGodina, Comparator.reverseOrder())).forEach(System.out::println);
		
		Function <Knjiga, Boolean> flagSum = (n) -> {
			if (n.godina % 3 == 0 && n.zanr == Zanr.putopis)
				return true;
			
			return false;
		};
		
		int sum = arr.stream().filter(t -> flagSum.apply(t)).mapToInt(t -> t.godina).reduce(0, (a, b) -> a+b);
		System.out.println("SUMA GODINA: " + sum);
		
		Knjiga res = arr.stream().max(Comparator.comparing(Knjiga::getNaslovLength)).get();
		System.out.println(res);
	}
}