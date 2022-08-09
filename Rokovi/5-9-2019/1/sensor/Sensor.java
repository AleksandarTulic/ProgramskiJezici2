package sensor;

import radnaMasina.*;
import java.util.*;
import help.*;

public abstract class Sensor extends Thread{
	private static final int seconds = 500;
	protected String name;
	
	public Sensor(String name){
		this.name = name;
	}
	
	@Override
	public void run(){
		do{
			try{
				Thread.sleep(seconds);
			}catch (Exception e){
				e.printStackTrace();
			}
			
			RadnaMasina rm = Init.map.get(this);
			
			if ( rm.getStatus() == Status.off ){
				break;
			}
			
			if ( this instanceof Temp_S ){
				Temp_S t = (Temp_S)this;
				
				t.add(rm.getTemp());
			}else if (this instanceof Moist_S){
				Moist_S m = (Moist_S)this;
				
				m.setValue(rm.getMoist());
			}else if (this instanceof Press_S){
				Press_S p = (Press_S)this;
				
				p.add(rm.getPres());
			}else if (this instanceof Vibration_S){
				Vibration_S v = (Vibration_S)this;
				
				v.setV_pre(v.getV_now());
				v.setV_now(rm.getVibration());
			}
		}while (true);
		
		Init.print("Sensor '" + name + "' je prestao sa radom");
	}
}