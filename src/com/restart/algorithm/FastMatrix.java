package com.restart.algorithm;

import java.util.Scanner;

public class FastMatrix {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		int n = sc.nextInt();
		
		int result = fastMatrix(p, n);
		System.out.println(result);
		
	}

	private static int fastMatrix(int p, int n) {
		// TODO Auto-generated method stub
		if ( n == 0 ) return 1;
		
		if ( n % 2 > 0 ) return fastMatrix(p, n-1) * p;
		
		return fastMatrix(p, n/2) * fastMatrix(p, n/2);
	}

}
