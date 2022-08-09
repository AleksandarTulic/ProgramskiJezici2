import java.io.*;
import java.util.*;

public class Turista extends Thread{
	private String ime;
	private int novac;
	private TipKretanja tip;
	private File folder;
	private int brojPosjecenihMjesta = 0;
	
	//for moving
	private int x = -1;
	private int y = -1;
	
	private static int brojTurista = 1;
	private static Random rand = new Random();
	private static List<Character> arr = new ArrayList<Character>();
	private static final String path = "Turiste";
	public static Object o = new Object();
	
	public Turista(int x, int y){
		this.x = x;
		this.y = y;
		
		//random name
		this.ime = Turista.getRandomIme();
		
		//random cash
		this.novac = Turista.getRandomNovac();
		
		//random tip
		this.tip = Turista.getRandomTipKretanja();
		
		//create file
		this.folder = new File(System.getProperty("user.dir") + File.separator + Turista.path + 
		File.separator + this.ime);
		this.folder.mkdir();
	}
	
	public static TipKretanja getRandomTipKretanja(){
		int tip = rand.nextInt(3) + 1;
		
		if (tip == 1){
			return TipKretanja.SAMO_U_JEDNOM_REDU;
		}else if (tip == 2){
			return TipKretanja.DIJAGONALNO;
		}
		
		return TipKretanja.KROZ_CIJELU_MATRICU;
	}
	
	public static int getRandomNovac(){
		return rand.nextInt(990) + 10;
	}
	
	static{
		for (char i='A';i<='Z';i++)
			arr.add(i);
	}
	
	public static String getRandomIme(){
		int pos = rand.nextInt(arr.size());
		return arr.get(pos) + "_" + brojTurista++;
	}
	
	@Override
	public void run(){
		do{
			if (Main.map[x][y] instanceof Muzej){
				Muzej muzej = (Muzej)Main.map[x][y];
				
				if (novac >= muzej.getCijena()){
					synchronized(PromijeniDan.o){
						if (muzej.getTipAtrakcije() == TipAtrakcije.placa)
							novac -= muzej.getCijena();
					}
					
					brojPosjecenihMjesta++;
					muzej.copyToTurista(folder);
					
					ispis(muzej);
				}else
					break;
			}else if (Main.map[x][y] instanceof Spomenik){
				brojPosjecenihMjesta++;
				
				Spomenik spomenik = (Spomenik)Main.map[x][y];
				
				ispis(spomenik);
			}else if (Main.map[x][y] instanceof ZabavniPark){
				ZabavniPark zabavniPark = (ZabavniPark)Main.map[x][y];
				
				if (novac >= zabavniPark.getCijena()){
					novac -= zabavniPark.getCijena();
					
					brojPosjecenihMjesta++;
					
					ispis(zabavniPark);
				}else
					break;
			}else if (Main.map[x][y] instanceof Crkva){
				brojPosjecenihMjesta++;
				Crkva crkva = (Crkva)Main.map[x][y];
				
				int prilog = rand.nextInt(novac + 1);
				novac -= prilog;
				
				synchronized(crkva){
					crkva.setPrilozi(prilog);
				}
				
				ispis(crkva);
			}
			
			getNextPos();
			
			try{
				Thread.sleep(100);
			}catch (Exception e){
				e.printStackTrace();
			}
		}while (x < Main.SIZE_X && x >= 0 && y < Main.SIZE_Y && y >= 0);
	}
	
	public void getNextPos(){
		if (tip == TipKretanja.SAMO_U_JEDNOM_REDU){
			int flag = rand.nextInt(2);
			
			if (flag == 0)
				y += 1;
			else
				y -= 1;
		}else if (tip == TipKretanja.DIJAGONALNO){
			int flag = rand.nextInt(4);
			
			if (flag == 0){
				x += 1;
				y += 1;
			}else if (flag == 1){
				x -= 1;
				y -= 1;
			}else if (flag == 2){
				x -= 1;
				y += 1;
			}else{
				x += 1;
				y -= 1;
			}
		}else{
			int flag = rand.nextInt(8);
			
			if (flag == 0){
				x += 1;
				y += 1;
			}else if (flag == 1){
				x -= 1;
				y -= 1;
			}else if (flag == 2){
				x -= 1;
				y += 1;
			}else if (flag == 3){
				x += 1;
				y -= 1;
			}else if (flag == 4){
				x += 1;
			}else if (flag == 5){
				x -= 1;
			}else if (flag == 6){
				y += 1;
			}else if (flag == 7){
				y -= 1;
			}
		}
	}
	
	public void ispis(Atrakcija atrakcija){
		//sinhronizovano kako se ispisi ne bi isprepletali
		synchronized(Turista.o){
			System.out.println("==========================================");
			System.out.println();
			
			System.out.println(atrakcija);
			System.out.println(this);
			
			System.out.println();
			System.out.println("==========================================");
		}
	}
	
	@Override
	public String toString(){
		return "Ime: " + ime + ", Novac: " + novac + ", Tip Kretanja: " + tip + 
		", Broj Posjecenih Mjesta: " + brojPosjecenihMjesta + ", Broj Letaka: " + folder.list().length;
	}
	
	public File getFolder(){
		return folder;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == this)
            return true;
 
        if (!(obj instanceof Turista))
            return false;
         
        Turista turista = (Turista) obj;
		
		String []list1 = folder.list();
		String []list2 = turista.getFolder().list();
		
		return list1.length >= list2.length;
	}

	public int getNumberOfFiles(){
		return folder.list().length;
	}
}