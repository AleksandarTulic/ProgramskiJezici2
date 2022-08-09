public class Polje{
	public TipPolja tip;
	public int gubitak;
	
	public Polje(TipPolja tip, int gubitak){
		this.gubitak = gubitak;
		this.tip = tip;
	}
	
	@Override
	public String toString(){
		return "Tip: " + tip + ", Gubitak: " + gubitak;
	}
}