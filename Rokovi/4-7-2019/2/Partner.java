public class Partner{
	private String ime;
	private String email;
	private String emailP;
	
	public Partner(String line){
		String []l = line.split("#");
		String []r = l[1].split("@");
		
		this.ime = l[0];
		this.email = l[1];
		this.emailP = r[1];
	}
	
	//SET
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setEmailP(String emailP){
		this.emailP = emailP;
	}
	
	public void setIme(){
		this.ime = ime;
	}
	
	//GET
	
	public String getIme(){
		return ime;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getEmailP(){
		return emailP;
	}
	
	//ISPIS
	
	public String toString(){
		return "Ime: " + ime + ", Email: " + email + ", Email Provajder: " + emailP;
	}
}