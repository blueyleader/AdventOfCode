package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day12_1 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day12.txt");
		Scanner scan = new Scanner(file);
		input=scan.nextLine();

		int total=0;
		String cur="";
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
