package radnaMasina;

import java.util.*;
import sensor.*;
import help.*;

public class RadnaMasina extends Thread{
	private static final int seconds = 1000;
	
	private int serial;
	private String model;
	private Status status;
	private int temp = 0;
	private int pres = 0;
	private int moist = 0;
	private int vibration = 0;
	
	private static final int v_left = 10; //vibration
	private static final int v_right = 20;
	
	private static final int t_left = 5; //temparature
	private static final int t_right = 35;
	
	private static final int p_left = 17; //pressure
	private static final int p_right = 21;
	
	private static final int m_left = 10; //moist
	private static final int m_right = 100;
	
	
	private List<Sensor> arr = new ArrayList<Sensor>();
	
	public RadnaMasina(int serial, String model, Status status, List<Sensor> arr){
		this.status = status;
		this.serial = serial;
		this.model = model;
		this.arr = arr;
	}
	
	
	public void setOn(){
		this.start();
		
		status = Status.on;
		
		for (int i=0;i<arr.size();i++)
			arr.get(i).start();
	}
	
	public void setOff(){
		status = Status.off;
	}
	
	@Override
	public void run(){
		do{
			if ( status == Status.off ){
				break;
			}
			
			generateRandom();
			
			try{
				Thread.sleep(seconds);
			}catch (Exception e){
				e.printStackTrace();
			}
			
			Init.print("Masina sa ID = " + serial + " radi.");
		}while (true);
		
		Init.print("Radna masina sa id-om: " + serial + " je zavrsila sa radom.");
	}
	
	public int getPres(){
		return pres;
	}
	
	public int getTemp(){
		return temp;
	}
	
	public int getMoist(){
		return moist;
	}
	
	public int getVibration(){
		return vibration;
	}
	
	private void generateRandom(){
		Random rand = new Random();
		
		vibration = rand.nextInt(v_right - v_left + 1) + v_left;
		pres = rand.nextInt(p_right - p_left + 1) + p_left;
		temp = rand.nextInt(t_right - t_left + 1) + t_left;
		moist = rand.nextInt(m_right - m_left + 1) + m_left;
	}
	
	public Status getStatus(){
		return status;
	}
}