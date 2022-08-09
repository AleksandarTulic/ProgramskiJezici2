import java.util.Calendar;

public class Film {
    protected String name;
    protected int PubYear;
    protected String []actors = new String[6];
    protected double midGrade;

    public Film() {
        super();
        actors[0] = null;
    }

    public Film(String name, int PubYear, String []actors, double midGrade) throws  RangeException{
        if ( actors.length == 0 || actors.length > 6 ){
            throw new RangeException();
        }

        this.name = name;
        this.PubYear = PubYear;
        this.midGrade = midGrade;
        this.actors = actors;
    }

    public String toString(){
        String a = "Film: " + name + "\n" + "Godina objavljivanja: " + PubYear + "\n" + "Prosjecna ocjena: " + midGrade + "\n";
        a+="Glumci: \n";

        for (String act : actors){
            a+=act;
            a+="\n";
        }
        a+="\n";

        return a;
    }

    public boolean daLiUFilmuGlumiGlumac(String name){
        for (String act : actors){
            if ( act.equals(name) ){
                return true;
            }
        }

        return false;
    }

    public boolean daLiUFilmuGlumiGlumacCaseInsensitive(String name){
        for (String act : actors){
            if ( act.toLowerCase().equals(name.toLowerCase()) ){
                return true;
            }
        }

        return false;
    }

    public int kolikoJeStarFilm(){
        return Math.abs(Calendar.getInstance().get(Calendar.YEAR) - PubYear);
    }

    public boolean daLiNazivFilmaSadrziRijec(String word){
        return name.contains(word);
    }
}
