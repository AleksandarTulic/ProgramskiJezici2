public class PretragaFilmova {
    public static void main(String []args){
        String []actors = { new String("Robert Downey Junior"), new String("Chris Evans"), new String("Elizabeth Olsen"),
                new String("Scarlett Johansson"), new String("Tom Holland"), new String("Vin Diesel")};

        try{
            Film a = new Film("Avengers", 2012, actors, 7.9);
            System.out.println(a);
            System.out.println("Da li u filmu glumi glumac Leonardo Dicaprio: " + a.daLiUFilmuGlumiGlumac("Leonardo Dicaprio"));
            System.out.println("Da li u filmu glumi glumac ChrIs EVans: " + a.daLiUFilmuGlumiGlumacCaseInsensitive("ChrIS EVans"));
            System.out.println("Da li u filmu glumi glumac ChrIs EVans: " + a.daLiUFilmuGlumiGlumac("ChrIS EVans"));
            System.out.println("Koliko je star film: " + a.kolikoJeStarFilm());
            System.out.println("Da li naziv filma sadrzi rijec ven: " + a.daLiNazivFilmaSadrziRijec("ven"));
        }catch (RangeException e){
            e.printStackTrace();
        }

        try{
            AnimiraniFilm b = new AnimiraniFilm("Avengers", 2012, actors, 7.9, "Yommy Lee Jones");
            System.out.println(b);
            System.out.println("Crtac unazad: " + b.crtacUnazad());
        }catch (RangeException e){
            e.printStackTrace();
        }
    }
}
