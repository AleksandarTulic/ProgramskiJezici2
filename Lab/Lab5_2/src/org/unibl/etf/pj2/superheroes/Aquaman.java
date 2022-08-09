package org.unibl.etf.pj2.superheroes;

import org.unibl.etf.pj2.citizen.goodCitizen;
import org.unibl.etf.pj2.interfaces.Swim;
import org.unibl.etf.pj2.interfaces.RunFast;
import org.unibl.etf.pj2.interfaces.Strong;

public class Aquaman extends goodCitizen implements Swim, RunFast, Strong {

    public Aquaman(){
        super("Aquaman", true, "Water");
        setName("Arthur Curry");
    }

    public Aquaman(String name, int pos_x, int pos_y){
        super(name, pos_x, pos_y);
    }

    public Aquaman(String nickname, boolean powers, String placeOfWorking){
        super(nickname, powers, placeOfWorking);
    }

    @Override
    public String runfast(){
        return "Aquaman runs really fast!!!";
    }

    @Override
    public String strong(){
        return "Aquaman is really strong!!!";
    }

    @Override
    public String swim(){
        return "Aquaman can swim!!!";
    }
}
