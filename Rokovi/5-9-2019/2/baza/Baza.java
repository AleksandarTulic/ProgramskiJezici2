package baza;

import artikal.*;
import java.util.*;
import registar.*;

public class Baza<T extends Artikal>{
	private Registrator<T> reg = new Registrator<T>();
	
	public Baza(){
	}
	
	public Baza(Registrator <T> reg){
		this.reg = reg;
	}
	
	public List<T> pretrazi(String upit){
		List<T> res = new ArrayList<T>();
		
		Iterator iter = reg.iterator();
		
		while (iter.hasNext()){
			T buffer = iter.next();
			if ( buffer.flagContains(upit) ){
				res.add(buffer);
			}
		}
		
		return res;
	}
}