import java.util.*;

public class Vozilo extends Thread{
	public static Object o = new Object();
	
	//koristimo x i y, dok z je konstantno kada se inicijlizuje
	protected int x;
	protected int y;
	protected int z;
	private String model;
	private List<Osoba> arr;
	private int zadrzavanje = 1000;
	
	private static final int ZADRZAVANJE_MAX = 2000;
	private static final int ZADRZAVANJE_MIN = 1000;
	
	private int xChange;
	private int yChange;
	private boolean stop = false;
	
	public Vozilo(String model, int MAX_NUM, int MIN_NUM, TipOsobe tip, int xChange, int yChange){
		this.model = model;
		this.arr = Help.getRandomPeople(tip, MIN_NUM, MAX_NUM);
		this.xChange = xChange;
		this.yChange = yChange;
		
		Random rand = new Random();
		this.zadrzavanje = rand.nextInt(ZADRZAVANJE_MAX - ZADRZAVANJE_MIN + 1) + ZADRZAVANJE_MIN;
	}
	
	@Override
	public void run(){
		System.out.println(x + " " + y + " " + z + " " + model);
		while(x + xChange >= 0 && x + xChange < Main.MAX_X && y + yChange >= 0 && y + yChange < Main.MAX_Y && !stop){
			//System.out.println(x + " " + y + " " + z);
			try{
				Thread.sleep(zadrzavanje);
			}catch (Exception e){
				e.printStackTrace();
			}
			
			synchronized(Vozilo.o){
				if (!stop){
					Main.map[x][y][z] = null;
					
					if (Main.map[x + xChange][y + yChange][getOther()] != null){
						System.out.println("A");
						Vozilo vozilo = (Vozilo)Main.map[x + xChange][y + yChange][getOther()];
						
						System.out.println("===========================================");
						System.out.println();
						System.out.println("Sudar: [" + (x + xChange) + ", " + (y + yChange) + "]");
						System.out.println(this);
						System.out.println(vozilo);
						System.out.println();
						System.out.println("===========================================");
						
						vozilo.setStop(true);
						break;
					}else{
						System.out.println("B");
						x = x + xChange;
						y = y + yChange;
						
						Main.map[x][y][z] = this;
					}
				}else{
					System.out.println("C");
					break;
				}
			}
		}
		
		Main.map[x][y][z] = null;
	}
	
	private int getOther(){
		return z == 1 ? 0 : 1;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public void setZ(int z){
		this.z = z;
	}
	
	public int getZ(){
		return z;
	}

	@Override
	public String toString(){
		return "Model: " + model + ", Stradalo Osoba: " + arr.size();
	}

	public void setStop(boolean stop){
		this.stop = stop;
		Main.map[x][y][z] = null;
	}

	public String getModel(){
		return model;
	}
}