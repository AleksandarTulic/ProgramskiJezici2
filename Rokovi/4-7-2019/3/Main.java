import java.util.function.Predicate;
import java.util.*;

public class Main{
	public static <T> T check(List <T> arr, List <Predicate<T> > test, int l, int r) throws Exception{
		T res = null;
		int hash = -1;
		
		for (int i=l-1;i<=r-1;i++){
			int flag = 0;
			for (Predicate j : test){
				if ( j.test(arr.get(i)) ){
					flag++;
				}
			}
			
			//System.out.println("ISPIS: " + arr.get(i));
			if ( flag == test.size() ){
				int h = arr.get(i).hashCode();
				//System.out.println(h + " " + hash);
				if ( hash < h ){
					hash = h;
					res = arr.get(i);
				}
			}
		}
		
		return res;
	}
	
	public static void main(String []args){
		//generisanje liste
		List<Osoba> arr = new ArrayList<Osoba>();
		List<Predicate<Osoba> > test = new ArrayList<Predicate<Osoba> >();
		
		for (int i=0;i<100;i++){
			arr.add(new Osoba("ASD" + i, "DSA" + i, 1940 + i));
		}
		
		//uslovi koji se moraju ispuniti
		test.add(i -> (i.getGod() % 4 == 0));
		test.add(i -> (i.getGod() > 1950));
		test.add(i -> (i.getIme().startsWith("ASD1")));
		
		try{
			//ukoliko je null onda nema nijednog clana arr koji zadovoljava sve uslove
			System.out.println(check(arr, test, 12, 94));
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
