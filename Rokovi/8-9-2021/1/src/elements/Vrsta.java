package elements;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Vrsta  extends CommonObject implements Serializable {
	public Vrsta(String naziv) {
		super(naziv);
	}
	
	public static Vrsta imporT(String line) {
		String trim = CommonObject.getTrimed(line);
		
		String []l = trim.split("\\|");
		
		if ( l.length == 2 ) {
			return new Vrsta(l[1]);
		}else {
			return null;
		}
	}
}
