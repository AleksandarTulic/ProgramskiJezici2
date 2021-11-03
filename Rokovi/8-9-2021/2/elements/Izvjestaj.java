package elements;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class Izvjestaj {
	public static List<Student> arr = new ArrayList<Student>();
	
	public static void priprema() {
		Map<Integer, Long> res1 = arr.stream().collect(
				Collectors.groupingBy(Student::getGodinaStu, Collectors.counting())
		);
		
		System.out.println("PRVI DIO ============================================");
		for (Map.Entry<Integer, Long> i : res1.entrySet()) {
			System.out.println("Godina studija: " + i.getKey() + ", Broj Studenata: " + i.getValue());
		}
		
		Map <String, Long> res2 = arr.stream().collect(
				Collectors.groupingBy(Student::getPrezime, Collectors.counting())
		);
		
		System.out.println("DRUGI DIO ===========================================");
		res2.entrySet().stream().sorted(Map.Entry.comparingByValue()).skip(res2.size()-3).forEach(t -> System.out.println(t));
		
		System.out.println("TRECI DIO ===========================================");
		arr.stream().reduce( (e1, e2) -> (
					arr.stream().map(Student::getIme).filter(s -> s.equals(e1)).count() > arr.stream().map(Student::getIme).filter(s -> s.equals(e2)).count() 
					? e1 : e2
				)
		).ifPresent(System.out::println);
		
		System.out.println("CETVRTI DIO =========================================");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		try {
			final int yearNow = Integer.parseInt(dtf.format(now));
			Map <String, List<Student> > res4 = arr.stream().collect(Collectors.groupingBy(t -> 
			(yearNow - t.getGodinaRod() >= 18 && yearNow - t.getGodinaRod() <= 23 ) ? "18-23" : 
				((yearNow - t.getGodinaRod() >= 24 && yearNow - t.getGodinaRod() <= 29) ? "24-29" : "30-35")));
			System.out.println(res4);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("PETI DIO ============================================");
		Map <String, List<Student> > res5 = arr.stream().collect(
				Collectors.groupingBy(Student::getPrezime)
		);
		
		System.out.println(res5);
		
		System.out.println("SESTI DIO ============================================");
		Map <Integer, List<Student> > res6 = arr.stream().collect(
				Collectors.groupingBy(Student::getGodinaStu)
		);
		
		for (Map.Entry<Integer, List<Student> > i : res6.entrySet()) {
			System.out.println();
			System.out.println("Godina Studija: " + i.getKey());
			i.getValue().stream().max(Comparator.comparing(Student::getOcjena)).ifPresent(System.out::println);
			System.out.println();
		}
		
		System.out.println("SEDMI DIO ============================================");
		//ne kontam kako da koristim reduce
		/*
		 *jedan od nacina jeste da rvo nadjemo koliko ima razlicitih vrijednosti pa onda da idemo u for petlji toliko pute
		 *u toj pet;ji da svaki put vrsimo reduce gdje je ispunjen uslov da taj element nije vec uzet npr hashmap
		 *kada se pronadje mi njega postavljamo na neku vrijednost
		 *ali ovo se moze mnogo bolje rijesiti ako ne koristimo reduce
		 * */
		
		System.out.println("OSMI DIO ============================================");
		arr.stream().sorted(
				(e1, e2) -> e1.getPrezime().compareTo(e2.getPrezime()) > 0 ? -1 : 1
		).collect(Collectors.toList()).stream().forEach(t -> System.out.println(t));;
	}
	
	public static void generateStudents() {
		Random rand = new Random();
		for (int i=0;i<80;i++) {
			char a = (char)(rand.nextInt(26) + (int)'a');
			char b = (char)(rand.nextInt(26) + (int)'A');
			
			double vr1 = rand.nextInt(41) + 60;
			double ocjena = vr1/10;
			int godinaStu = rand.nextInt(6) + 1;
			int trenutna = 0;
			int tr1 = 0;
			int tr2 = 0;
			
			try {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");  
				LocalDateTime now = LocalDateTime.now();  
				trenutna = Integer.parseInt(dtf.format(now));
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			tr1 = trenutna-35;
			tr2 =  trenutna - 18;
			
			arr.add(new Student(a+"ime", b+"prezime", new Indeks(rand.nextInt(1400), rand.nextInt(20)), rand.nextInt(tr2 - tr1 + 1)+tr1, godinaStu, ocjena));
		}
		
		arr.stream().forEach(t -> System.out.println(t));
	}
}
