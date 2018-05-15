package com.restart.algorithm;

import java.util.Scanner;

public class BeTheReader_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for ( int t = 0; t < testCase;  t ++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			int ret = countMember(k, n);
			
			System.out.println(ret);
		}
			
	}

	private static int countMember(int k, int n) {
		// TODO Auto-generated method stub
		//기저사례 0층 i호에는 i명이 산다.
		
		if ( k == 0 ) {
			return n;
		}
		
		k = k - 1;
		int sum = 0;
		for ( int i = 1; i <= n; i ++ ) {
			sum+=countMember(k, i);
		}
		
		return sum;
	}
}
