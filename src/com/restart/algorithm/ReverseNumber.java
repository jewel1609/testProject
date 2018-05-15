package com.restart.algorithm;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		String aToString = a +"";
		String bToString = b +"";
		String[] retA = new String[aToString.length()];
		String[] retB = new String[bToString.length()];
		String resultA = "";
		String resultB = "";
		for ( int i = 0; i < aToString.length(); i ++ ) {
			retA[i] = aToString.charAt(aToString.length()-1-i) + "";
			resultA += retA[i];
		}
		for ( int i = 0; i < bToString.length(); i ++ ) {
			retB[i] = bToString.charAt(bToString.length()-1-i) + "";
			resultB += retB[i];
		}
		int ret = 0;
		if ( Integer.parseInt(resultA) > Integer.parseInt(resultB) ) {
			ret = Integer.parseInt(resultA);
		}else {
			ret = Integer.parseInt(resultB); 
		}
		System.out.println(ret);
		
	}
}
