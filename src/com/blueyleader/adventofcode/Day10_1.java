package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day10_1 {

	static int low;
	public static void main(String[] args) throws FileNotFoundException {
		String input="1113122113";
		input="1211";
		File file = new File("day9.txt");
		Scanner scan = new Scanner(file);
		for(int x=0;x<3;x++){
			char c,l;
			int count=0;
			String n="";
			l=input.charAt(0);
			for(int y=1;y<input.length();y++){
				 c=input.charAt(y);
				 count++;
				 if(c!=l){
					 if(c!='1'){
						 n=n+count+c;
					 }
					 else if(count>1){
						 n=n+count+1;
					 }
					 else{
						 n=n+1;
					 }
					 count=0;
				}
				 l=c;
			}
			input=n;
		}
		System.out.println(input);
		System.out.println(input.length());
	}
	
	
	

}

