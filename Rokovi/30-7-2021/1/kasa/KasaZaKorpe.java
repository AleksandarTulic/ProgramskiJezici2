package kasa;

import kupac.Kupac;

public class KasaZaKorpe extends Kasa{
	@Override
	public boolean valid(Kupac kupac) {
		return kupac.flag == true && (kupac.getType() == false || (kupac.getType() && super.flagType));
	}
}
