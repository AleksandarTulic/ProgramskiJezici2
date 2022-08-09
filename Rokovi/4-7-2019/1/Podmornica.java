public class Podmornica extends Vozilo{
	private static final int Height = 0;
	private static final int xChange = 0;
	private static final int yChange = -1;
	
	public Podmornica(String model, int MAX_NUM, int MIN_NUM, TipOsobe tip){
		super(model, MAX_NUM, MIN_NUM, tip, xChange, yChange);
		
		this.z = Height;
	}
}