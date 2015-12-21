package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day21_2 {

	public static final int[][] item ={{8,4,0,10,5,0,25,6,0,40,7,0,74,8,0},{13,0,1,31,0,2,53,0,3,75,0,4,102,0,5},{25,1,0,50,2,0,100,3,0,20,0,1,40,0,2,80,0,3}};
	
	public static int low;
	public static int hit,damage,armor;
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("day21.txt");
		Scanner scan = new Scanner(file);
		low=0;
		
		scan.next();
		scan.next();
		hit = scan.nextInt();
		
		scan.next();
		damage = scan.nextInt();
		
		scan.next();
		armor = scan.nextInt();
		
		rec(0,0,0,0,0);

		System.out.println(low);
		
	}
	
	public static void rec(int gold,int dam,int arm,int type,int not){
		if(type==0){
			for(int x=0;x<item[0].length;x+=3){
				rec(item[0][x],item[0][x+1],0,1,0);
			}
		}
		if(type==1){
			for(int x=0;x<item[1].length;x+=3){
				rec(gold+item[1][x],dam,item[1][x+2],2,0);
			}
			rec(gold,dam,0,2,0);
		}
		if(type==2){
			for(int x=0;x<item[2].length;x+=3){
				rec(gold+item[2][x],dam+item[2][x+1],arm+item[2][x+2],3,x);
			}
			rec(gold,dam,arm,3,-1);
		}
		if(type==3){
			for(int x=0;x<item[2].length;x+=3){
				if(x!=not){
					rec(gold+item[2][x],dam+item[2][x+1],arm+item[2][x+2],4,0);
				}
			}
			rec(gold,dam,arm,4,0);
		}
		if(type==4){
			int health=100;
			int bhealth=hit;
			int num;
			while(health>0 && bhealth>0){
				num = dam-armor;
				if(num<1){
					num=1;
				}
				bhealth-=num;
				
				num = damage-arm;
				if(num<1){
					num=1;
				}
				health-=num;
				if(health<1 && gold>low){
					low=gold;
				}
			}
		}	
	}	
}

