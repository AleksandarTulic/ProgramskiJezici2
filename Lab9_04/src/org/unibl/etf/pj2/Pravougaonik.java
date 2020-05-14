package org.unibl.etf.pj2;

public class Pravougaonik extends Oblik {
    private int a;
    private int b;

    public Pravougaonik(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void iscrtaj(){
        System.out.println("Strinica a: " + a);
        System.out.println("Strinica b: " + b);

        for (int i=0;i<a;i++){
            System.out.print("*");
        }

        System.out.println();

        for (int i=0;i<b-2;i++){
            for (int j=0;j<a;j++) {
                if (j == 0 || j == a - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        for (int i=0;i<a;i++){
            System.out.print("*");
        }

        System.out.println();
    }

    @Override
    public double povrsina() {
        return a * b;
    }
}
