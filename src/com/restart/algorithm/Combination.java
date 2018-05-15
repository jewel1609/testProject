package com.restart.algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class Combination {
	public static int[][] cashing;
	public static BigInteger[][] big;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		big = new BigInteger[n+1][k+1];
		for ( int i = 0 ; i < n+1; i ++ ) {
			for ( int j = 0;j < k+1; j ++ ) {
				big[i][j] = BigInteger.valueOf(-1);
			}
		}
		
		System.out.print(combination(n, k));
	}

	private static BigInteger combination(int n, int k) {
		// TODO Auto-generated method stub
		if ( n == k || k == 0 ) return BigInteger.valueOf(1);
		
		if ( big[n][k] != BigInteger.valueOf(-1) ) {
			return big[n][k];
		}
		
		return big[n][k] = combination(n-1, k-1).add(combination(n-1, k)) ;
	}

}
