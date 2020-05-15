import java.io.*;

public class Zaposleni implements Serializable {
    private String realName;
    private String surnName;
    private String userName;
    private int numHours;

    public Zaposleni(){
    }

    public Zaposleni(String realName, String surnName, String userName, int numHours){
        this.realName = realName;
        this.surnName = surnName;
        this.userName = userName;
        this.numHours = numHours;
    }

    public void setNumHours(int numHours){
        this.numHours = numHours;
    }

    public String getUserName(){
        return userName;
    }

    public String getSurnName(){
        return surnName;
    }

    public int getNumHours(){
        return numHours;
    }

    public String getRealName(){
        return realName;
    }
}
