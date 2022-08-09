package sensor;

import radnaMasina.*;
import java.util.*;
import java.io.*;
import java.util.logging.*;
import help.*;

public class Press_S extends Sensor{
	private List<Integer> press = new ArrayList<Integer>();
	private double mean = 0.0;
	private static final int MAX_ELEMENTS = 5;
	private String path = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "pressure";
	private Log pressLog;
	
	public Press_S(String name){
		super(name);
		
		path += File.separator + super.name + "Press.txt";
		pressLog = new Log(path);
	}
	
	public double getMean(){
		return mean;
	}
	
	public void add(int value){
		if (press.size() == MAX_ELEMENTS){
			press.remove(0);
			press.add(value);
		}else{
			press.add(value);
		}
		
		int sum = 0;
		for (Integer i : press){
			sum+=i;
		}
		
		double suma = sum * 1.0;
		mean = (double)(suma / press.size());
		
		logValue();
	}
	
	private void logValue(){
		String a = "";
		
		for (Integer i : press){
			a += String.valueOf(i) + " ";
		}
		
		pressLog.logger.log(Level.INFO, "Pressure: " + a + ", MEAN: " + mean);
	}
}