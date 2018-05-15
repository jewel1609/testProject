package com.restart.algorithm;

import java.util.Scanner;

public class BruteForce_MakeNumberHap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int ret = checkMakeNumber(n);
		
		System.out.println(ret);
		
	}

	private static int checkMakeNumber(int n) {
		// TODO Auto-generated method stub
		
		for ( int i = 1; i < n; i ++ ) {
		
			//i의 분해합이 n과 같다면 i를 리턴 
			int hap = devideHap(i);
			if ( hap == n) {
				return i;
			}
		
		}
		
		//없다면 0을 리턴 
		return 0;
	}

	private static int devideHap(int number) {
		// TODO Auto-generated method stub
		int sum = number;
		int nmg = 0;
		int mok = 0;
		while ( true ) {
			mok = number / 10;
			nmg = number % 10;
			
			if ( mok == 0 ) {
				sum+= nmg;
				break;
			}
			sum += nmg;
			number /= 10;
		}
		
		return sum;
	}
}
