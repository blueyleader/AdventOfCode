package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Day22_1 {

	
	public static int low,damage;

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("day22.txt");
		Scanner scan = new Scanner(file);
		low=Integer.MAX_VALUE;
		int hit;
		scan.next();
		scan.next();
		hit = scan.nextInt();
		//hit=14;
		scan.next();
		damage = scan.nextInt();
		//damage=8;
		rec(500,50,hit,new ArrayList<int[]>(),0);

		System.out.println(low);
		
	}
	
	public static void rec(int mana,int health,int hit,ArrayList<int[]> effects,int used){
		
		for(int x=effects.size()-1;x>=0;x--){
			if(effects.get(x)[0]==1){
				hit-=3;
			}
			else if(effects.get(x)[0]==2){
				mana+=101;
			}
			
			if(effects.get(x)[1]==0){
				effects.remove(x);
			}
			else{
				effects.get(x)[1]--;
			}
		}

		for(int x=0;x<5;x++){
			int curHealth=health,curHit = hit,curMana=mana,curUsed=used;
			ArrayList<int[]> curEffects=(ArrayList<int[]>) effects.clone();
			if(x==0){
				//Magic Missile
				if(mana>53){
					curMana-=53;
					curUsed+=53;
					curHit-=4;
				}
				else{
					continue;
				}
			}
			else if(x==1){
				//Drain
				if(mana>=73){
					curMana-=73;
					curUsed+=73;
					curHit-=2;
					curHealth+=2;
				}
				else{
					continue;
				}
			}
			else if(x==2){
				//Sheild
				if(mana>=113){
					curMana-=113;
					curUsed+=113;
					curEffects.add(new int[]{0,7});
				}
				else{
					continue;
				}
			}
			else if(x==3){
				//Poison
				if(mana>=173){
					curMana-=173;
					curUsed+=173;
					curEffects.add(new int[]{1,7});
				}
				else{
					continue;
				}
			}
			else if(x==4){
				//Recharge
				if(mana>=229){
					curMana-=229;
					curUsed+=229;
					curEffects.add(new int[]{2,6});
				}
				else{
					continue;
				}
			}	
			if(curHit<low){
				low=curHit;
			}
			if(curHit<1 && curUsed<low){
				low=curUsed;
			}
			if(curHealth>0 && curHit>0){
				rec2(curMana,curHealth,curHit,curEffects,curUsed);
			}
		}
	}
	
	public static void rec2(int mana,int health,int hit,ArrayList<int[]> effects,int used){
		int armor=0;
		for(int x=effects.size()-1;x>=0;x--){
			if(effects.get(x)[0]==0){
				armor+=7;	
			}
			else if(effects.get(x)[0]==1){
				hit-=3;
			}
			else if(effects.get(x)[0]==2){
				mana+=101;
			}
			
			if(effects.get(x)[1]==0){
				effects.remove(x);
			}
			else{
				effects.get(x)[1]--;
			}
		}
		
		if(hit<1 && used<low){
			low=used;
		}
		int num=damage-armor;
		if(num<1){
			num=1;
		}

		health-=num;
		

		if(health>0 && hit>0){
			rec(mana,health,hit,effects,used);
		}
		
	}
}

