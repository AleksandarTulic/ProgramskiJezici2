public class Crkva extends Atrakcija{
	private int prilozi = 0;
	
	public Crkva(String name, int x, int y){
		super(name, x, y, TipAtrakcije.dobrovoljno);
	}
	
	public void setPrilozi(int prilog){
		prilozi += prilog;
	}
	
	public int getPrilozi(){
		return prilozi;
	}
	
	@Override
	public String toString(){
		return super.toString() + ", Prilozi: " + prilozi;
	}
}