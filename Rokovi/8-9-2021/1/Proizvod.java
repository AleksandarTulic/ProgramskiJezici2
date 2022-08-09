import java.io.*;

public class Proizvod extends Element implements Serializable{
	public String sifra;
	public Double kolicina;
	public Double cijena;
	
	public Proizvod(String sifra, String naziv, Double kolicina, Double cijena){
		super(naziv);
		this.sifra = sifra;
		this.naziv = naziv;
		this.cijena = cijena;
	}
}