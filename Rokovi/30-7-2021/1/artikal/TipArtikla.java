package artikal;

public enum TipArtikla{
	hljeb(1.0),
	mlijeko(1.5),
	cigarete(5.0),
	pivo(1.0),
	sok(1.0),
	slatkis(0.5);
	
	private double value;
	
	TipArtikla(double value){
		this.value = value;
	}
	
	public double getValue(){
		return value;
	}
}