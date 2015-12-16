package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3_1 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("day3.txt");
		Scanner scan = new Scanner(file);
		String input=scan.nextLine();
		boolean[][] houses= new boolean[1000][1000];
		houses[500][500]=true;
		int x=500;
		int y=500;
		
		for(int z =0;z<input.length();z++){
			char cur= input.charAt(z);
			if(cur=='<'){
				x--;
			}
			else if(cur=='>'){
				x++;
			}
			else if(cur=='^'){
				y++;
			}
			else{
				y--;
			}
			
			houses[x][y]=true;
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
