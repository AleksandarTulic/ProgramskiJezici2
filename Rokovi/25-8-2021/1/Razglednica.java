import java.io.*;

public class Razglednica extends Posiljka implements Serializable{
	public String sadrzaj;
	public TipFajla tip;
	
	private static int num = 0;
	
	public Razglednica(){
		super("RAZGLEDNICA_PRI_" + num, "RAZGLEDNICA_POS_" + num, 1, 10);
		
		sadrzaj = "SADRZAJ_" + num;
		tip = Posiljka.getRandomTipFajla();
		
		num++;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Sadrzaj: " + sadrzaj + ", Tip: " + tip;
	}
}