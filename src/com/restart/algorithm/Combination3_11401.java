package com.restart.algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class Combination3_11401 {
	public static BigInteger[][] cashing;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		//캐싱 초기화 
		cashing = new BigInteger[n+1][k+1];
		for ( int i = 0; i < n+1; i ++ ) {
			for ( int j = 0 ; j < k +1 ;j ++ ) {
				cashing[i][j] = BigInteger.valueOf(-1);
			}
		}
		
		System.out.println(combination(n, k));
	}

	private static BigInteger combination(int n, int k) {
		// TODO Auto-generated method stub
		//기저 사례 
		if ( n == k || k == 0 ) {
			return BigInteger.valueOf(1);
		}
		
		//메모이제이션 
		if ( cashing[n][k] != BigInteger.valueOf(-1) ) return cashing[n][k];
		
		return cashing[n][k] = combination(n-1, k-1 ).add(combination(n-1, k));
	}
}
