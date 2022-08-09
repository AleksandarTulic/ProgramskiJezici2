package org.unibl.etf.pj2.citizen;

public class Citizen {
    protected String name;
    protected int pos_x;
    protected int pos_y;

    public Citizen(){
        super();
    }

    public Citizen(String name, int pos_x, int pos_y){
        this.name = name;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCoordinate(int x, int y){
        pos_x = x;
        pos_y = y;
    }

    public void setPosX(int x){
        pos_x = x;
    }

    public void setPossY(int y){
        pos_y = y;
    }

    public int getPos_x(){
        return pos_x;
    }

    public int getPos_y(){
        return pos_y;
    }

    public String getName(){
        return name;
    }

    public String whatGroundType(){
        return pos_y < 30 ? "voda" : pos_y >= 60 ? "vazduh" : "zemlja";
    }
}
