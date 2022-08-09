package main;

import java.util.*;

import file.FileOperations;
import prodavnica.*;

public class Main {
	public static Random rand = new Random();
	public static Prodavnica prodavnica = new Prodavnica();
	
	public static void main(String[] args) {
		prodavnica.start();
		
		try {
			prodavnica.join();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Neuspjela kupovina: ");
		List<String> arr = FileOperations.getElements();
		
		arr.stream().forEach(System.out::println);
	}

}
