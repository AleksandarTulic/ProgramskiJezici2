import java.util.*;
import java.time.*;
import java.time.format.*;

public class Main{
	private static List <Klijent> arr = new ArrayList<Klijent>();
	private static List <Klijent> res = new ArrayList<Klijent>();
	
	public static void main(String []args){
		Random rand = new Random();
		
		for (int i=0;i<2000;i++){
			ID id = new ID(i);
			//System.out.println(id);
			int bank = rand.nextInt(10001) + 20000;
			arr.add(new Klijent("Ime - " + i, "Prezime - " + i, id, bank));
		}
		
		Main.mySort();
		
		if (res.size() > 1){
			System.out.println(res.get(res.size()-1));
			System.out.println(res.get(res.size()-2));
		}
	}
	
	private static void mySort(){
		MyGraph []g = new MyGraph[10005];
		
		for (int i=0;i<=10002;i++){
			g[i] = new MyGraph();
		}
		
		for (int i=0;i<arr.size();i++){
			g[arr.get(i).getBanka()-20000].add(arr.get(i));
		}
		
		for (int i=20000;i<=30000;i++){
			for (int j=0;j<g[i-20000].getSize();j++){
				res.add(g[i-20000].get(j));
			}
		}
	}
}


class MyGraph{
	private List<Klijent> arr = new ArrayList<Klijent>();
	
	public MyGraph(){
	}
	
	public void add(Klijent k){
		arr.add(k);
	}
	
	public boolean delete(int index){
		if (index < 0 || index >= arr.size())
			return false;
		
		arr.remove(index);
		
		return true;
	}
	
	public Klijent get(int index){
		if (index < 0 || index >= arr.size())
			return null;
		
		return arr.get(index);
	}
	
	public int getSize(){
		return arr.size();
	}
}

class Klijent{
	private String ime;
	private String prezime;
	private ID id;
	private int bank;
	
	public Klijent(String ime, String prezime, ID id, int bank){
		this.ime = ime;
		this.prezime = prezime;
		this.id = id;
		this.bank = bank;
	}
	
	@Override
	public String toString(){
		return "Ime: " + ime + ", Prezime: " + prezime + ", ID: " + id.toString() + ", Bank: " + bank;
	}
	
	public int getBanka(){
		return bank;
	}
}

class ID{
	private int redniBroj = 0;
	private int godina = 0;
	
	public ID(int redniBroj){
		this.redniBroj = redniBroj;
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY");
		LocalDateTime ldt = LocalDateTime.now();
		
		try{
			godina = Integer.parseInt(dtf.format(ldt).toString());
			//System.out.println(godina);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public int getRedniBroj(){
		return redniBroj;
	}
	
	public int getGodina(){
		return godina;
	}
	
	public void setGodina(int godina){
		this.godina = godina;
	}
	
	public void setRedniBroj(int redniBroj){
		this.redniBroj = redniBroj;
	}
	
	@Override
	public String toString(){
		return redniBroj + "-" + godina;
	}
}