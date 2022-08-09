import java.io.*;

public class VPosiljka extends Posiljka implements Serializable{
	public Valuta valuta;
	private static int num = 0;
	
	public VPosiljka(){
		super("VPosiljka_PRI_" + num, "VPosiljka_POS_" + num, 10, 100);
		
		valuta = Posiljka.getRandomValuta();
		
		num++;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Valuta: " + valuta;
	}
}