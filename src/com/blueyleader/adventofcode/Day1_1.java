package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1_1 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day1.txt");
		Scanner scan = new Scanner(file);
		input = scan.nextLine();
		int total=0;
		for(int x=0;x<input.length();x++){
			if(input.charAt(x)=='(')
				total++;
			else
				total--;
		}
		System.out.println(total);
	}

}
