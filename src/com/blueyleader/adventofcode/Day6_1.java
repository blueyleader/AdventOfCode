package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6_1 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("day6.txt");
		Scanner scan = new Scanner(file);
		String input;
		int index,index2;
		int opp;
		int x1,x2,y1,y2;
		int total=0;
		boolean [][] lights = new boolean[1000][1000];
		while(scan.hasNextLine()){
			input = scan.nextLine();

			if(input.indexOf("turn off")!=-1){
				opp=0;
				index=9; 
			}
			else if(input.indexOf("turn on")!=-1){
				opp=1;
				index=8;
			}
			else{
				opp=2;
				index=7;
			}
			index2=input.indexOf(',');
			x1=Integer.parseInt(input.substring(index,index2));
			y1=Integer.parseInt(input.substring(index2+1,input.indexOf(' ',index2)));
			index = input.indexOf("through")+8;
			index2=input.indexOf(',',index);
			x2=Integer.parseInt(input.substring(index,index2));
			y2=Integer.parseInt(input.substring(index2+1));
			/*System.out.println(x1+ " "+y1);
			System.out.println(x2+ " "+y2);*/
			
			for(int x=x1;x<=x2;x++){
				for(int y=y1;y<=y2;y++){
					if(opp==0){
						lights[x][y]=false;
					}
					else if(opp==1){
						lights[x][y]=true;
					}
					else{
						lights[x][y]=!lights[x][y];
					}
				}
			}
		}
		
		for(int x=0;x<1000;x++){
			for(int y=0;y<1000;y++){
				if(lights[x][y]){
					total++;
				}
			}
		}
		
		System.out.println(total);
	}

}
