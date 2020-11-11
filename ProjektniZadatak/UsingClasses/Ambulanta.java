public class Ambulanta {
    private Pair id;
    private int capacity;
    private int numVehicles;

    public Ambulanta(){
    }

    public Ambulanta(Pair id, int capacity){
        this.id = id;
        this.capacity = capacity;
    }

    //SET

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setNumVehicles(int numVehicles){
        this.numVehicles = numVehicles;
    }

    //GET

    public Pair getId(){
        return id;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getNumVehicles(){
        return numVehicles;
    }
}
