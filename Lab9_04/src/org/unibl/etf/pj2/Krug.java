package org.unibl.etf.pj2;

public class Krug extends Oblik {
    private double r; //radius

    public Krug(double r) {
        this.r = r;
    }

    @Override
    public void iscrtaj(){
        System.out.println("Poluprecnik Kruga: " + r);
    }

    @Override
    public double povrsina() {
        return r * r * 3.1415926;
    }
}
