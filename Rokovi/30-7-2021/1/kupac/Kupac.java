package kupac;

import java.util.*;
import artikal.*;
import main.*;
import prodavnica.Prodavnica;

public abstract class Kupac extends Thread{
	public double cash = 0.0;
	
	//false za kolica, true za korpe
	public boolean flag = false;
	public boolean flagType = false; //pravno default = false
	public List<Artikal> arr = new ArrayList<Artikal>();
	public boolean finished = false;
	
	public Kupac(int l, int r, boolean flagType){
		this.cash = (Main.rand.nextInt(r - l + 1) + l) * 1.0;
		//receno je u jednakoj mjeri 50% : 50%
		if (Main.rand.nextInt(2) == 0)
			this.flag = true;
		this.flagType = flagType;
	}
	
	public int getPrioritet() {
		return 5;
	}
	
	public boolean getType() {
		return flagType;
	}
	
	public boolean flagPiceCigare() {
		return true; //true - smije
	}
	
	public double getSum() {
		double res = 0.0;
		for (Artikal i : arr) {
			res+=i.tip.getValue();
		}
		
		return res;
	}
	
	@Override
	public void run() {
		for (int i=0;i<20;i++)
			arr.add(Main.prodavnica.get());
	
		Main.prodavnica.addToKasa(this);
		
		synchronized(Prodavnica.oFinished) {
			finished = true;
		}
	}
	
	@Override
	public String toString() {
		String res = "Cash: " + cash + "\n";
		res += "Artikli koje kupuje: \n";
		for (Artikal i : arr) 
			res += "Artikal: " + i.tip + ", Cijena: " + i.tip.getValue() + "\n";
		res += "Ukupno: " + getSum();
		
		return res;
	}
}
