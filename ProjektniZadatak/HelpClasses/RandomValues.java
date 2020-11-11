import java.util.Random;

public class RandomValues {
    static Random val = new Random();
    static final String all = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String randomString(int length){
        StringBuilder a = new StringBuilder(length);
        for (int i=0;i<length;i++){
            a.append(all.charAt(randomInt(all.length()-1, 0)));
        }

        return  a.toString();
    }

    public static int randomInt(int max, int min){
        return val.nextInt(max - min + 1) + min;
    }

    public static boolean randomGender(){
        return val.nextBoolean();
    }
}
