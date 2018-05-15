package com.restart.algorithm;

import java.util.Scanner;

public class FastSum {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int result = factorial(n);
		
		System.out.println(result);
		
		
	}

	//한조각을 떼어나고 나머지 조각을 재귀함수로 만들어낸다.
	private static int fastSum2(int n) {
		// TODO Auto-generated method stub
		if ( n == 1 ) return 1;
		
		return fastSum2(n-1) + n;
	}
	
	private static int factorial(int n ) {
		if ( n == 1 ) return 1;
		
		return factorial(n-1) * n;
	}

	private static int fastSum(int n) {
		// TODO Auto-generated method stub
		if ( n == 1 ) return 1;
		if ( n % 2 == 1 ) return fastSum(n-1) + n;
		return 2*fastSum(n/2) + ((n/2)*(n/2));
	}
}
