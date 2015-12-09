package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8_2 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day8.txt");
		Scanner scan = new Scanner(file);
		int index=0;
		int tt=0;
		int length;
		int total=0;
		char c;
		boolean flag=true;
		while(scan.hasNextLine()){
			input=scan.nextLine();
			tt=input.length()+4;
			length=input.length();
			index=0;
			flag=true;
			while(flag){
				index=input.indexOf('\\',index);
				if(index!=-1){
					c=input.charAt(index+1);
					if(c=='\\'){
						tt+=2;
					}
					else if(c=='"'){
						tt+=2;
					}
					else{
						tt++;
					}
					index+=2;
				}
				else{
					flag=false;
				}
			}
			total+=tt-length;
		}
		System.out.println(total);
	}

}
