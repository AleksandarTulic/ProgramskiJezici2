public class VojniBrod extends Brod{
	private static final String MODEL = "VB";
	
	private static final int MAX_NUM = 20;
	private static final int MIN_NUM = 20;
	
	public VojniBrod(){
		super(MODEL, MAX_NUM, MIN_NUM, TipOsobe.vojnik);
	}
}