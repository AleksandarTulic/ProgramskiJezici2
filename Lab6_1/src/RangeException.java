public class RangeException extends Exception {
    public RangeException(){
        super("Broj glumaca je veci od 6 ili je 0");
    }

    public RangeException(String e){
        super(e);
    }
}
