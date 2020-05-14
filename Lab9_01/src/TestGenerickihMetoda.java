import java.time.format.FormatStyle;
import java.util.Random;

public class TestGenerickihMetoda {
    public static <E> void ispisNiz(E[] ulazniNiz){
        for (E a : ulazniNiz){
            System.out.println(a);
        }
    }

    public  static void main(String []args){
        niza[] a = {new niza(), new niza(), new niza(), new niza()};
        nizb[] b = new nizb[6];
        Integer []c = {12, 45, -123, 34, 999};
        Character []d = {'a', '!', 'e', 'k', 'o', 'o', '9', '9'};

        for (int i=0;i<6;i++){
            b[i] = new nizb();
        }

        ispisNiz(a);
        System.out.println();
        ispisNiz(b);
        System.out.println();
        ispisNiz(c);
        System.out.println();
        ispisNiz(d);
    }
}

class niza{
    protected int a;
    public niza(){
        Random aa = new Random();
        a = aa.nextInt(49) + 1;
    }

    @Override
    public String toString(){
        return String.valueOf(a);
    }
}

class nizb{
    protected double b;
    public  nizb(){
        Random bb = new Random();
        b = bb.nextDouble();
    }

    @Override
    public String toString(){
        return String.valueOf(b);
    }
}
