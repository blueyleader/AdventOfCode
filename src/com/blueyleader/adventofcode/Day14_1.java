package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day14_1 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day14.txt");
		Scanner scan = new Scanner(file);
		int index,index2,index3,index4,index5,index6,speed,run,rest,low,time,total,count;
		low=Integer.MIN_VALUE;
		time=2503;
		
		while(scan.hasNextLine()){
			count=0;
			total=0;
			input=scan.nextLine();
			index=input.indexOf("fly")+4;
			index2=input.indexOf(' ',index);
			index3=input.indexOf("for")+4;
			index4=input.indexOf(' ',index3);
			index5=input.indexOf("for",index3)+4;
			index6=input.indexOf(' ',index5);
			
			speed=Integer.parseInt(input.substring(index,index2));
			run=Integer.parseInt(input.substring(index3,index4));
			rest=Integer.parseInt(input.substring(index5,index6));
			
			while(count<=time){
				if(count+run<=time){
					total+=speed*run;
					count+=run;
				}
				else{
					total+=(time-count)*speed;
				}
				count+=rest;
			}
			if(total>low){
				low=total;
			}
		}
		
		
		System.out.println(low);
	}
}

