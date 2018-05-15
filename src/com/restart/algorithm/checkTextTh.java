package com.restart.algorithm;

import java.util.Scanner;

public class checkTextTh {
	
	public static char[] ch;
	public static int[] chLocation = new int[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//단어는 무조건 소문자로만 주어진다.
		//a~z 아스키코드로 97 ~ 122 이다 . (int) 'a' ~ (int) 'z' 
		String text = sc.nextLine();
		
		//-1로 초기화 
		for ( int i =0 ; i < chLocation.length; i ++ ) {
			chLocation[i] = -1;
		}
		
		for ( int i = 0 ; i <text.length(); i ++ ) {
			for ( int j = 0 ; j < chLocation.length;j ++ ) {
				char ch = text.charAt(i);
				int chNumber = (int) ch - 97;
				if ( chLocation[chNumber] == -1 ) {
					chLocation[chNumber] = i;
				}
			}
		}
		
		for ( int i = 0 ; i < chLocation.length; i ++ ) {
			System.out.print(chLocation[i] + " ");
		}
		
	}
}
