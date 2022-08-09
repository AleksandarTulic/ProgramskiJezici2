import java.util.*;

public abstract class Vozilo extends Thread{
	public String id;
	public Vozac vozac;
	public Motor motor;
	public String conf;
	public static Object o = new Object();
	
	
	public Vozilo(){
	}
	
	public Vozilo(String conf){
		this.conf = conf;
	}
	
	public Vozilo(String id, Vozac vozac, Motor motor, String conf){
		this.conf = conf;
		this.motor = motor;
		this.vozac = vozac;
		this.id = id;
	}
	
	@Override
	public void run(){
		System.out.println("Poslo");
		for (int i=0;i<Main.map.length;i++){
			try{
				Vozilo.ispis(id, i);
				
				if (Main.map[i].tip == TipPolja.obicno){
				}else if (Main.map[i].tip == TipPolja.klizavo){
					Random rand = new Random();
					int value = rand.nextInt(100);
					
					if (value <= Main.map[i].gubitak)
						return;
				}else if (Main.map[i].tip == TipPolja.neravno){
					if (this instanceof Autobus){
						motor.snaga += motor.snaga/10;
					}
				}
				
				double value = 100.0 / motor.snaga;
				Thread.sleep((int)(value * 1000));
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void ispis(String id, int pos){
		synchronized(o){
			System.out.println("ID: " + id + ", Position: " + pos);
		}	
	}
}