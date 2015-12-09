package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3_2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("day3.txt");
		Scanner scan = new Scanner(file);
		String input=scan.nextLine();
		boolean[][] houses= new boolean[1000][1000];
		houses[500][500]=true;
		int x1=500;
		int y1=500;
		
		int x2=500;
		int y2=500;
		
		for(int z =0;z<input.length();z+=2){
			char cur= input.charAt(z);
			if(cur=='<'){
				x1--;
			}
			else if(cur=='>'){
				x1++;
			}
			else if(cur=='^'){
				y1++;
			}
			else{
				y1--;
			}
			
			houses[x1][y1]=true;
			
			cur= input.charAt(z+1);
			if(cur=='<'){
				x2--;
			}
			else if(cur=='>'){
				x2++;
			}
			else if(cur=='^'){
				y2++;
			}
			else{
				y2--;
			}
			
			houses[x2][y2]=true;
		}
		
		int count =0;
		for(int a=0;a<1000;a++){
			for(int b=0;b<1000;b++){
				if(houses[a][b]){
					count++;
				}
			}	
		}
		System.out.println(count);
	}

}
