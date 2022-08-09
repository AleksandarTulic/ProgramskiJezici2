package prodavnica;

import java.util.*;
import java.util.stream.Collectors;

import artikal.*;
import kasa.*;
import kupac.*;
import main.*;

public class Prodavnica extends Thread{
	public List<Artikal> arrArtikal = new ArrayList<Artikal>();
	public List<Kasa> arrKasa = new ArrayList<Kasa>();
	public List<Kupac> arrKupaca = new ArrayList<Kupac>();
	public static Object o = new Object();
	public static Object oFinished = new Object();
	
	public Prodavnica(){
		addArtikal(TipArtikla.hljeb);
		addArtikal(TipArtikla.mlijeko);
		addArtikal(TipArtikla.cigarete);
		addArtikal(TipArtikla.pivo);
		addArtikal(TipArtikla.sok);
		addArtikal(TipArtikla.slatkis);
		
		addKase();
		
		int br = 0;
		do{
			int x = Main.rand.nextInt(6);
			
			if (!arrKasa.get(x).flagType){
				arrKasa.get(x).flagType = true;
				br++;
			}
		}while( br < 4);
		
		for (int i=0;i<10;i++) {
			arrKupaca.add(new Pravni(50, 100));
		}
		
		for (int i=0;i<10;i++) {
			arrKupaca.add(new OdrasliBezPrioriteta(20, 50));
		}
		
		for (int i=0;i<10;i++) {
			arrKupaca.add(new OdrasliSaPrioritetom(20, 50));
		}
		
		for (int i=0;i<10;i++) {
			arrKupaca.add(new Djeca(20, 50));
		}
	}

	private void addArtikal(TipArtikla tip){
		for (int i=0;i<200;i++){
			arrArtikal.add(new Artikal(tip));
		}
	}
	
	private void addKase() {
		arrKasa.add(new KasaZaKolica());
		arrKasa.add(new KasaZaKolica());
		arrKasa.add(new KasaZaKorpe());
		arrKasa.add(new KasaZaKorpe());
		arrKasa.add(new KasaZaObadvoje());
		arrKasa.add(new KasaZaObadvoje());
	}
	
	public synchronized Artikal get() {
		int index = Main.rand.nextInt(arrArtikal.size());
		
		Artikal artikal = arrArtikal.get(index);
		arrArtikal.remove(index);
		
		return artikal;
	}
	
	public void addToKasa(Kupac kupac) {
		synchronized(Prodavnica.o) {
			List <Kasa> arr = arrKasa.stream().filter(t -> t.valid(kupac)).collect(Collectors.toList());
			
			Collections.sort(arr, (a, b) -> {
				if (a.arr.size() == b.arr.size())
					return 0;
				else if (a.arr.size() > b.arr.size())
					return 1;
				
				return -1;
			});
			
			arr.get(0).addKupac(kupac);
		}
	}
	
	public boolean getFinished() {
		for (Kupac i : arrKupaca) {
			if (i.finished) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void run() {
		for (Kasa i : arrKasa) {
			i.start();
		}
		for (Kupac i : arrKupaca) {
			i.start();
		}
		
		try {
			for (Kupac i : arrKupaca) {
				i.join();
			}
			
			for (Kasa i : arrKasa) {
				i.join();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
