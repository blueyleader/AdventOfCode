package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day9_2 {

	static int low;
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day9.txt");
		Scanner scan = new Scanner(file);
		int index,index2;
		String name1,name2,distance;
		String[] temp;
		HashMap<String,ArrayList<String[]>> map = new HashMap<String,ArrayList<String[]>>();
		while(scan.hasNextLine()){
			input=scan.nextLine();
			index=input.indexOf(' ');
			index2=input.indexOf('=');
			name1 = input.substring(0, index);
			name2 = input.substring(index+4,index2-1);
			distance = input.substring(index2+2);
			ArrayList<String[]> v1 =map.get(name1);
			if(v1==null){
				v1= new ArrayList<String[]>();
			}
			temp=new String[2];
			temp[0]=name2;
			temp[1]=distance;
			v1.add(temp);
			map.put(name1, v1);
			
			ArrayList<String[]> v2 =map.get(name2);
			if(v2==null){
				v2= new ArrayList<String[]>();
			}
			temp=new String[2];
			temp[0]=name1;
			temp[1]=distance;
			v2.add(temp);
			map.put(name2, v2);
		}
		low=0;
		String names="";
		int maxDepth=map.size();
		for (HashMap.Entry<String, ArrayList<String[]>> entry : map.entrySet())
		{
			ArrayList<String[]> v=entry.getValue();
			names=entry.getKey();
			rec(map,v,names,maxDepth,1,0);
		    //System.out.println(entry.getKey() + "/" + entry.getValue());
		}
		System.out.println(low);
	}
	
	public static void rec(HashMap<String,ArrayList<String[]>> map,ArrayList<String[]> array,String names,int maxDepth,int depth,int total){
		for(int x=0;x<array.size();x++){
			String name=array.get(x)[0];
			if(!names.contains(name)){
				rec(map,map.get(name),names+name,maxDepth,depth+1,total+Integer.parseInt(array.get(x)[1]));
			}
			else if(depth==maxDepth && total>low){
				low=total;
			}
		}	
	}
	
	

}

