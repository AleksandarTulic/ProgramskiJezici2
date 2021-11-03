package elements;

public class Student {
	private String ime;
	private String prezime;
	private Indeks ind;
	private int godinaRod;
	private int godinaStu;
	private double ocjena;
	
	public Student(String ime, String prezime, Indeks ind, int godinaRod, int godinaStu, double ocjena) {
		this.ime = ime;
		this.prezime = prezime;
		this.ind = ind;
		this.godinaRod = godinaRod;
		this.godinaStu = godinaStu;
		this.ocjena = ocjena;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public Indeks getInd() {
		return ind;
	}
	public void setInd(Indeks ind) {
		this.ind = ind;
	}
	public int getGodinaRod() {
		return godinaRod;
	}
	public void setGodinaRod(int godinaRod) {
		this.godinaRod = godinaRod;
	}
	public int getGodinaStu() {
		return godinaStu;
	}
	public void setGodinaStu(int godinaStu) {
		this.godinaStu = godinaStu;
	}
	public double getOcjena() {
		return ocjena;
	}
	public void setOcjena(double ocjena) {
		this.ocjena = ocjena;
	}

	@Override
	public String toString() {
		return "Student [ime=" + ime + ", prezime=" + prezime + ", ind=" + ind.getBroj() + "/" + ind.getGodina() + ", godinaRod=" + godinaRod
				+ ", godinaStu=" + godinaStu + ", ocjena=" + ocjena + "]";
	}
}
