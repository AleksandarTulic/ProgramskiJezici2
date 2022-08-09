import java.util.*;

public class ZabavniPark extends Atrakcija{
	private int cijena = 0;
	
	public ZabavniPark(String name, int x, int y){
		super(name, x, y, TipAtrakcije.placa);
		
		Random rand = new Random();
		cijena = rand.nextInt(Atrakcija.MAX_PRICE - Atrakcija.MIN_PRICE + 1) + Atrakcija.MIN_PRICE;
	}
	
	public int getCijena(){
		return cijena;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Cijena: " + cijena;
	}
}