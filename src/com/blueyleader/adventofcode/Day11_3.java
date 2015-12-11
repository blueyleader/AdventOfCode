package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day11_3 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day11.txt");
		Scanner scan = new Scanner(file);
		boolean flag=true;
		boolean seq=false;
		boolean once = false;
		input=scan.nextLine();
		int c=0;
		while(flag){
			c=0;
			seq=false;
			if(input.indexOf('i')==-1 && input.indexOf('0')==-1 && input.indexOf('l')==-1){
				for(int x=0;x<input.length()-2;x++){
					if((input.charAt(x)+1==(input.charAt(x+1))) && (input.charAt(x)+2==(input.charAt(x+2)))){
						seq=true;
						break;
					}
				}
				if(seq){
					for(int x=0;x<input.length()-1;x++){
						if(input.charAt(x)==input.charAt(x+1)){
							c++;
							x++;
						}
						if(c>1)	{
							System.out.println(input);
							if(once){
								flag=false;	
							}
							once=true;
							break;
						}
					}
				}
				
				
			}
			if(flag){
				boolean change=true;
				for(int x=input.length()-1;x>-1;x--){
					if(change){
						if(input.charAt(x)=='z'){
							char t='a';
							input=input.substring(0,x)+t+input.substring(x+1,input.length());
						}
						else{
							char t=(char) (input.charAt(x)+1);
							input=input.substring(0,x)+t+input.substring(x+1,input.length());
							change=false;
						}
					}
				}				
			}
		}
	}
}

