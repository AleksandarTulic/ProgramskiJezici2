import java.util.*;

public class Tim{
	private String name;
	private List<Kosarkas> arr = new ArrayList<Kosarkas>();
	private static int numberOfTeams = 1;
	private int points = 0;
	private int allPoints = 0;
	private int allPlayOffPoints = 0;
	
	public Tim(){
		this.name = "Tim_" + numberOfTeams++;
		
		arr.add(new Plej());
		arr.add(new Plej());
		
		arr.add(new Suter());
		arr.add(new Suter());
		
		arr.add(new Nisko());
		arr.add(new Nisko());
		arr.add(new Nisko());
		
		arr.add(new Visoko());
		arr.add(new Visoko());
		arr.add(new Visoko());
		
		arr.add(new Centar());
		arr.add(new Centar());
	}
	
	public void permute(){
		Collections.shuffle(arr);
	}
	
	public List<Kosarkas> getKosarkasi(){
		return arr;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPoints(int points){
		this.points = points;
	}
	
	public int getPoints(){
		return points;
	}
	//https://www.javatpoint.com/java-collections-shuffle-method

	public int getAllPoints(){
		return allPoints;
	}
	
	public int getAllPlayOffPoints(){
		return allPlayOffPoints;
	}
	
	public void setAllPlayOffPoints(int allPlayOffPoints){
		this.allPlayOffPoints = allPlayOffPoints;
	}
	
	public void setAllPoints(int allPoints){
		this.allPoints = allPoints;
	}
	
	@Override
	public String toString(){
		return "Name: " + name + ", Points: " + allPoints;
	}
}