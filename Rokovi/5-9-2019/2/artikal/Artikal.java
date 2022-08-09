package artikal;

public abstract class Artikal{
	private String barCode;
	private String naziv;
	private String opis;
	
	public Artikal(String barCode, String naziv, String opis){
		this.barCode = barCode;
		this.naziv = naziv;
		this.opis = opis;
	}
	
	public String getBarCode(){
		return barCode;
	}
	
	public String getOpis(){
		return opis;
	}
	
	public String getNaziv(){
		return naziv;
	}
	
	public boolean flagContains(String upit){
		return barCode.contains(upit);
	}
}