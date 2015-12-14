package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day13_1 {

	static int low;
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day13.txt");
		Scanner scan = new Scanner(file);
		int index,index2,index3,index4;
		String name1,name2,distance;
		String[] temp;
		HashMap<String,ArrayList<String[]>> map = new HashMap<String,ArrayList<String[]>>();
		while(scan.hasNextLine()){
			input=scan.nextLine();
			index=input.indexOf(' ');
			index2=input.lastIndexOf(' ');
			index3= input.indexOf(' ',input.indexOf(' ',index+1)+1)+1;
			index4=input.indexOf(' ',index3);
			name1 = input.substring(0, index);
			name2 = input.substring(index2+1,input.length()-1);
			distance = input.substring(index3,index4);
			if(!input.contains("gain")){
				distance='-'+distance;
			}
			ArrayList<String[]> v1 =map.get(name1);
			if(v1==null){
				v1= new ArrayList<String[]>();
			}
			temp=new String[2];
			temp[0]=name2;
			temp[1]=distance;
			v1.add(temp);
			map.put(name1, v1);
		}
		low=Integer.MIN_VALUE;
		String names="";
		int maxDepth=map.size();
		
		for (HashMap.Entry<String, ArrayList<String[]>> entry : map.entrySet())
		{
			ArrayList<String[]> v=entry.getValue();
			names=entry.getKey();
			rec(map,v,names,"",names,maxDepth,1,0);
			break;
		}
		System.out.println(low);
	}
	
	public static void rec(HashMap<String,ArrayList<String[]>> map,ArrayList<String[]> array,String names,String last,String me,int maxDepth,int depth,int total){
		int lastAdd=0;
		if(!last.equals("")){
			for(int y=0;y<array.size();y++){
				if(array.get(y)[0].equals(last)){
					lastAdd=Integer.parseInt(array.get(y)[1]);
					break;
				}
			}
		}
		
		for(int x=0;x<array.size();x++){
			String name=array.get(x)[0];
			if(!names.contains(name)){
				rec(map,map.get(name),names+" "+name,me,name,maxDepth,depth+1,total+Integer.parseInt(array.get(x)[1])+lastAdd);
			}
			else if(depth==maxDepth){
				String first = names.substring(0,names.indexOf(' '));
				int v1=0;
				int v2=0;
				ArrayList<String[]> t=map.get(first);
				for(int z=0;z<t.size();z++){
					if(t.get(z)[0].equals(me)){
						v1=Integer.parseInt(t.get(z)[1]);
						break;
					}
				}
				for(int y=0;y<array.size();y++){
					if(array.get(y)[0].equals(first)){	
						v2=total+Integer.parseInt(array.get(y)[1])+v1+lastAdd;
						if(v2>low){
							low=v2;
							break;
						}
					}	
				}
			}
		}	
	}
	
	

}

