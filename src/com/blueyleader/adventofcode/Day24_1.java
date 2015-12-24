package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Day24_1 {

	public static ArrayList<ArrayList<Integer>> configs;
	public static int third,low;
	public static int[] data;
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day24.txt");
		Scanner scan = new Scanner(file);
		data = new int[30];
		configs= new ArrayList<ArrayList<Integer>>();
		int total=0;
		int x=0;
		while(scan.hasNextLine()){
			data[x]=scan.nextInt();
			total+=data[x];
			x++;
		}
		third=total/3;
		low=Integer.MAX_VALUE;
		rec(0,0,new ArrayList<Integer>(),0);
		
		/*for(x=0;x<configs.size();x++){
			if(min<configs.get(x).size()){
				min=configs.get(x).size();
			}
		}*/
		BigInteger quantum= new BigInteger("0");
		BigInteger big;//= new BigInteger("1");
		for(x=0;x<configs.size();x++){
			big = new BigInteger("1");
			if(low==configs.get(x).size()){
				for(int y=0;y<low;y++){
					big=big.multiply(BigInteger.valueOf(configs.get(x).get(y)));
				}
				if(big.compareTo(quantum)==-1){
					quantum=big;
				}
				if(quantum.intValue()==0){
					quantum=big;
				}
			}
		}
		System.out.println(quantum);
	}

	public static void rec(int index,int total,ArrayList<Integer> cur,int size){
		ArrayList<Integer> t;
		int temp;
		if(size>low)
			return;
		for(int x=index;x<data.length;x++){
			temp=total+data[x];
			if(temp<third){
				t=(ArrayList<Integer>) cur.clone();
				t.add(data[x]);
				rec(x+1,temp,t,size+1);
			}
			else if(temp==third){
				t=(ArrayList<Integer>) cur.clone();
				t.add(data[x]);
				configs.add(t);
				if(t.size()<low){
					low=t.size();
				}
			}
		}
	}
}
