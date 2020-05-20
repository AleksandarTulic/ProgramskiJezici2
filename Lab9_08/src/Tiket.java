import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Tiket implements Serializable {
    private static int pov = 1;
    public int id;
    private LocalDate date;
    private List<Integer> niz = new ArrayList<Integer>();
    private HashMap<Integer, Boolean> flag = new HashMap<Integer, Boolean>();

    public Tiket(){
        date = LocalDate.now();
        id = pov++;
    }

    public boolean addNumber(int number){
        if (flag.containsKey(flag)) return false;

        niz.add(number);
        flag.put(number, true);

        return true;
    }

    public List<Integer> getNumbers(){
        return niz;
    }

    public void resolveProblem(){
        for (int i=1;i<niz.size();i++){
            niz.remove(i);
        }
    }

    @Override
    public String toString(){
        String res = "id: " + id;

        res = "Brojevi: ";
        for (int a : niz){
            res+= a + " ";
        }

        res+="\n";
        res+="Datum: " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        res+="\n";

        return res;
    }
}
