import java.util.*;

public class Liga extends Thread{
	private String name;
	private List<Tim> arr = new ArrayList<Tim>();
	private int kolo = 1;
	private static Object o = new Object();
	
	public Liga(String name){
		this.name = name;
		
		for (int i=0;i<16;i++)
			arr.add(new Tim());
	}
	
	public Liga(List<Tim> arrTeam){
		this.arr = arrTeam;
	}
	
	@Override
	public void run(){
		for (int i=0;i<arr.size()-1;i++){
			List<Integer> arrPairs = new ArrayList<Integer>();
			List<Utakmica> arrUtakmica = new ArrayList<Utakmica>();
			HashMap<Integer, Boolean> flag = new HashMap<Integer, Boolean>();
			
			arrPairs.add(i);
			arrPairs.add(i + kolo);
			
			for (int j=0;j<arr.size();j++){
				flag.put(j, false);
			}
			
			int slobodno = 0;
			do{
				for (int j=slobodno;j<arr.size();j+=kolo){
					arrPairs.add(j);
					flag.put(j, true);
				}
				
				for (int j=0;j<arr.size();j++){
					if (!flag.get(j)){
						slobodno = j;
						break;
					}
				}
			}while (arrPairs.size() < arr.size());
			
			for (int j=0;j<arr.size();j+=2){
				arrUtakmica.add(new Utakmica(arr.get(j), arr.get(j+1)));
			}
			
			for (Utakmica u : arrUtakmica){
				u.start();
			}
			
			for (Utakmica u : arrUtakmica){
				try{
					u.join();
					
					synchronized(Utakmica.o){
						System.out.println("==============================================");
						System.out.println("Liga: " + name);
						System.out.println("Utakmica: " + u);
						System.out.println("Rezultat: " + u.getTimA().getPoints() + " : " + u.getTimB().getPoints());
						System.out.println("Nerjseno".equals(u.won()) ? u.won() : "Pobijedio: " + u.won());
						System.out.println("==============================================");
					}
				}catch (Exception e){
					e.printStackTrace();
				}
			}
			
			for (Tim tim : arr){
				tim.permute();
			}
		}
	}
	
	public void ispisRangLige(){
		synchronized(Utakmica.o){
			Collections.sort(arr, (a, b) -> {return a.getAllPoints() >= b.getAllPoints() ? -1 : 1;});
			
			System.out.println("");
			System.out.println("=====================================================================");
			System.out.println("=====================================================================");
			
			for (Tim i : arr){
				System.out.println(i);
			}
			
			System.out.println("=====================================================================");
			System.out.println("=====================================================================");
			System.out.println("");
		}
	}
	
	public Tim teamWon(){
		return arr.get(0);
	}
}