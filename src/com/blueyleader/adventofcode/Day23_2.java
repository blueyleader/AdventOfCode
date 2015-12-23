package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day23_2 {

	public static void main(String[] args) throws FileNotFoundException {
		String input;
		File file = new File("day23.txt");
		Scanner scan = new Scanner(file);
		String[][] data = new String[47][0];
		int[] reg= new int[2];
		reg[0]=1;
		int x=0;
		while(scan.hasNextLine()){
			data[x]=scan.nextLine().split(" ");
			x++;
		}
		
		x=0;
		while(x<data.length){	
			if(data[x][0].equals("hlf")){
				reg[data[x][1].charAt(0)-'a']/=2;
			}
			else if(data[x][0].equals("tpl")){
				reg[data[x][1].charAt(0)-'a']*=3;
			}
			else if(data[x][0].equals("inc")){
				reg[data[x][1].charAt(0)-'a']++;
			}
			else if(data[x][0].equals("jmp")){
				if(data[x][1].contains("+")){
					x+=Integer.parseInt(data[x][1].substring(1));
				}
				else{
					x-=Integer.parseInt(data[x][1].substring(1));
				}
				continue;
			}
			else if(data[x][0].equals("jie")){
				if(reg[data[x][1].charAt(0)-'a']%2==0){
					if(data[x][2].contains("+")){
						x+=Integer.parseInt(data[x][2].substring(1));
					}
					else{
						x-=Integer.parseInt(data[x][2].substring(1));
					}
					continue;
				}
				
			}
			else if(data[x][0].equals("jio")){
				if(reg[data[x][1].charAt(0)-'a']==1){
					if(data[x][2].contains("+")){
						x+=Integer.parseInt(data[x][2].substring(1));
					}
					else{
						x-=Integer.parseInt(data[x][2].substring(1));
					}
					continue;
				}			
			}
			else{
				break;
			}
			x++;
		}
		
		System.out.println(reg[1]);
	}

}
