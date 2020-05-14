public class Kutija<T> {
    private T a;

    public void setT(T a){
        this.a = a;
    }

    public T getT(){
        return a;
    }

    public static void main(String []args){
        Kutija<Integer> a = new Kutija<>();
        a.setT(123);
        System.out.println("Dobijena vrijednost je: " + a.getT());
        Kutija<String> b = new Kutija<>();
        b.setT("prodavnica");
        System.out.println("Dobijena vrijednost je: " + b.getT());
    }
}
