import java.io.*;
import java.util.*;

public class Main{
	public static List<Gamer> plays = new ArrayList<Gamer>();
	public static Bag a = new Bag(50);
	
	public static void main(String []args){
		Random rand = new Random();
		
		int numPlayers = rand.nextInt(12) + 5;
		
		for (int i=0;i<numPlayers;i++){
			plays.add(new Gamer());
		}
		
		a.start();
		
		for (int i=0;i<numPlayers;i++){
			plays.get(i).start();
		}
	}
}