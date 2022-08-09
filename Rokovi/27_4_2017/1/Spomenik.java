public class Spomenik extends Atrakcija{
	private String opis;

	public Spomenik(String name, int x, int y, String opis){
		super(name, x, y, TipAtrakcije.besplatna);
		this.opis = opis;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Opis: " + opis;
	}
}