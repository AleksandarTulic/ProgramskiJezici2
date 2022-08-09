public class CivilnaPodmornica extends Podmornica{
	private static final String MODEL = "CP";
	private static final int MAX_NUM = 8;
	private static final int MIN_NUM = 1;
	
	public CivilnaPodmornica(){
		super(MODEL, MAX_NUM, MIN_NUM, TipOsobe.civil);
	}
}