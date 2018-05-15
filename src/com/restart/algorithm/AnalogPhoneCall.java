package com.restart.algorithm;

import java.util.Scanner;

public class AnalogPhoneCall {
	
	public static int[] numTime = { 11 , 2, 3, 4, 5, 6, 7, 8, 9, 10 };  
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//대문자 65~90 아스키코드 
		String text = sc.nextLine();
		char[] texts = text.toCharArray();
		// 해당문자열 아스키코드 -65 
		// 0~2 : 2  -> / 3 = 0; +2 
		// 3~5 : 3  -> / 3 = 1
		// 6~8 : 4
		// A~ O 까지는3 개씩
		//	PQRS  7번 ( 80 ~ 83)
		// tuv 8번    (84~ 86 )
		// wxyz  9   (87~ 90 )
		int ret = 0;
		for ( char ch : texts ) {
			int textNum = (int)ch - 65;
			int number = 0;
			int asciiNum = (int)ch;
			if ( asciiNum <= 79 ) {
				number = (textNum / 3) + 2;
			}else if ( asciiNum >= 80 && asciiNum <= 83 ) {
				number = 7;
			}else if ( asciiNum >= 84 && asciiNum <= 86 ) {
				number = 8;
			}else {
				number = 9;
			}
//			System.out.println((textNum / 3) + 2);
			
			ret += numTime[number];
		}
		
		System.out.print(ret);
		
		
	}
}
