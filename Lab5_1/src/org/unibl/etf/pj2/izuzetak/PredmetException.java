package org.unibl.etf.pj2.izuzetak;

import org.unibl.etf.pj2.predmet.Predmet;

public class PredmetException extends Exception {
    public PredmetException(){
        super("Dimenziju nisu u opsegu 1 do 100!!!");
    }

    public PredmetException(String a){
        super(a);
    }
}
