import org.unibl.etf.pj2.Krug;
import org.unibl.etf.pj2.PravougaoniTrougao;
import org.unibl.etf.pj2.Pravougaonik;
import org.unibl.etf.pj2.Oblik;


import java.util.*;
import java.util.function.Supplier;

public class test {
    public static void main(String []args) {
        IstorijaIscrtavanja a = new IstorijaIscrtavanja();

        List<Krug> list1 = Arrays.asList(new Krug(2.45), new Krug(9.199));
        List<Pravougaonik> list2 = Arrays.asList(new Pravougaonik(5, 8), new Pravougaonik(2, 11));
        List<PravougaoniTrougao> list3 = Arrays.asList(new PravougaoniTrougao(7, 3));

        a.dodajUListuIscrtavanja(list1);
        a.dodajUListuIscrtavanja(list2);
        a.dodajUListuIscrtavanja(list3);

        a.ispisIscrtavanja();
    }
}

class IstorijaIscrtavanja {
    private List<List<? extends Oblik>> iscrtavanja = new ArrayList<List<? extends Oblik>>();

    public IstorijaIscrtavanja(){
    }

    public void dodajUListuIscrtavanja(List <? extends Oblik> oblici){
        for (Oblik a : oblici){
            a.iscrtaj();
        }

        iscrtavanja.add(oblici);
    }

    public void ispisIscrtavanja(){
        int br[] = {0 , 0 , 0};

        for (List<? extends Oblik> a : iscrtavanja){
            for (Oblik aa : a){
                if ( aa instanceof Pravougaonik ){
                    br[0]++;
                }else if ( aa instanceof Krug ){
                    br[1]++;
                }else {
                    br[2]++;
                }
            }
        }

        System.out.println("Ispisao        Pravougaonik: " + br[0]);
        System.out.println("Ispisao                Krug: " + br[1]);
        System.out.println("Ispisao Pravougaoni Trougao: " + br[2]);
    }
}
