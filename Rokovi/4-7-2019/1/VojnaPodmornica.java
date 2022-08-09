public class VojnaPodmornica extends Podmornica{
	private static final String MODEL = "VP";
	private static final int MAX_NUM = 8;
	private static final int MIN_NUM = 1;
	
	public VojnaPodmornica(){
		super(MODEL, MAX_NUM, MIN_NUM, TipOsobe.vojnik);
	}
}