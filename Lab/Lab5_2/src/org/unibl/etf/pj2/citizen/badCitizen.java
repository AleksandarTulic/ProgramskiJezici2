package org.unibl.etf.pj2.citizen;

public class badCitizen extends Citizen {
    protected boolean kripto;

    public badCitizen(){
        super();
    }

    public badCitizen(boolean kripto){
        super();
        this.kripto = kripto;
    }

    public badCitizen(String name, int pos_x, int pos_y){
        super(name, pos_x, pos_y);
        this.kripto = kripto;
    }

    public void setKripto(boolean kripto){
        this.kripto = kripto;
    }

    public boolean getKripto(){
        return kripto;
    }
}
