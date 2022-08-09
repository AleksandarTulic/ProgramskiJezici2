package org.unibl.etf.pj2.justiceleague;

import org.unibl.etf.pj2.citizen.Citizen;
import org.unibl.etf.pj2.citizen.badCitizen;
import org.unibl.etf.pj2.citizen.goodCitizen;
import org.unibl.etf.pj2.superheroes.*;

import java.util.Random;

public class JusticeLeague {
    public  static void main(String []args){
        Citizen [][]m = new Citizen[30][90];
        badCitizen []bad = new badCitizen[6];
        goodCitizen []good = {new Aquaman(), new Superman(), new WonderWoman(), new GreenArrow(), new Batman()};

        Random rand = new Random();

        for (int i=0;i<6;i++){
            bad[i] = new badCitizen();
        }

        bad[0].setName("Joker");
        bad[1].setName("Bane");
        bad[2].setName("Darth Vader");
        bad[3].setName("Lord Voldemort");
        bad[4].setName("Ras al Ghul");
        bad[5].setName("Vin Diesel");
        bad[5].setKripto(true);

        for (int i=0;i<6;i++){
            int x = rand.nextInt(30);
            int y = rand.nextInt(90);
            bad[i].setCoordinate(x-1, y-1);
            m[x][y] = bad[i];
        }

        for (int i=0;i<30;i++){
            for (int j=0;j<90;j++){
                if ( m[i][j] instanceof badCitizen ){
                    if ( m[i][j].whatGroundType() == "voda" ){ //voda
                        System.out.println("Zlikovac " + m[i][j].getName() + " je unisten! " + good[0].getNickName());
                        m[i][j] = good[0];
                    }else if ( m[i][j].whatGroundType() == "zemlja" ){
                        System.out.print("Zlikovac " + m[i][j].getName() + " je unisten! ");
                        boolean flag = rand.nextBoolean();
                        if ( flag ){
                            System.out.println("Superheroj " + good[3].getNickName());
                            m[i][j] =  good[3];
                            System.out.println();
                        }else{
                            System.out.println("Superheroj " + good[4].getNickName());
                            m[i][j] =  good[4];
                            System.out.println();
                        }
                    }else{
                        int k;
                        for (k=0;k<6;k++){
                            if ( bad[k].getName() == m[i][j].getName() ){
                                break;
                            }
                        }

                        if ( bad[k].getKripto() ){
                            System.out.println("Superman je unisten!");
                            System.out.println("Zlikovac " + bad[k].getName() + " je unisten! " + "Superheroj " + good[2].getNickName());
                            m[i][j] = good[2];
                        }else{
                            boolean flag = rand.nextBoolean();

                            if ( flag ){
                                System.out.println("Zlikovac " + bad[k].getName() + " je unisten! " + "Superheroj " + good[2].getNickName());
                                m[i][j] = good[2];
                            }else{
                                System.out.println("Zlikovac " + bad[k].getName() + " je unisten! " + "Superheroj " + good[1].getNickName());
                                m[i][j] = good[1];
                            }
                        }
                    }
                }
            }
        }
    }
}
