package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day10_2 {

	public final String a1 = "1";
	public final String a2 = "11";
	public final String a3 = "111";
	
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day10.txt");
		Scanner scan = new Scanner(file);
		input=scan.nextLine();
		for(int x=0;x<50;x++){
			char l;
			int count=1;
			String n="";
			l=input.charAt(0);
			for(char c: input.toCharArray()){
				
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
			input=n.toString();
			System.out.println(x+ " "+input.length());
		}
		System.out.println(input.length());
	}
	
	
	

}

