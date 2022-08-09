public class Atrakcija{
	private String name;
	private int x;
	private int y;
	protected TipAtrakcije tip;
	
	//ako se placa
	public static final int MAX_PRICE = 80;
	public static final int MIN_PRICE = 10;
	
	public Atrakcija(String name, int x, int y, TipAtrakcije tip){
		this.tip = tip;
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public TipAtrakcije getTipAtrakcija(){
		return tip;
	}
	
	@Override
	public String toString(){
		return "Naziv: " + name + ", Position: [" + x + ", " + y + "], Tip Atrakcije: " + tip.toString();
	}
}