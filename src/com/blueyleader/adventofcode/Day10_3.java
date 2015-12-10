package com.blueyleader.adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10_3 {

	private static Pattern pattern = Pattern.compile("([0-9])(\\1*)");

	public static String folder(String num) {
	    Matcher m = pattern.matcher(num);

	    StringBuilder newNum = new StringBuilder();
	    while (m.find()) {
	        int length = (m.group(2) != null) ? m.group(2).length() + 1 : 1;
	        newNum.append(length + m.group(1));
	    }
	    return newNum.toString();
	}

	public static void main(String[] args) {
	    String num = "1113122113";
	    for (int i = 0; i < 40; i++) {
	        num = folder(num);
	    }
	    System.out.println(num.length());
	}
	
	
	

}

