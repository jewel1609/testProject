package com.restart.algorithm;

import java.util.Scanner;

public class TextSubString {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String strs[] = str.split("");
		int size = str.length();
		
		textPrinting(strs, 0, 0);
		
		
	}

	private static void textPrinting(String[] strs, int index, int count) {
		// TODO Auto-generated method stub
		//기저사례 
		if ( index == strs.length) return;

		if ( count == 10 ) {
			count = 0;
			System.out.println();
		}
		//글자 출력
		System.out.print(strs[index]);
		index++;
		count++;
		
		textPrinting(strs, index, count);
		
		
	} 
	
	

}
