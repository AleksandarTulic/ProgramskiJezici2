package kasa;

import kupac.Kupac;

public class KasaZaObadvoje extends Kasa{
	@Override
	public boolean valid(Kupac kupac) {
		return kupac.getType() == false || (kupac.getType() && super.flagType);
	}
}
