package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Day12_2 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day12.txt");
		Scanner scan = new Scanner(file);
		input=scan.nextLine();
		Stack<Integer> stack = new Stack<Integer>();
		int[] dead = new int[1000];
		int index=0;
		int total=0;
		String cur="";
		
		int a = input.indexOf('{');
		int b = input.indexOf('}');
		
		while(a!=-1 || b!=-1){
			if(a<b){
				stack.add(a);
				a = input.indexOf('{',a);
			}
			else{
				
				int t=stack.pop();
				if(input.indexOf("red",t)<b){
					
				}
				b = input.indexOf('}',b);
			}
			
		}
		
		
		
		
		
		for(int x=0;x<input.length();x++){
			char c=input.charAt(x);
			if(c>47 && c<58){
				if(cur.equals("")){
					if(input.charAt(x-1)=='-')
						cur="-";
					}
				cur=cur+c;		
			}
			else if(!cur.equals("")){
				total+=Integer.parseInt(cur);
				cur="";
			}
		}
		
		System.out.println(total);
		
	}
}
//48-57
