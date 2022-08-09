import java.io.*;

public class Pismo extends Posiljka implements Serializable{
	private static int num = 0;
	
	public Pismo(){
		super("PISMO_PRI_" + num, "PISMO_POS_" + num, 1, 20);
		num++;
	}
}