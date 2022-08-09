package kupac;

import artikal.*;

public class Djeca extends Fizicki{
	public Djeca(int l, int r){
		super(l, r);
	}
	
	@Override
	public boolean flagPiceCigare() {
		for (Artikal i : super.arr)
			if (i.tip == TipArtikla.pivo || i.tip == TipArtikla.cigarete)
				return false;
		
		return true;
	}
}
