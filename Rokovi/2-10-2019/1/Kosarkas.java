import java.io.*;
import java.util.*;

public abstract class Kosarkas{
	private double chance = 0.0;
	private int id;
	private static int numberOfPlayers = 1;
	
	public Kosarkas(double l, double r){
		this.id = numberOfPlayers++;
		
		Random rand = new Random();
		int ll = (int)(l * 100);
		int rr = (int)(r * 100);
		
		int res = rand.nextInt(rr - ll + 1) + ll;
		double ress = res / 100.0;
		chance = ress;
	}
	
	public double getChance(){
		return chance;
	}
	
	public int getId(){
		return id;
	}
}