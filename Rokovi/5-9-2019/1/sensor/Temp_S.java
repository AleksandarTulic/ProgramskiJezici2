package sensor;

import radnaMasina.*;
import java.util.*;
import help.*;
import java.io.*;
import java.util.logging.*;

public class Temp_S extends Sensor{
	private List<Integer> temp = new ArrayList<Integer>();
	private static final int MAX_ELEMENTS = 10;
	private String path = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "temparature";
	private Log tempLog;
	
	public Temp_S(String name){
		super(name);
	
		path += File.separator + super.name + "Temp.txt";
		tempLog = new Log(path);
	}
	
	public void add(int value){
		if (temp.size() == MAX_ELEMENTS){
			temp.remove(0);
			temp.add(value);
		}else{
			temp.add(value);
		}
		
		logValue();
	}
	
	private void logValue(){
		String a = "";
		
		for (Integer i : temp){
			a += String.valueOf(i) + " ";
		}
		
		tempLog.logger.log(Level.INFO, "Temparature: " + a);
	}
}