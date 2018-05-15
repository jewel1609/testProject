package com.restart.algorithm;

import java.util.Scanner;

public class SugarGame {
	
	public static int BIG = 5;
	public static int SMALL = 3;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		int ret = solution(n);
		
		
		System.out.println(ret);
		
	}

	private static int solution(int n) {
		// TODO Auto-generated method stub
		int bigSu = n / BIG;
		
		while ( bigSu >= 0 ) {
			int temp = n - bigSu * BIG;
			if ( temp % SMALL == 0 ) {
				return bigSu + (temp/SMALL);
			}
			bigSu--;
		}
		return -1;
	}

}
