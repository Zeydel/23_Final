package ase;

import java.io.IOException;
import java.util.Scanner;

public class WeightTest {


	public static void main(String[] args) {
		WeightFunction Weight = new WeightFunction();
		//System.out.println(Weight.getWeight());
		try {
			System.out.println(Weight.getStringFromDisplay("TEST"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Weight.clearInputStream();
	}
}
