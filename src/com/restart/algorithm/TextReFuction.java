package com.restart.algorithm;

import java.util.Scanner;

public class TextReFuction {
	public static String[] texts;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for ( int t = 0 ; t < testCase; t++ ) {
			int n = sc.nextInt();
			String text = sc.nextLine();
			text = text.trim();
			texts = text.split("");
			textReFuction(n);
			
		}
		
	}

	private static void textReFuction(int n) {
		// TODO Auto-generated method stub
		int totalLength = n * texts.length;
		String newText = "";
		while ( totalLength != newText.length() ) {
			for ( String text : texts ) {
				for ( int i = 0 ; i < n; i ++ ) {
					newText += text;	
				}
			}
		}
		System.out.println(newText);
	}

}
