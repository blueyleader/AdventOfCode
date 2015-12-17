package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day17_1 {

	static int max;
	static int [] data;
	static int c;
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day17.txt");
		Scanner scan = new Scanner(file);
		data = new int[20];
		int count,index,index2,index3,index4,index5,total;
		count=0;
		max=150;
		c=0;
		boolean flag=true;
		while(scan.hasNextLine()){
			input=scan.nextLine();
			data[count]=Integer.parseInt(input);
			count++;
		}
		
		for(int x=0;x<20;x++){
			rec(data[x],x+1);
		}
		System.out.println(c);
		
	}
	
	public static void rec(int total,int cur){
		for(int x=cur;x<20;x++){
			if(total+data[x]<max){
				rec(total+data[x],x+1);
			}
			else if(total+data[x]==max){
				c++;
			}
			
		}
		
		
	}

}

