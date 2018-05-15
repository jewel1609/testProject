package com.restart.algorithm;

import java.util.Scanner;

public class VoteAlpabet {
	public static String[] texts;
	public static int[] textCount = new int[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//대문자 아스키코드 65 ~ 90 
		//소문자 아스키코드 97 ~ 122 
		//97 - 32 = 65; 
		//소문자라면 아스키코드에서 32로 빼주어서 통일해준다. 
		String text = sc.nextLine();
		texts = text.split("");
		
		for ( String textN : texts ) {
			char textToChar = textN.charAt(0);
			int textNumber = (int) textToChar;
			if ( textNumber >= 97 && textNumber <= 122 ) {
				textNumber -= 32;
			}
			//해당 알파벳 카운트 추가 
			textCount[textNumber-65] += 1;
		}
		
		// 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
		int max = 0;
		for ( int selectTextCount : textCount ) {
			if ( selectTextCount > max ) {
				max = selectTextCount;
			}
		}
		
		int maxCount = 0;
		int maxNum = 0;
		for ( int i = 0 ; i < textCount.length; i ++ ) {
			if ( textCount[i] == max) {
				maxCount++;
				maxNum = i;
			}
		}
		if ( maxCount > 1 ) {
			System.out.println("?");
		}
		else if ( maxCount == 1 ) {
			System.out.println((char)(maxNum+65));
		}
		
		
		
	}
}
