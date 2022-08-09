package org.unibl.etf.pj2.superheroes;

import org.unibl.etf.pj2.interfaces.Strong;
import org.unibl.etf.pj2.interfaces.RunFast;
import org.unibl.etf.pj2.interfaces.Fly;
import org.unibl.etf.pj2.citizen.goodCitizen;

public class Superman extends goodCitizen implements Fly, RunFast, Strong {

    public Superman(){
        super("Superman", true, "Air");
        setName("Clark Kent");
    }

    public Superman(String name, int pos_x, int pos_y){
        super(name, pos_x, pos_y);
    }

    public Superman(String nickname, boolean powers, String placeOfWorking){
        super(nickname, powers, placeOfWorking);
    }

    @Override
    public String runfast(){
        return "Superman runs really fast!!!";
    }

    @Override
    public String strong(){
        return "Superman is really strong!!!";
    }

    @Override
    public String fly(){
        return "Superman can fly!!!";
    }
}
