package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Day16_1 {

	static int low;
	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day16.txt");
		Scanner scan = new Scanner(file);
		int [] data = new int[]{3,7,2,3,0,0,5,3,2,1};
		int count,index,index2,index3,index4,index5;
		count=0;
		boolean flag=true;
		while(scan.hasNextLine()){
			input=scan.nextLine();
			flag=true;
			count=0;
			while(flag){
				if(input.contains("children")){
					index=input.indexOf("children")+10;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[0]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-10)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				else if(input.contains("cats")){
					index=input.indexOf("cats")+6;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[1]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-6)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				else if(input.contains("samoyeds")){
					index=input.indexOf("samoyeds")+10;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[2]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-10)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				else if(input.contains("pomeranians")){
					index=input.indexOf("pomeranians")+13;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[3]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-13)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				else if(input.contains("akitas")){
					index=input.indexOf("akitas")+8;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[4]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-8)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				else if(input.contains("vizslas")){
					index=input.indexOf("vizslas")+9;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[5]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-9)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				else if(input.contains("goldfish")){
					index=input.indexOf("goldfish")+10;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[6]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-10)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				else if(input.contains("trees")){
					index=input.indexOf("trees")+7;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[7]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-7)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				else if(input.contains("cars")){
					index=input.indexOf("cars")+6;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[8]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-6)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				else if(input.contains("perfumes")){
					index=input.indexOf("perfumes")+10;
					index2=input.indexOf(',',index);
					if(index2==-1){
						index2=input.length();
					}
					if(data[9]==Integer.parseInt(input.substring(index, index2))){
						count++;
						input=input.substring(0,index-10)+input.substring(index2);
					}
					else{
						flag=false;
					}
				}
				
				if(count==3){
					System.out.println(input);
					flag=false;
				}
				
			}
			
			
		}
		
		
	}

}

