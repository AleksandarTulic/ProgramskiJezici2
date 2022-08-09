public class CivilniBrod extends Brod{
	private static final int MAX_NUM = 20;
	private static final int MIN_NUM = 20;
	
	public CivilniBrod(String model){
		super(model, MAX_NUM, MIN_NUM, TipOsobe.civil);
	}
}