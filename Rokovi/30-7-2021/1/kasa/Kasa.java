package kasa;

import java.util.*;

import file.FileOperations;
import kupac.*;
import main.Main;
import prodavnica.*;

public abstract class Kasa extends Thread{
	public List<Kupac> arr = new ArrayList<>();
	public boolean flagType = false;
	public String name = "";
	public static int NUM = 1;
	
	public Kasa() {
		name = "KASA_" + NUM;
		NUM++;
	}
	
	public boolean valid(Kupac kupac) {
		return true;
	}
	
	@Override
	public void run() {
		do {
			try {
				Thread.sleep(1000);
				
				synchronized(Prodavnica.o) {
					if (arr.size() > 0) {
						Kupac kupac = arr.get(0);

						if (!kupac.flagPiceCigare()) {
							FileOperations.writeChild(kupac, this);
						}else if (kupac.getSum() > kupac.cash) {
							FileOperations.writeBuyer(kupac, this);	
						}else {
							kupac.cash -= kupac.getSum();
							
							System.out.println("Uspjesna kupovina: ");
							
							System.out.println(this);
							System.out.println(kupac); //kada ispise cash to je onda umanjen iznos
						}
						
						arr.remove(0);
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}while (!Main.prodavnica.getFinished() || arr.size() > 0);
	}
	
	public void addKupac(Kupac kupac) {
		List <Kupac> arrKupac = new ArrayList<Kupac>();
		int rem = -1;
				
		for (int i=0;i<arr.size();i++) {
			if (arr.get(i).getPrioritet() <= kupac.getPrioritet()) {
				arrKupac.add(arr.get(i));
			}else {
				rem = i;
				arrKupac.add(kupac);
				break;
			}
		}
		
		if (rem == -1) {
			arrKupac.add(kupac);
		}else {
			for (int i=rem;i<arr.size();i++) {
				arrKupac.add(arr.get(i));
			}
		}
		
		arr.clear();
		arr = arrKupac;
	}
	
	@Override
	public String toString() {
		return "Kasa Name: " + name;
	}
}
