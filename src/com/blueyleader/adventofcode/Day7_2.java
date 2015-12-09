package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day7_2 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("day7.txt");
		Scanner scan = new Scanner(file);
		StringBuilder inputsb = new StringBuilder(scan.nextLine());
		while(scan.hasNextLine())
			inputsb.append('\t'+scan.nextLine());
		String inputOrg=inputsb.toString();		
		String input=inputOrg;
		boolean second=false;
		String cur;
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int index,index2,index3;
		boolean flag=true;
		String var1,var2,var3;
		int v1,v2,v3;
		while(flag){
			index=input.indexOf('\t');
			if(index==-1){
				index=input.length();
				flag=false;
			}
			cur=input.substring(0,index);
			
			var3 = cur.substring(cur.indexOf("->")+3,cur.length());
			try{
				if(cur.contains("AND")){
					index2=cur.indexOf(" AND");
					var1=cur.substring(0, index2);
					var2=cur.substring(index2+5, cur.indexOf(' ',index2+5));
					if(var1.equals("1")){
						v1=1;	
					}
					else{
						v1=map.get(var1);
					}
					v2=map.get(var2);
					v3=v1&v2;
					map.put(var3, v3);
					System.out.println(var3+ " "+v3);
				}
				else if(cur.contains("OR")){
					index2=cur.indexOf(" OR");
					var1=cur.substring(0, index2);
					var2=cur.substring(index2+4, cur.indexOf(' ',index2+4));
					
					v1=map.get(var1);
					v2=map.get(var2);
					v3=v1|v2;
					map.put(var3, v3);
					System.out.println(var3+ " "+v3);
				}
				else if(cur.contains("NOT")){
					var1=cur.substring(4,cur.indexOf(' ',4));
					v1=map.get(var1);                
					
					v3=~v1&65535;
					map.put(var3, v3);
					System.out.println(var3+ " "+v3);
				}
				else if(cur.contains("LSHIFT")){
					index2=cur.indexOf(" LSHIFT");
					var1=cur.substring(0, index2);
					
					v2=Integer.parseInt(cur.substring(index2+8, cur.indexOf(' ',index2+8)));
					v1=map.get(var1);
					v3=v1<<v2;
					map.put(var3, v3);
					System.out.println(var3+ " "+v3);
				}
				else if(cur.contains("RSHIFT")){
					index2=cur.indexOf(" RSHIFT");
					var1=cur.substring(0, index2);
					
					v2=Integer.parseInt(cur.substring(index2+8, cur.indexOf(' ',index2+8)));
					v1=map.get(var1);
					v3=v1>>v2;
					map.put(var3, v3);
					System.out.println(var3+ " "+v3);
				}
				else{
					if(!(second && var3.equals("b"))){
						try{
						v3=Integer.parseInt(cur.substring(0,cur.indexOf("->")-1));
						}
						catch(NumberFormatException e){
							v3=map.get(cur.substring(0,cur.indexOf("->")-1));
						}
						map.put(var3,v3);
						System.out.println(var3+ " "+v3);
					}
				}
			
			}
			catch(Exception e){
				//e.printStackTrace();
				input=input+"\t"+cur;
			}

			if(flag){
				input=input.substring(index+1);
			}		
			else{
				if(!second){
					int a=map.get("a");
					map = new HashMap<String,Integer>();
					map.put("b", a);
					input=inputOrg;
					flag=true;
					second=true;
				}
			}
		}

		System.out.println(map.toString());
	}

}
