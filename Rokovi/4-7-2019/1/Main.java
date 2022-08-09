import java.util.*;

public class Main{
	public static final int MAX_X = 8;
	public static final int MAX_Y = 8;
	public static final int MAX_Z = 2;
	
	public static Object [][][]map = new Object[MAX_X][MAX_Y][MAX_Z];
	private static List<Vozilo> arr = new ArrayList<Vozilo>();
	
	private static final int MAX_TANKER = 2;
	private static final int MAX_KRUZER = 2;
	private static final int MAX_VOJNIBROD = 2;
	private static final int MAX_VOJNAPODMORNICA = 2;
	private static final int MAX_CIVILNAPODMORNICA = 2;
	
	public static void main(String []args){
		Ispis ispis = new Ispis();
		Scanner scanner = new Scanner(System.in);
		String line = "";
		
		do{
			System.out.print("Unesite naredbu: ");
			line = scanner.nextLine();
		}while (!"START".equals(line));
		
		Main.createBrod();
		Main.createPodmornica();
		Main.fill();
		
		for (Vozilo i : arr)
			i.start();
		
		ispis.start();
		
		try{
			for (Vozilo i : arr)
				i.join();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		ispis.setFlag(false);
	}
	
	private static void createBrod(){
		for (int i=0;i<MAX_VOJNIBROD;i++)
			arr.add(new VojniBrod());
		
		for (int i=0;i<MAX_TANKER;i++)
			arr.add(new Tanker());
		
		for (int i=0;i<MAX_KRUZER;i++)
			arr.add(new Kruzer());
	}
	
	private static void createPodmornica(){
		for (int i=0;i<MAX_VOJNAPODMORNICA;i++)
			arr.add(new VojnaPodmornica());
		
		for (int i=0;i<MAX_CIVILNAPODMORNICA;i++)
			arr.add(new CivilnaPodmornica());
	}

	private static void fill(){
		int x = 0;
		int y = 0;
		
		Random rand = new Random();
		for (int i=0;i<arr.size();i++){
			do{
				x = rand.nextInt(Main.MAX_X);
				y = rand.nextInt(Main.MAX_Y);
			}while (Main.map[x][y][arr.get(i).getZ()] != null);
			
			Main.map[x][y][arr.get(i).getZ()] = arr.get(i);
			arr.get(i).setX(x);
			arr.get(i).setY(y);
		}
	}
}