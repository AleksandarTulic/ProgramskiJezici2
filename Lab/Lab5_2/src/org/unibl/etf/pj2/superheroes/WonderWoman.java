package org.unibl.etf.pj2.superheroes;

import org.unibl.etf.pj2.citizen.goodCitizen;
import org.unibl.etf.pj2.interfaces.Strong;
import org.unibl.etf.pj2.interfaces.RunFast;
import org.unibl.etf.pj2.interfaces.Fly;

public class WonderWoman extends goodCitizen implements Fly, RunFast, Strong {

    public WonderWoman(){
        super("Wonder Woman", true, "Air");
        setName("Princess Diana of Themyscira");
    }

    public WonderWoman(String name, int pos_x, int pos_Y){
        super(name, pos_x, pos_Y);
    }

    public WonderWoman(String nickname, boolean powers, String placeOfWorking){
        super(nickname, powers, placeOfWorking);
    }

    @Override
    public String runfast(){
        return "Wonder woman runs really fast!!!";
    }

    @Override
    public String strong(){
        return "Wonder woman is really strong!!!";
    }

    @Override
    public String fly(){
        return "Wonder woman can fly!!!";
    }
}
