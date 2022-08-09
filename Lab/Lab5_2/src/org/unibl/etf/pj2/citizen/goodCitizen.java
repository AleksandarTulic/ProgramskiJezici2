package org.unibl.etf.pj2.citizen;

public class goodCitizen extends Citizen {
    protected String nickname;
    protected boolean powers;
    protected String placeOfWorking;
    protected String thing;

    public goodCitizen(){
        super();
    }

    public goodCitizen(String nickname, boolean powers, String placeOfWorking){
        super();
        this.nickname = nickname;
        this.powers = powers;
        this.placeOfWorking = placeOfWorking;
    }

    public goodCitizen(String name, int pos_x, int pos_y){
        super(name, pos_x, pos_y);
    }

    public String getNickName(){
        return nickname;
    }

    public boolean getPowers(){
        return powers;
    }

    public String getPlaceOfWorking(){
        return placeOfWorking;
    }

    public String getThing(){
        return thing;
    }

    public void setNickName(String nickname){
        this.nickname = nickname;
    }

    public void setPowers(boolean powers){
        this.powers = powers;
    }

    public void setPlaceOfWorking(String placeOfWorking){
        this.placeOfWorking = placeOfWorking;
    }

    public void setThing(String thing){
        this.thing = thing;
    }
}
