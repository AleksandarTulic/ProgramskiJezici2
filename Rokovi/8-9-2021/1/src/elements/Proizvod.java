package elements;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Proizvod extends CommonObject implements Serializable {
	private String sifra;
	private double kolicina;
	private double cijena;
	
	public Proizvod(String naziv, String sifra, double kolicina, double cijena) {
		super(naziv);
		this.sifra = sifra;
		this.kolicina = kolicina;
		this.cijena = cijena;
	}
	
	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	public String getSifra() {
		return sifra;
	}
	
	public double getKolicina() {
		return kolicina;
	}
	
	public double getCijena() {
		return cijena;
	}
	
	//morao sam umjesto import koristiti imporT jer je prvo kljucna rijec
	public static Proizvod imporT(String line) {
		String trim = CommonObject.getTrimed(line);
		
		String []l = trim.split("\\|");
		
		if ( l.length == 5 ) {
			try {
				return new Proizvod(l[2], l[1], Double.parseDouble(l[3]), Double.parseDouble(l[4]));
			}catch (Exception e) {
				return null;
			}
		}else {
			return null;
		}
	}
}
