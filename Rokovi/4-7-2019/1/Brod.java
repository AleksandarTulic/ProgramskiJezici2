public class Brod extends Vozilo{
	private static final int Height = 1;
	private static final int xChange = 1;
	private static final int yChange = 0;
	
	public Brod(String model, int MAX_NUM, int MIN_NUM, TipOsobe tip){
		super(model, MAX_NUM, MIN_NUM, tip, xChange, yChange);
		
		this.z = Height;
	}
}