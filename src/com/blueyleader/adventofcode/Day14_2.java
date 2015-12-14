package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day14_2 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day14.txt");
		Scanner scan = new Scanner(file);
		int index,index2,index3,index4,index5,index6,speed,run,rest,low,time,total,count,temp;
		int[][] deer = new int[9][5];
		low=Integer.MIN_VALUE;
		time=2503;
		//time=1000;
		count=0;
		while(scan.hasNextLine()){
			
			
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
			
			deer[count][0]=speed;
			deer[count][1]=run;
			deer[count][2]=rest;
			deer[count][3]=0;
			deer[count][4]=0;
			count++;
		}
		for(int x=0;x<=time;x++){
			for(int y=0;y<deer.length;y++){
				temp=x%(deer[y][1]+deer[y][2]);
				if(temp<deer[y][1])
					deer[y][3]+=deer[y][0];
			}
			low=deer[0][3];
			for(int y=1;y<deer.length;y++){
				if(low<deer[y][3])
					low=deer[y][3];
			}
			for(int y=0;y<deer.length;y++){
				if(low==deer[y][3])
					deer[y][4]++;
			}
		}
		low=deer[0][4];
		for(int y=1;y<deer.length;y++){
			if(low<deer[y][4])
				low=deer[y][4];
		}
		
		System.out.println(low);
	}
}

