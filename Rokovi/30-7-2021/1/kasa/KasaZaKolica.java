package kasa;

import kupac.*;

public class KasaZaKolica extends Kasa{
	@Override
	public boolean valid(Kupac kupac) {
		return kupac.flag == false && (kupac.getType() == false || (kupac.getType() && super.flagType));
	}
}
