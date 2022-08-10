import java.util.function.Predicate;

import elements.*;
import skladiste.Skladiste;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Comparator<Metod> comparator = new Comparator<Metod>() {
			@Override
			public int compare(Metod s1, Metod s2) {
				return s1.hashCode() - s2.hashCode();
			}
		};
		
		Skladiste<Metod> s1 = new Skladiste<Metod>(comparator);
		
		s1.add(new Obavjestenja());
		s1.add(new Alarmi());
		s1.add(new Alarmi());
		s1.add(new Alarmi());
		
		Predicate <Metod> pre1 = (n) -> {
			return n.get1() % 2 == 0;
		};
		
		Predicate <Metod> pre2 = (n) -> {
			return n.get2()%2==1;
		};
		
		List<Predicate<Metod>> arr = new ArrayList<>();
		arr.add(pre1);
		arr.add(pre2);
	
		s1.printAll();
		s1.search(arr);
	}
}
