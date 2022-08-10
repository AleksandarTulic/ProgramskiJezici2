package skladiste;

import java.util.*;
import java.util.function.Predicate;

import elements.Metod;

public class Skladiste <T extends Metod>{
	private PriorityQueue<T> arr = new PriorityQueue<T>();

	public Skladiste(Comparator <T> comparator) {
		arr = new PriorityQueue<T>(comparator);
	}
	
	public void add(T t) {
		arr.add(t);
	}
	
	public T front() {
		return arr.peek();
	}
	
	public void printAll() {
		System.out.println("ISPIS SVIH ELEMENATA: ");
		for (T i : arr) {
			System.out.println(i);
		}
	}
	
	public void search(List<Predicate <T> > arrPre) {
		System.out.println("ISPIS SVIH ELEMENATA SA USLOVOM: ");
		arr.stream().filter(arrPre.stream().reduce(t->true, Predicate::and)).forEach(System.out::println);
	}
}
