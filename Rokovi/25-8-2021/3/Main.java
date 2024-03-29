import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Main{
	public static void main(String []args){
		List<Podatak> arr1 = new ArrayList<Podatak>();
		for (int i=0;i<5;i++)
			arr1.add(new Student());
		
		List<Podatak> arr2 = new ArrayList<Podatak>();
		for (int i=0;i<5;i++)
			arr1.add(new Student());
		
		List<Podatak> arr3 = new ArrayList<Podatak>();
		for (int i=0;i<5;i++)
			arr1.add(new Student());
		
		List<Predicate<Podatak>> arrPre = new ArrayList<Predicate<Podatak>>();
		
		Predicate <Podatak> p1 = (n) -> {
			return n.getIndeks() % 2 == 0 ? true : false;
		};
		
		Predicate <Podatak> p2 = (n) -> {
			return n.getIme().length() >= 6;
		};
		
		arrPre.add(p1);
		arrPre.add(p2);
		
		Main.<Podatak>test(arrPre, 0, 0, arr1, arr2);
	}
	
	@SafeVarargs
	public static <T> void test(List<Predicate<T>> arrPre, int a, int b, List<T> ... arr){
		//arr[0].stream().forEach(System.out::println);
		List<T> ar = Arrays.stream(arr).flatMap(List::stream).collect(Collectors.toList());
		ar.stream().filter(arrPre.stream().reduce(t->true, Predicate::and)).sorted(Comparator.comparing(T::hashCode, Comparator.reverseOrder())).forEach(System.out::println);
		
		//ar.stream().filter(t -> arrPre.get(0).test(t)).forEach(System.out::println);
		//Stream.of(arr[0], arr[1], arr[2]).collect(Collectors.toList());
	}
}

interface Podatak{
	String getIme();
	int getIndeks();
	int hashCode();
}

class Student implements Podatak{
	public String ime;
	public String prezime;
	public int indeks;
	
	public static int num = 0;
	
	public Student(){
		ime = "IME_" + num;
		prezime = "PREZIME_" + num;
		indeks = num++;
	}
	
	@Override
	public int hashCode(){
		int hash = 17;
		hash = 31 * hash + ime.hashCode();
		hash = 31 * hash + prezime.hashCode();
		hash = 31 * hash + indeks;
		
		//System.out.println(this);
		//System.out.println(hash);
		return hash;
	}
	
	public int getIndeks(){
		return indeks;
	}
	
	public String getIme(){
		return ime;
	}
	
	@Override
	public String toString(){
		return "Ime: " + ime + ", prezime; " + prezime + ", indeks: " + indeks;
	}
}