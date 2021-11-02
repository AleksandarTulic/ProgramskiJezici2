package elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public abstract class CommonObject implements Serializable {
	public static List<CommonObject> cm = new ArrayList<CommonObject>();
	
	private String naziv;
	
	public CommonObject(String naziv) {
		this.naziv = naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public static String getTrimed(String a) {
		String res = "";
		for (int i=2;i<a.length()-3;i++) {
			res+=a.charAt(i);
		}
		
		return res;
	}
}
