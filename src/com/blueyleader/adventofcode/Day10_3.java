package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day10_3 {
	
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day10.txt");
		Scanner scan = new Scanner(file);
		input=scan.nextLine();
		StringBuilder sb= new StringBuilder("");
		for(int x=0;x<40;x++){
			char c,l;
			int count=1;
			l=input.charAt(0);
			for(int y=1;y<input.length();y++){
				 c=input.charAt(y);
				 if(c!=l){
					 sb.append(count+l);
					count=1;
					l=c;
				 }
				 else{
					 count++;
				 }
			}
			sb.append(count+1);
			input=sb.toString();
			sb=new StringBuilder("");
			System.out.println(x);
		}
		System.out.println(input.length());
	}
}

