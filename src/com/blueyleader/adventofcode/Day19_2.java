package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day19_2 {

	static int max,c;
	static ArrayList<String> answers;
	static HashMap<String,ArrayList<String>> map;
	public static void main(String[] args) throws FileNotFoundException {
		String input="";
		File file = new File("day19.txt");
		Scanner scan = new Scanner(file);
		boolean [][] data = new boolean[100][100];
		map = new HashMap<String, ArrayList<String>>();
		String temp[];
		ArrayList<String> atemp;
		answers = new ArrayList<String>();
		boolean flag=true;
		int count=0;
		max=150;
		c=0;
		while(scan.hasNextLine()){
			input=scan.nextLine();
			if(input.equals("")){
				flag=false;
			}
			if(flag){
				temp=input.split(" ");
				if(!map.containsKey(temp[0])){
					map.put(temp[0], new ArrayList<String>());
				}
				atemp=map.get(temp[0]);
				atemp.add(temp[2]);
				map.put(temp[0],atemp);
			}
		count++;
		}
		
		String cur="";
		String out="";
		ArrayList<String> v= new ArrayList<String>();
		//answers.add("");
		char c;
		c=input.charAt(0);
		cur=""+c;
		for(int x=1;x<input.length();x++){
			c=input.charAt(x);
			//System.out.println(x+ ": "+answers.size());
			if((c>='A' && c<='Z') || c=='e'){
				atemp=map.get(cur);
				if(atemp!=null){
					for(int z=0;z<atemp.size();z++){
						String v1=input.substring(0,x-cur.length());
						String v2=atemp.get(z);
						String v3=input.substring(x);
						answers.add(v1+v2+v3);
					}
				}				
				cur=""+c;
			}
			else{
				cur+=c;
			}
		}
		atemp=map.get(cur);
		if(atemp!=null){
			for(int z=0;z<atemp.size();z++){
				String v1=input.substring(0,input.length()-cur.length());
				String v2=atemp.get(z);
				answers.add(v1+v2);
			}
		}				
		
		ArrayList<String> answers2 = new ArrayList<String>();
		count=0;
		for(int x=0;x<answers.size();x++){
			flag=false;
			if(!answers2.contains(answers.get(x))){
				answers2.add(answers.get(x));
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
}

