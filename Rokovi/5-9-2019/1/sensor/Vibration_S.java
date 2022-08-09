package sensor;

import radnaMasina.*;
import java.util.*;
import java.io.*;
import java.util.logging.*;
import help.*;

public class Vibration_S extends Sensor{
	private int v_pre = 0;
	private int v_now = 0;
	private String path = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "vibration";
	private Log vibrationLog;
	
	public Vibration_S(String name){
		super(name);
		
		path += File.separator + super.name + "Vibration.txt";
		vibrationLog = new Log(path);
	}
	
	public int getV_pre(){
		return v_pre;
	}
	
	public int getV_now(){
		return v_now;
	}
	
	public void setV_pre(int v_pre){
		this.v_pre = v_pre;
	}
	
	public void setV_now(int v_now){
		this.v_now = v_now;
		
		logValue();
	}
	
	private void logValue(){
		vibrationLog.logger.log(Level.INFO, "Vibration Previously: " + v_pre + ", Vibration Now: " + v_now);
	}
}