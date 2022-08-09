import java.util.*;

public class Main{
	public static final int MAX_ROWS = 40;
	public static Random rand = new Random();
	public Object [][]map = new Object[MAX_ROWS][3];
	
	public static void main(String ... args) throws Exception{
		System.out.print("Unesite dimenziju matrice: ");
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		
		setOnRandomPositions();
	}
	
	private static void setOnRandomPositions(int n){
		List<Integer> rem = new ArrayList<>();
		for (int i=0;i<2;i++){
			int x = -1;
			
			do{
				x = rand.nextInt(MAX_ROWS);
			}while(rem.contains(x));
			
			if (i == 0){
				NAviona a = new NAviona();
				a.x = x;
				a.y = 0;
				
				map[x][0] = a;
				rem.add(x);
			}else{
				Razarac a = new Razarac();
				a.x = x;
				a.y = 0;
				
				map[x][0] = a;
				rem.add(x);
			}
		}
		
		rem.clear();
		for (int i=0;i<2;i++){
			int x = -1;
			
			do{
				x = rand.nextInt(MAX_ROWS);
			}while(rem.contains(x));
			
			Podmornica a = new Podmornica();
			a.x = x;
			a.y = y;
			
			map[x][0] = x;
			rem.add(x);
		}
	}
}