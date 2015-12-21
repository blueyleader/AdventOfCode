package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day19_1 {

	static int max,counter;
	static ArrayList<String> answers;
	static HashMap<String,String> map;
	static String out;
	public static void main(String[] args) throws FileNotFoundException {
		String input="";
		File file = new File("day19.txt");
		Scanner scan = new Scanner(file);
		map = new HashMap<String, String>();
		String temp[];
		ArrayList<String> atemp;
		answers = new ArrayList<String>();
		boolean flag=true;
		int count=0;
		max=Integer.MAX_VALUE;

		while(scan.hasNextLine()){
			input=scan.nextLine();
			if(input.equals("")){
				flag=false;
			}
			if(flag){
				temp=input.split(" ");
				map.put(temp[2], temp[0]);
			}
		count++;
		}
		out=input;
		rec(input,0);
		
		System.out.println(max);
		
	}
	
	
	/*public static void rec2(String in,int step){
		if(in.length()>out.length() || step>max)
			return;
		else if(in.equals(out)){
			if(step<max){
				max=step;
			}
		}
		
		char c=in.charAt(0);
		String cur=""+c;
		ArrayList<String> atemp;
		for(int x=1;x<in.length();x++){
			c=in.charAt(x);
			System.out.println(in);
			if((c>='A' && c<='Z') || c=='e'){
				atemp=map.get(cur);
				if(atemp!=null){
					for(int z=0;z<atemp.size();z++){
						String v1=in.substring(0,x-cur.length());
						String v2=atemp.get(z);
						String v3=in.substring(x);
						rec(v1+v2+v3,step+1);
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
				String v1=in.substring(0,in.length()-cur.length());
				String v2=atemp.get(z);
				rec(v1+v2,step+1);
			}
		}	
	}*/
	
	public static void rec(String in , int step){
		if(step>=max)
			return;
		else if(in.equals("e")){
			if(step<max){
				max=step;
			}
		}
		/*char c=in.charAt(0);
		String cur =""+c;
		String rep;
		ArrayList<String> atemp;*/
		System.out.println(in);
		for(int x=0;x<in.length();x++){
			
			for (HashMap.Entry<String, String> entry : map.entrySet())
			{
				if(in.indexOf(entry.getKey())==x){
					String v1=in.substring(0,x);
					String v2=in.substring(x+entry.getKey().length());
					rec(v1+entry.getValue()+v2,step+1);	
				}
			}		
		}
		
		/*rep=map.get(cur);
		if(rep!=null){
			String v1=in.substring(0,in.length()-cur.length());
			rec(v1+rep,step+1);
		}	*/
		
		
	}
	
}

