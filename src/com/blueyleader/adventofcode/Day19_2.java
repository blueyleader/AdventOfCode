package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day19_2 {

    public static String replace(String s, String in, String out, int position) {
        return s.substring(0, position) + out + s.substring(position + in.length());
    }
    public static void main(String[] args) throws FileNotFoundException {
		String input="";
		File file = new File("day19.txt");
		Scanner scan = new Scanner(file);
		
		ArrayList<String[]> array = new ArrayList<String[]>();
		boolean flag=true;
		while(scan.hasNextLine()){
			input=scan.nextLine();
			if(input.equals("")){
				flag=false;
			}
			if(flag){
				String[] temp=input.split(" ");
				array.add(new String[]{temp[0],temp[2]});
			}
		}
 
        List<String> output = new ArrayList<>();

        int count2 = 0;
        while(!input.equals("e")) {
            for (String[] each : array) {
                if (input.contains(each[1])) {
                    input = replace(input, each[1], each[0], input.lastIndexOf(each[1]));
                    count2++;
                }
            }
        }
        System.out.println(count2);
    }
}