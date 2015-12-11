package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day11_2 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day11.txt");
		Scanner scan = new Scanner(file);
		boolean flag=true;
		input=scan.nextLine();
		int c=0;
		int c2=0;
		while(flag){
			if(input.indexOf('i')==-1 && input.indexOf('0')==-1 && input.indexOf('l')==-1){
				for(int x=0;x<input.length()-2;x++){
					if((input.charAt(x)+1==(input.charAt(x+1))) && (input.charAt(x)+2==(input.charAt(x+2)))){
						c=0;
						for(int y=0;y<input.length()-1;y++){
							if(input.charAt(y)==input.charAt(y+1)){
								c++;
								y++;
							}
							if(c>1)	{
								if(c2==1){
									flag=false;
								}
								c2++;
							}
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
		System.out.println(input);
	}
}

