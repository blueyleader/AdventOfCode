package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2_1 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day2.txt");
		Scanner scan = new Scanner(file);
		int total=0;

		while(scan.hasNextLine()){
			input=scan.nextLine();
			int index1 = input.indexOf('x');
			int index2 = input.indexOf('x',index1+1);
			
			int num1= Integer.parseInt(input.substring(0,index1));
			int num2= Integer.parseInt(input.substring(index1+1,index2));
			int num3= Integer.parseInt(input.substring(index2+1));
			
			total+= 2*num1*num2+2*num1*num3+2*num2*num3;
			
			if(num1<=num2 && num1<=num3){
				if(num2<num3){
					total+=num1*num2;
				}
				else{
					total+=num1*num3;
				}
			}
			else if(num2<=num1 && num2<=num3){
				if(num1<num3){
					total+=num1*num2;
				}
				else{
					total+=num2*num3;
				}
			}
			else{
				if(num1<num2){
					total+=num1*num3;
				}
				else{
					total+=num2*num3;
				}
			}
			
			System.out.println(total);			
			
		}
	}

}
