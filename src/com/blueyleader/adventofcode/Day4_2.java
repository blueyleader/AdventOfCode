package com.blueyleader.adventofcode;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day4_2 {

	public static void main(String[] args) throws Exception {
		File file = new File("day4.txt");
		Scanner scan = new Scanner(file);
		String input=scan.nextLine();
		String temp;
		int x=0;
		String out="1111111";
		MessageDigest md = MessageDigest.getInstance("MD5");
		while(!out.substring(0,6).equals("000000")){
			x++;
			temp=input+x;
			md.reset();
			md.update(temp.getBytes(),0,temp.length());	
			byte[] thedigest = md.digest();
			out=javax.xml.bind.DatatypeConverter.printHexBinary(thedigest);
			
			if(x/1000==(double)x/1000)
			{
				System.out.println(x);
			}
		}
		System.out.println(out);
		System.out.println(x);
	}

	
}
