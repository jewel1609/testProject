package com.restart.algorithm;

import java.util.Scanner;

public class CountingText {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		text += " ";
		String[] texts = text.split("");
		int ret = 0;
		int countWord = 0;
		
		for ( int i = 0 ; i <texts.length;i ++ ) {
			//공백인경우 
			if ( texts[i].equals(" ") ) {
				if ( countWord != 0 ) {
					ret -= (countWord - 1);
					countWord = 0;
				}
			}
			//문자인경우 
			else {
				ret++;
				countWord++;
			}
		}
		
		System.out.println(ret);
		
		
	} 

}
