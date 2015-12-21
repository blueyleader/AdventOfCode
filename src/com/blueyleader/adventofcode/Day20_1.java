package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day20_1 {

	public static void main(String[] args) throws FileNotFoundException {
		String input="";
		File file = new File("day20.txt");
		Scanner scan = new Scanner(file);
		int num= scan.nextInt();
		int total = 0;
		int count=0;
		int x=0;
		for(x=0;count<num;x++){
			count+=x*10;
		}
		count=x;
		while(total<num){
			total=0;
			count++;
			for(int y=1;y<=count;y++){
				if(count%y==0){
					total+=y*10;
				}		
			}
			/*if(total>=10000000){
				System.out.println(count+": "+total);
			}*/
			
			//System.out.println(total);
		}
		System.out.println(count);
		
	}
	
}

