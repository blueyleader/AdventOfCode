package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day15_1 {

	static int low;
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day15.txt");
		Scanner scan = new Scanner(file);
		int [][] data = new int[4][5];
		int count,index,index2,index3,index4,index5;
		count=0;
		while(scan.hasNextLine()){
			input=scan.nextLine();
			index=input.indexOf("capacity")+9;
			index2=input.indexOf("durability")+11;
			index3=input.indexOf("flavor")+7;
			index4=input.indexOf("texture")+8;
			index5=input.indexOf("calories")+9;
			String temp=(input.substring(index,input.indexOf(',',index)));
			data[count][0]=Integer.parseInt(input.substring(index,input.indexOf(',',index)));
			data[count][1]=Integer.parseInt(input.substring(index2,input.indexOf(',',index2)));
			data[count][2]=Integer.parseInt(input.substring(index3,input.indexOf(',',index3)));
			data[count][3]=Integer.parseInt(input.substring(index4,input.indexOf(',',index4)));
			data[count][4]=Integer.parseInt(input.substring(index5));
			
			count++;
		}
		
		int c=0,b=0,s=0,q=0;
		int total=0;
		int low=0;
		for(int x=0;x<=100;x++){
			for(int y=0;y<=100;y++){
				
				for(int z=0;z<=100;z++){
					
					for(int a=0;a<=100;a++){
						total=1;

						if(x+y+z+a==100){
							for(int v=0;v<4;v++){
								int t=(data[0][v]*x+data[1][v]*y+data[2][v]*z+data[3][v]*a);
								if(t<0)
									t=0;
								total*=t;
								
							}
							if(total>low){
								low=total;
							}
							
						}
						
					}
				}
			}
		}
		System.out.println(low);
		
	}
	
	public static void rec(int[] nums){
		
	}

}

