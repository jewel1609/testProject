package com.algorithm.yeon;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int[] a = new int[n];
		
		for ( int i = 0 ; i < n; i ++ ) {
			a[i] = scan.nextInt();
		}
		
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		long count = 0;
		for ( int i = 0 ; i < a.length; i ++ ) {
			count += 1;
			a[i] -= b;
			if ( a[i]  < 0 ) a[i] = 0;
			
			count += a[i] / c;
			
			if ( a[i] % c != 0 ) {
				count += 1;
			}
				
		}
		
		System.out.println(count);
		
	}
		
	
}

	


