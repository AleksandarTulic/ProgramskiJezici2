package help;

import ispis.*;
import reklama.*;
import korisnik.*;

public class SimulTime extends Thread{
	private static final simulTime = 120;
	public boolean flagSimul = true;
	
	@Override
	public void run(){
		try{
			Thread.sleep(simulTime * 1000);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		flagSimul = false;
	}
	
	public boolean getFlagSimul(){
		return flagSimul;
	}
}