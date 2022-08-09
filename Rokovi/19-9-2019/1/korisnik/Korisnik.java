package korisnik;

import ispis.*;
import help.*;
import reklama.*;

public class Korisnik extends Thread{
	private String interesovanje;
	private String name;
	private int x = 0;
	private int y = 0;
	private int intNum = 0; //interesovanja
	private double humanNum = 0; //sakupio
	
	public Korisnik(String name, String interesovanje){
		this.interesovanje = interesovanje;
		this.name = name;
	}
	
	public void setInteresovanje(String interesovanje){
		this.interesovanje = interesovanje;
	}
	
	public String getInteresovanje(){
		return interesovanje;
	}
	
	public void nextPos(){
		if (x == Init.col-1 && y == Init.row-1){
			x = -1;
		}else if (x == Init.col-1){
			x = 0;
			y++;
		}else{
			x++;
		}
	}
	
	@Override
	public void run(){
		do{
			synchronized(Init.map[x][y]){
				if (Init.map[x][y] != null){
					if (Init.map[x][y][0] != null){
						Reklama r = (Reklama)Init.map[x][y][0];
						
						if (r instanceof Ciljana){
							Ciljana c = (Ciljana)r;
							
							if (interesovanje.equals(c.getInteresovanje())){
								intNum++;
							}
						}else{
							Humanitarna h = (Humanitarna)r;
							
							humanNum += h.getCash();
						}
						
						Ispis ispis = new Ispis(r.getOpis());
						ispis.start();
					}
					
					if (Init.map[x][y][1] != null){
						Reklama r = (Reklama)Init.map[x][y][1];
						
						if (r instanceof Ciljana){
							Ciljana c = (Ciljana)r;
							
							if (interesovanje.equals(c.getInteresovanje())){
								intNum++;
							}
						}else{
							Humanitarna h = (Humanitarna)r;
							
							humanNum += h.getCash();
						}
						
						Ispis ispis = new Ispis(r.getOpis());
						ispis.start();
					}
				}
			}
			
			if ( Init.st.getFlagSimul() )
				nextPos();
			else
				break;
		}while(x != -1);
		
		int polja = (Init.row-x) * (Init.col - 1);
		
		Ispis.tekstIspis("Ime: " + ime + ", Ostalo polja: " + polja + ", Sakupio: " + );
	}
}