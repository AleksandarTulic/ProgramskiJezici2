package org.unibl.etf.pj2.superheroes;

import org.unibl.etf.pj2.citizen.goodCitizen;

public class GreenArrow extends goodCitizen{
    public GreenArrow(){
        super("Green Arrow", false, "Ground");
        setName("Oliver Queen");
        setThing("Arrows");
    }

    public GreenArrow(String name, int pos_x, int pos_y){
        super(name, pos_x, pos_y);
    }

    public GreenArrow(String nickname, boolean powers, String placeOfWorking){
        super(nickname, powers, placeOfWorking);
    }
}
