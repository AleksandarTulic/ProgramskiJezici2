import java.util.*;

public class Main{
	public static void main(String []args){
		List<Liga> arrLiga = new ArrayList<Liga>();
		
		for (int i=0;i<8;i++){
			arrLiga.add(new Liga("Liga_" + i));
		}
		
		for (Liga i : arrLiga){
			i.start();
		}
		
		try{
			for (Liga i : arrLiga){
				i.join();
				
				i.ispisRangLige();
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		
		List<Tim> arrTim = new ArrayList<Tim>();
		
		for (int i=0;i<8;i++){
			arrTim.add(arrLiga.get(i).teamWon());
		}
		
		Liga liga = new Liga(arrTim);
		liga.start();
		
		try{
			liga.join();
			System.out.println("");
			System.out.println("SPECIAL LEAGUE");
			System.out.println("");
			liga.ispisRangLige();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}