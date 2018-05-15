package com.restart.algorithm;

import java.util.Scanner;

public class BruteForce_Seven {
	static int total;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = 9;
		int[] hobits = new int[n];
		for ( int i = 0; i < n; i++ ) {
			hobits[i] = sc.nextInt();
			total += hobits[i];
		}
		
		//total - ( x난쟁이키  + y난쟁이키  ) = 100 인것을 찾는다 9명중에 2명은 범인.
		findFaker(hobits);
		
		for ( int i = 0; i < n-1; i ++ ) {
			for ( int j = i+1; j < n; j ++  ) {
				if ( hobits[i] > hobits[j] ) {
					//swap
					int temp = hobits[i];
					hobits[i] = hobits[j];
					hobits[j] = temp;
				}
			}
		}
		for ( int i = 2; i < n; i ++ ) {
			System.out.println(hobits[i]);
		}
		
		
	}
	private static void findFaker(int[] hobits) {
		// TODO Auto-generated method stub
		int n = hobits.length;
		for ( int i = 0; i < n-1; i ++ ) {
			for ( int j = i+1; j < n; j ++ ) {
				if ( ( total - ( hobits[i] + hobits[j] ) ) == 100 ) {
					hobits[i] = -1;
					hobits[j] = -1;
					return;
				}
			}
		}
	}
}
