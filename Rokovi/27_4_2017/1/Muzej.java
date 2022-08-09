import java.util.*;
import java.io.*;

public class Muzej extends Atrakcija{
	private File f;
	private int cijena = 0;
	//od 0 do 6, tj nulto indeksirano
	//dan u sedmici
	public static int dan = 0;
	
	public static final String path = "Muzej";
	private static final int BUFFER_SIZE = 1024;
	
	public Muzej(String name, int x, int y, File f){
		super(name, x, y, TipAtrakcije.placa);
		this.f = f;
		
		Random rand = new Random();
		cijena = rand.nextInt(Atrakcija.MAX_PRICE - Atrakcija.MIN_PRICE + 1) + Atrakcija.MIN_PRICE;
	}
	
	public void setTipAtrakcije(TipAtrakcije tip){
		super.tip = tip;
	}
	
	public TipAtrakcije getTipAtrakcije(){
		return super.tip;
	}
	
	public int getCijena(){
		return cijena;
	}
	
	public void copyToTurista(File folder){
		try{
			InputStream inputStream = new FileInputStream(f.getPath());
            OutputStream outputStream = new FileOutputStream(folder.getPath() + File.separator + f.getName());
			
			byte []buffer = new byte[Muzej.BUFFER_SIZE];
			
			while (inputStream.read(buffer) != -1){
				outputStream.write(buffer);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Cijena: " + cijena;
	}
}