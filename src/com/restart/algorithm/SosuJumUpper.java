package com.restart.algorithm;

import java.util.Scanner;

public class SosuJumUpper {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int testCase = sc.nextInt();
		for ( int t = 0; t < testCase; t++ ) {
			int n = sc.nextInt();
			int[] scores = new int[n];
			int sum = 0;
			for ( int i = 0 ; i < scores.length; i ++ ) {
				scores[i] = sc.nextInt();
				sum += scores[i];
			}
			double average = sum / scores.length;
			
			printUpperAverage(average, scores);
		}
				
	}

	private static void printUpperAverage(double average, int[] scores) {
		// TODO Auto-generated method stub
		int n = scores.length;
		int successMan = 0;
		for ( int i = 0 ; i < n; i ++ ) {
			if ( average < scores[i] ) successMan++;
		}				
		double ret = (double)successMan/n;
		System.out.printf("%.3f%%\n", ret * 100);
		
	}
}
