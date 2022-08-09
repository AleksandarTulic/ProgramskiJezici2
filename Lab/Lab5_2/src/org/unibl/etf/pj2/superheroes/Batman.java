package org.unibl.etf.pj2.superheroes;

import org.unibl.etf.pj2.interfaces.*;
import org.unibl.etf.pj2.citizen.goodCitizen;

public class Batman extends goodCitizen implements Fly{

    public Batman(){
        super("Batman", false, "Ground");
        setName("Bruce Wayne");
        setThing("Batmobil");
    }

    public Batman(String name, int pos_x, int pos_y){
        super(name, pos_x, pos_y);
    }

    public Batman(String nickname, boolean powers, String placeOfWorking){
        super(nickname, powers, placeOfWorking);
    }

    @Override
    public String fly(){
        return "Batman can fly this is incredible!!!";
    }
}
