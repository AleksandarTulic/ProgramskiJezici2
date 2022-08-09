import java.util.*;
import java.util.Map.*;
import java.io.*;
import java.util.stream.*;

public class Main{
	public static Map<Character, Integer> map = new HashMap<Character, Integer>();
	
	static{
		for (int i=0;i<=255;i++){
			char a = (char)i;
			map.put(a, 0);
		}
	}
	
	public static void main(String []args){
		try{
			do{
				System.out.print("Unesite putanju[ili STOP]: ");
				Scanner scan = new Scanner(System.in);
				String path = scan.nextLine();
				
				if ("STOP".equals(path)){
					File f = new File(System.getProperty("user.dir") + File.separator + "rezultat");
					if (!f.exists())
						f.mkdir();
					
					//System.out.println(map.entrySet().stream().mapToInt(t -> t.getValue()).max().orElse(0));
					Character []arrCh = new Character[map.entrySet().stream().mapToInt(t -> t.getValue()).max().orElse(0) + 10];
					map.entrySet().stream().filter(t -> t.getValue() > 0).forEach(t -> {
						arrCh[t.getValue()] = t.getKey();
					});
					
					int br = 0;
					for (int i=arrCh.length-1;i>=0;i--){
						if (arrCh[i] != null){
							File fOut = new File(System.getProperty("user.dir") + File.separator + "rezultat" + File.separator + br + ".txt");
							//fOut.createNewFile();
							PrintWriter pw = new PrintWriter(fOut);
							pw.println(i + " " + arrCh[i]);
							pw.close();
							br++;
							//System.out.println(i + " " + arrCh[i]);
						}
					}
					return;
				}
				
				GetContent gCon = new GetContent(path);
			
				gCon.start();
				gCon.join();
			}while(true);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}