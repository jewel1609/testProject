package com.restart.algorithm;

import java.util.Scanner;

public class PrintSmallerNumber {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] numbers = new int[n];
		
		for ( int i = 0 ; i < n; i ++ ) {
			numbers[i] = sc.nextInt();
		}
		
		printSu(numbers, x ) ;
		
	}

	private static void printSu(int[] numbers, int x) {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < numbers.length; i ++ ) {
			if ( x > numbers[i] ) {
				System.out.print(numbers[i] + " ");
			}
		}
		
	}

}
