package elements;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Proizvodjac extends CommonObject implements Serializable {

	public Proizvodjac(String naziv) {
		super(naziv);
	}
	
	public static Proizvodjac imporT(String line) {
		String trim = CommonObject.getTrimed(line);
		
		String []l = trim.split("\\|");
		
		if ( l.length == 2 ) {
			return new Proizvodjac(l[1]);
		}else {
			return null;
		}
	}
}
