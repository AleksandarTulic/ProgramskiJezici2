package elements;

public class Indeks {
	private int broj;
	private int godina;
	
	public Indeks(int broj, int godina) {
		this.godina = godina;
		this.broj = broj;
	}
	
	public void setBroj(int broj) {
		this.broj = broj;
	}
	
	public void setGodina(int godina) {
		this.godina = godina;
	}
	
	public int getBroj() {
		return broj;
	}
	
	public int getGodina() {
		return godina;
	}
}
