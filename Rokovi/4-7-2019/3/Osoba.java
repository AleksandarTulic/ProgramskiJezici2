public class Osoba{
	private String ime;
	private String prezime;
	private int god;
	
	public Osoba(String ime, String prezime, int god){
		this.god = god;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	//GET
	
	public String getIme(){
		return ime;
	}
	
	public String getPrezime(){
		return prezime;
	}
	
	public int getGod(){
		return god;
	}
	
	//SET
	
	public void setIme(String ime){
		this.ime = ime;
	}
	
	public void setPrezime(String prezime){
		this.prezime = prezime;
	}
	
	public void setGod(int god){
		this.god = god;
	}
	
	//ispis
	
	public String toString(){
		return "Ime: " + ime + ", Prezime: " + prezime + ", Godiste: " + god;
	}
}
