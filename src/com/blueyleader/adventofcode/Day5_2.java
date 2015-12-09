package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5_2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("day5.txt");
		Scanner scan = new Scanner(file);
		String input;
		int total=0;
		while(scan.hasNextLine()){
			input=scan.nextLine();
			boolean repeatFlag = false;
			boolean doubleFlag =false;
			
			char inputChar;
			for(int x=0;x<input.length()-2;x++){
				inputChar=input.charAt(x);
				if(!repeatFlag && inputChar==input.charAt(x+2)){
					repeatFlag=true;
				}
				String combo= ""+inputChar+input.charAt(x+1);
				if(!doubleFlag && input.indexOf(combo,x+2)!=-1)
				{
					doubleFlag=true;
				}
			}
			if(repeatFlag && doubleFlag){
				total++;
			}
		}
		System.out.println(total);
	}

}
