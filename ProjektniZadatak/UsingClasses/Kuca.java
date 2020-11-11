public class Kuca {
    private Pair id;
    private int numPeople;

    Kuca(){
    }

    Kuca(Pair id){
        this.id = id;
    }

    Kuca(Pair id, int numPeople){
        this.id = id;
        this.numPeople = numPeople;
    }

    //SET

    public void setNumPeople(int numPeople){
        this.numPeople = numPeople;
    }

    //GET

    public Pair getId(){
        return id;
    }

    public int getNumPeople(){
        return numPeople;
    }
}
