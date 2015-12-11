package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day11_1 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day11.txt");
		Scanner scan = new Scanner(file);
		int total=0;
		boolean flag=true;
		input=scan.nextLine();
		int a = 'z';
		int c=0;
		while(flag){
			if(input.equals("abcdffaa"))
				System.out.println("hit");
			if(input.indexOf('i')==-1 && input.indexOf('0')==-1 && input.indexOf('l')==-1){
				for(int x=0;x<input.length()-2;x++){
					if((input.charAt(x)+1==(input.charAt(x+1))) && (input.charAt(x)+2==(input.charAt(x+2)))){
						c=0;
						for(int y=0;y<input.length()-1;y++){
							if(input.charAt(y)==input.charAt(y+1)){
								c++;
								y++;
							}
							if(c>1)	
								flag=false;
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
			c=0;
			System.out.println(input);
		}
		System.out.println(input);
		System.out.println("hit2");
	}

}
//a =97
//z=122
