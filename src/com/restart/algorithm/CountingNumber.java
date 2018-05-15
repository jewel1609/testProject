package com.restart.algorithm;

import java.util.Scanner;

public class CountingNumber {
	public static int[] counting = new int[10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String number = (a * b * c) + "";
		int n = number.length();
		String[] numbers = new String[n];
		for ( int i = 0 ; i < n; i ++ ) {
			numbers[i] = number.charAt(i)+"";
		}
		
		for ( String countNumber : numbers) {
			
			int countNum = Integer.parseInt(countNumber+"");
			for ( int i = 0 ; i < counting.length; i ++ ) {
				if ( countNum == i ) {
					counting[i] += 1;
				}
			}
		}
		
		for ( int i = 0; i < counting.length; i ++ ) {
			System.out.println(counting[i]);
		}
		
		
	}
}
