package com.restart.algorithm;

import java.util.Scanner;

public class AverageScore {
	public static int[] score = new int[5];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for ( int i = 0 ; i < score.length;i ++ ) {
			score[i] = sc.nextInt();
			if ( score[i] < 40 ) {
				score[i] = 40;
			}
			sum += score[i];
		}
		
		System.out.println(sum/score.length);
		
	}
}
