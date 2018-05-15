package com.restart.algorithm;

import java.util.Scanner;

public class OXGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		sc.nextLine();
		
		for ( int t = 0 ; t < testCase; t ++ ) {
			String str = sc.nextLine();
			
			String[] texts = str.split("");
			int totalScore = 0;
			int score = 0;
			for ( String text : texts ) {
				if ( text.equals("X") ) {
					score = 0;
					continue;
				}
				score += 1;
				totalScore += score;
			}
			System.out.println(totalScore);
		}//end 
	}

}
