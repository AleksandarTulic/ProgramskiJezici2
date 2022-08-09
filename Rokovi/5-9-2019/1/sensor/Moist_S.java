package sensor;

import radnaMasina.*;
import java.util.*;
import java.io.*;
import java.util.logging.*;
import help.*;

public class Moist_S extends Sensor{
	private int now = 0;
	private static String path = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "moist";
	private Log moistLog;
	
	public Moist_S(String name){
		super(name);
	
		path += File.separator + super.name + "Moist.txt";
		moistLog = new Log(path);
	}
	
	public void setValue(int now){
		this.now = now;
		
		logValue();
	}
	
	private void logValue(){
		moistLog.logger.log(Level.INFO, "Moist Value Now: " + now);
	}
}