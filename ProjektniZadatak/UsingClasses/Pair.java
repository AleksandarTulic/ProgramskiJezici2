public class Pair{
    private int x,y;

    Pair(){
    }

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int first(){
        return x;
    }

    public int second(){
        return y;
    }

    public void setFirst(int x){
        this.x = x;
    }

    public void setSecond(int y){
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals((Pair)obj);
    }
}
