public class AnimiraniFilm extends Film{
    private String crtac;

    public AnimiraniFilm(){
        super();
    }

    public AnimiraniFilm(String name, int PubYear, String []actors, double midGrade, String crtac) throws RangeException{
        super(name, PubYear, actors, midGrade);
        this.crtac = crtac;
    }

    public String toString(){
        String a = super.toString();
        a+="Crtac: " + crtac + "\n";

        return a;
    }

    public String crtacUnazad(){
        return new StringBuilder(crtac).reverse().toString();
    }
}
