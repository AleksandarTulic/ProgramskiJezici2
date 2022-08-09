import java.util.*;

public class Utakmica extends Thread{
	private Tim timA;
	private Tim timB;
	public static Object o = new Object();
	
	public Utakmica(Tim timA, Tim timB){
		this.timA = timA;
		this.timB = timB;
	}
	
	@Override
	public void run(){
		timA.setPoints(0);
		timB.setPoints(0);
		List<Kosarkas> arr1 = timA.getKosarkasi();
		List<Kosarkas> arr2 = timB.getKosarkasi();
		
		for (int i=0;i<arr1.size();i++){
			if (i == arr1.size() - 1){
				Kosarkas kosarkas = arr1.get(i);
				
				Random rand = new Random();
				int value = rand.nextInt(101); //jer vraca od 0 - 100 (ukljucujuci i ivice)
				double res = value / 100.0;
				
				
				if (kosarkas.getChance() <= res){
					timA.setPoints(timA.getPoints() + 1);
				}
				
				ispis(kosarkas, timA, timB);
				
				kosarkas = arr2.get(i);
				
				value = rand.nextInt(101); //jer vraca od 0 - 100 (ukljucujuci i ivice)
				res = value / 100.0;
				
				
				if (kosarkas.getChance() <= res){
					timB.setPoints(timB.getPoints() + 1);
				}
				
				ispis(kosarkas, timA, timB);
			}else{
				Kosarkas kosarkas = arr1.get(i + 1);
				
				if (kosarkas instanceof Asistiranje){
					timA.setPoints(timA.getPoints() + 2);
				}else if (kosarkas instanceof Skakanje){
					timA.setPoints(timA.getPoints() + 1);
				}else{
					kosarkas = arr1.get(i);
					
					Random rand = new Random();
					int value = rand.nextInt(101); //jer vraca od 0 - 100 (ukljucujuci i ivice)
					double res = value / 100.0;
					
					
					if (kosarkas.getChance() <= res){
						timA.setPoints(timA.getPoints() + 1);
					}
				}
				
				ispis(kosarkas, timA, timB);
				
				kosarkas = arr2.get(i + 1);
				
				if (kosarkas instanceof Asistiranje){
					timB.setPoints(timB.getPoints() + 2);
				}else if (kosarkas instanceof Skakanje){
					timB.setPoints(timB.getPoints() + 1);
				}else{
					kosarkas = arr2.get(i);
					
					Random rand = new Random();
					int value = rand.nextInt(101); //jer vraca od 0 - 100 (ukljucujuci i ivice)
					double res = value / 100.0;
					
					
					if (kosarkas.getChance() <= res){
						timB.setPoints(timB.getPoints() + 1);
					}
				}
				
				ispis(kosarkas, timA, timB);
			}
		}
		
		timA.setAllPoints(timA.getAllPoints() + timA.getPoints());
		timB.setAllPoints(timB.getAllPoints() + timB.getPoints());
	}
	
	public static void ispis(Kosarkas kosarkas, Tim timA, Tim timB){
		synchronized(Utakmica.o){
			System.out.println("=====================================================");
			System.out.println(timA.getName() + " - " + timB.getName());
			System.out.println(timA.getName() + " Points: " + timA.getPoints());
			System.out.println(timB.getName() + " Points: " + timB.getPoints());
			
			if (kosarkas instanceof Visoko){
				System.out.println("Kosarkas Tip: Visoko, Krilo; Kosarkas ID: " + kosarkas.getId());
			}else if (kosarkas instanceof Nisko){
				System.out.println("Kosarkas Tip: Nisko, Krilo; Kosarkas ID: " + kosarkas.getId());
			}else if (kosarkas instanceof Centar){
				System.out.println("Kosarkas Tip: Centar; Kosarkas ID: " + kosarkas.getId());
			}else if (kosarkas instanceof Suter){
				System.out.println("Kosarkas Tip: Suter, Bek; Kosarkas ID: " + kosarkas.getId());
			}else{
				System.out.println("Kosarkas Tip: Plej, Bek; Kosarkas ID: " + kosarkas.getId());
			}

			System.out.println("=====================================================");
		}
	}
	
	@Override
	public String toString(){
		return timA.getName() + " - " + timB.getName();
	}
	
	public String won(){
		if (timA.getPoints() > timB.getPoints())
			return timA.getName();
		else if (timA.getPoints() < timB.getPoints())
			return timB.getName();
		else
			return "Nerjeseno";
	}
	
	public Tim getTimA(){
		return timA;
	}
	
	public Tim getTimB(){
		return timB;
	}
}