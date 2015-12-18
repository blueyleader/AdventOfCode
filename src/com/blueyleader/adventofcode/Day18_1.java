package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day18_1 {

	static int max,c;
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day18.txt");
		Scanner scan = new Scanner(file);
		boolean [][] data = new boolean[100][100];
		int count=0;
		max=150;
		c=0;
		while(scan.hasNextLine()){
		input=scan.nextLine();
		for(int x=0;x<input.length();x++){
			if(input.charAt(x)=='#'){
				data[count][x]=true;
			}
			else{
				data[count][x]=false;
			}
			
		}
		count++;
		}
		int xa,xs,ya,ys;
		for(int a=0;a<100;a++){
			boolean[][] temp = new boolean[100][100];
			for(int x=0;x<data.length;x++){
				for(int y=0;y<data[x].length;y++){
					
					if(x==0){
						xs=0;
					}
					else{
						xs=1;
					}
					
					if(x==data.length-1){
						xa=0;
					}
					else{
						xa=1;
					}
					
					if(y==0){
						ys=0;
					}
					else{
						ys=1;
					}
					
					if(y==data[x].length-1){
						ya=0;
					}
					else{
						ya=1;
					}
					
					
					
					
					
					if(data[x][y]){
						count=0;
						for(int x1=x-xs;x1<=x+xa;x1++){
							for(int y1=y-ys;y1<=y+ya;y1++){
								if(!(x==x1 && y==y1)){
									if(data[x1][y1]){
										count++;
									}
								}
							}
						}
						if(count==2 || count==3){
							temp[x][y]=true;
						}
						else{
							temp[x][y]=false;
						}
						
					}else{
						count=0;
						for(int x1=x-xs;x1<=x+xa;x1++){
							for(int y1=y-ys;y1<=y+ya;y1++){
								if(!(x==x1 && y==y1)){
									if(data[x1][y1]){
										count++;
									}
								}
							}
						}
						if(count==3){
							temp[x][y]=true;
						}
						else{
							temp[x][y]=false;
						}
					}
				}
			}
			data=temp;
		}
		count=0;
		for(int x=0;x<data.length;x++){
			for(int y=0;y<data[x].length;y++){
				if(data[x][y]){
					count++;
				}
			}
		}
		
		
		System.out.println(count);
	}
	
}

