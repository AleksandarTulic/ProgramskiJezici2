package reklama;

import ispis.*;
import help.*;
import korisnik.*;

public class Ciljana extends Reklama{
	private CiljanaGrupa cg = null;
	
	public Ciljana(String naslov, String opis, String []values){
		super(naslov, opis);
		
		cg = new CiljanaGrupa();
	
		for (String i : values){
			cg.add(i);
		}
	}
	
	public checkInteresovanje(String value){
		return cg.checkInteresovanje(value);
	}
}