package com.restart.algorithm;

import java.util.Scanner;

public class AverageFaker {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] scores = new int[n];
		double[] fakeScores = new double[n];
		int maxScore = 0;
		for ( int i = 0; i < n; i ++ ) {
			scores[i] = sc.nextInt();
		}
		
		for ( int i = 0 ; i < n; i ++ ) {
			if ( scores[i] > maxScore ) maxScore = scores[i];  
		}
		//모든 점수를 점수/M*100으로 고쳤다.
		double sum = 0;
		for ( int i = 0; i < n; i ++ ) {
			fakeScores[i] = ((double)scores[i]/maxScore)*100;
			sum += fakeScores[i];
		}
		
		System.out.println(sum / scores.length);
		
		
		
		
	}

}
