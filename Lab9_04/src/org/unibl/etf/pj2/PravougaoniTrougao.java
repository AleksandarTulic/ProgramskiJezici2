package org.unibl.etf.pj2;

public class PravougaoniTrougao extends Oblik {
    private int a;
    private int b;

    public PravougaoniTrougao(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void iscrtaj(){
        System.out.println("Hipotenuza a: " + a);
        System.out.println("Katete     b: " + b);
    }

    @Override
    public double povrsina() {
        return a * b / 2;
    }
}
