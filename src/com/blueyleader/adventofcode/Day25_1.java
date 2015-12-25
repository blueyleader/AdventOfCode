package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Day25_1 {

	public static ArrayList<ArrayList<Integer>> configs;
	public static int third,low;
	public static int[] data;
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day25.txt");
		Scanner scan = new Scanner(file);
		int x=1,y=1;
		int xMax=1;
		BigInteger num=BigInteger.valueOf(20151125);
		BigInteger mul=BigInteger.valueOf(252533);
		BigInteger mod=BigInteger.valueOf(33554393);
		
		input=scan.nextLine();
		int row=Integer.parseInt(input.substring(input.indexOf("row")+4, input.indexOf(",",input.indexOf("row")+4)));
		int column=Integer.parseInt(input.substring(input.indexOf("column")+7,input.lastIndexOf(".")));

		while(!(x==row && y==column)){
			
			num=num.multiply(mul);
			num=num.mod(mod);
						
			if(x==1){
				xMax++;
				x=xMax;
				y=1;
			}
			else{
				x--;
				y++;
			}
			
		}
		
		System.out.println(num);	
	}
}
