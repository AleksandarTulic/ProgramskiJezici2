package help;

import radnaMasina.*;
import sensor.*;
import java.util.*;
import java.io.*;

public class Init{
	public static Map <Sensor, RadnaMasina> map = new HashMap<Sensor, RadnaMasina>();
	public static Object o = new Object();
	
	public static void print(String message){
		synchronized(o){
			System.out.println(message);
		}
	}
}