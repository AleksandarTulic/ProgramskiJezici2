import ispis.*;
import help.*;
import reklama.*;
import korisnik.*;

public class Main{
	public static void main(String []args){
		if (args.length < 2){
			return;
		}
		
		int n = 0;
		int m = 0;
		
		try{
			n = Integer.parseInt(args[0]);
			m = Integer.parseInt(args[1]);
			row = n;
			col = m;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Init.map = new Field[n][m][2];
		
		for (int i=0;i<n;i++)
			for (int j=0;j<m;j++)
				for (int k=0;k<2;k++)
					Init.map[i][j][k] = null;
				
		List<Korisnik> arrKorisnik = new ArrayList<Korisnik>();
		arrKorisnik.add(new Korisnik("Mirko", "JAVA"));
		arrKorisnik.add(new Korisnik("Jelena", "ETF"));
		arrKorisnik.add(new Korisnik("Vuk", "BANJA LUKA"));
		arrKorisnik.add(new Korisnik("Milena", "BANJA LUKA"));
		arrKorisnik.add(new Korisnik("Jelenko", "ETF"));
	}
}