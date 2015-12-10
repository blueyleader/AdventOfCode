package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day10_2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day10.txt");
		Scanner scan = new Scanner(file);
		input=scan.nextLine();
		for(int x=0;x<40;x++){
			char c,l;
			int count=1;
			String n="";
			l=input.charAt(0);
			for(int y=1;y<input.length();y++){
				 c=input.charAt(y);
				 if(c!=l){
					n=n+count+l;
					count=1;
					l=c;
				 }
				 else{
					 count++;
				 }
			}
			n=n+count+l;
			input=n;
		}
		System.out.println(input.length());
	}
}

