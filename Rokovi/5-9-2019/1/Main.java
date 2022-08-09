import radnaMasina.*;
import sensor.*;
import help.*;
import java.util.*;

public class Main{
	public static void main(String []args){
		Sensor s1 = new Temp_S("Temparature Sensor 1");
		Sensor s2 = new Press_S("Pressure Sensor 1");
		Sensor s3 = new Temp_S("Temparature Sensor 2");
		Sensor s4 = new Vibration_S("Vibration Sensor 1");
		Sensor s5 = new Moist_S("Moist Sensor 1");
		
		List<Sensor> ar1 = Arrays.asList(s1, s2);
		List<Sensor> ar2 = Arrays.asList(s3, s4, s5);
		RadnaMasina rm1 = new RadnaMasina(1, "Model 1", Status.off, ar1);
		RadnaMasina rm2 = new RadnaMasina(2, "Model 2", Status.off, ar2);
		
		Init.map.put(s1, rm1);
		Init.map.put(s2, rm1);
		Init.map.put(s3, rm2);
		Init.map.put(s4, rm2);
		Init.map.put(s5, rm2);
		
		Scanner scan = new Scanner(System.in);
		String option = "";
		
		rm1.setOn();
		rm2.setOn();
		
		do{
			//System.out.print("Input Option: ");
			option = scan.nextLine();
			
			if ("STOP".equals(option)){
				rm1.setOff();
				rm2.setOff();
				break;
			}
		}while(true);
	}
}