package reklama;

import java.util.*;
import ispis.*;
import help.*;
import korisnik.*;

public class CiljanaGrupa{
	private List<String> arr = new ArrayList<String>();
	
	private static final String []flag = new String[4]{
		"JAVA",
		"PROGRAMIRANJE",
		"ETF",
		"BANJA LUKA"
	}; 
	
	public class CiljanaGrupa(){
	}
	
	public add(String value){
		if (flag[0].equals(value) || 
			flag[1].equals(value) || 
			flag[2].equals(value) ||
			flag[3].equals(value) ){
			arr.add(value);
		}
	}
	
	public checkInteresovanje(String value){
		for (String i : arr){
			if (arr.get(i).equals(value))
				return true;
		}
		
		return false;
	}
}