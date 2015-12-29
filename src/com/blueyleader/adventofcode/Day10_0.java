package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day10_0 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day10.txt");
		Scanner scan = new Scanner(file);
		input=scan.nextLine();
		char data[]=null,data2[]=null;
		data2=input.toCharArray();
		int counter;
		for(int x=0;x<50;x++){
			//System.out.println(x+" "+ data2.length);
			counter=0;
			data=new char[data2.length*2];
			char c,l;
			int count=1;
			l=data2[0];
			for(int y=1;y<data2.length;y++){
				
				c=data2[y];
				 if(c!=l){
					data[counter]=(char) (count+'0');
					data[counter+1]=(char) l;
					count=0;
					counter+=2;
				 }
				 l=c;
				 count++;
				 
			}
			data[counter]=(char) (count+'0');
			data[counter+1]=(char) l;
			data2=new char[counter+2];
			for(int z=0;z<counter+2;z++){
				data2[z]=data[z];
			}
		}
		System.out.println(data2.length);
	}
	
	
	

}

