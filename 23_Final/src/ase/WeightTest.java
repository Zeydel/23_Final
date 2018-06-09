package ase;

import java.io.IOException;
import java.util.Scanner;

public class WeightTest {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		WeightFunction weight = new WeightFunction();
		System.out.println(weight.getWeight());
		try {
			weight.WeightTare();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(weight.getWeight());
		weight.writeInDisplay("test", 1);
		weight.returnToWeight();
		weight.writeLongStringInDisplay("LAAAAAAAANG TEXT", 1);
		System.out.println("hej");
		try {
			System.out.println(weight.getStringFromDisplay("Tryk på noget"));
		} catch (IOException e) {
			System.out.println("IO");
			e.printStackTrace();
		}
	}

}
