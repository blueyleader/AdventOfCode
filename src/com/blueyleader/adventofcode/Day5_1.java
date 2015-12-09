package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5_1 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("day5.txt");
		Scanner scan = new Scanner(file);
		String input;
		int total=0;
		
		//3 Vowels
		//double letter
		//do bad combos
		
		while(scan.hasNextLine()){
			input=scan.nextLine();
			int vowCount=0;
			boolean vowFlag=false;
			char lastChar;
			boolean doubleFlag=false;
			boolean badCombo=false;
			
			lastChar=input.charAt(0);
			if(lastChar=='a' || lastChar=='e' || lastChar=='i' || lastChar=='o' || lastChar=='u')
				vowCount++;
			
			char inputChar;
			
			for(int x=1;x<input.length();x++){
				inputChar=input.charAt(x);
				if(!vowFlag && (inputChar=='a' || inputChar=='e' || inputChar=='i' || inputChar=='o' || inputChar=='u')){
					vowCount++;
					if(vowCount>2){
						vowFlag=true;
					}	
				}
				
				if(!doubleFlag && inputChar==lastChar){
					doubleFlag=true;
				}
				String combo=""+lastChar+inputChar;
				if(combo.equals("ab") || combo.equals("cd") || combo.equals("pq") || combo.equals("xy")){
					badCombo=true;
				}	
				
				lastChar=inputChar;
			}
			
			if(vowFlag && doubleFlag && !badCombo){
				total++;
			}
		}
		System.out.println(total);
	}

}
