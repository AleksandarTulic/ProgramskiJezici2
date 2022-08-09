import java.io.*;

public class Ispis extends Thread{
	private static final int EVERY = 1000;
	private boolean flag = true;
	private static int brojFajla = 1;
	private static final String WHERE = "Ispis";
	
	@Override
	public void run(){
		try{
			do{
				try{
					Thread.sleep(EVERY);
				}catch (Exception e){
					e.printStackTrace();
				}
				
				synchronized(Vozilo.o){
					PrintWriter pw = new PrintWriter(System.getProperty("user.dir") + File.separator + WHERE + File.separator + brojFajla + ".txt");
					brojFajla++;
					
					pw.println("SEA SURFACE: ");
					for (int i=0;i<Main.MAX_X;i++){
						for (int j=0;j<Main.MAX_Y;j++){
							if (Main.map[i][j][1] == null){
								pw.print(" - ");
							}else{
								Vozilo vozilo = (Vozilo)Main.map[i][j][1];
								pw.print(" " + vozilo.getModel() + " ");
							}
						}
						pw.println();
					}
					
					pw.println();
					pw.println("UNDER SEA: ");
					for (int i=0;i<Main.MAX_X;i++){
						for (int j=0;j<Main.MAX_Y;j++){
							if (Main.map[i][j][0] == null){
								pw.print(" - ");
							}else{
								Vozilo vozilo = (Vozilo)Main.map[i][j][0];
								pw.print(" " + vozilo.getModel() + " ");
							}
						}
						pw.println();
					}
					
					pw.close();
				}
			}while (flag);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void setFlag(boolean flag){
		this.flag = flag;
	}
}