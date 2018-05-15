package com.restart.algorithm;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for ( int testCase = 0; testCase < t; testCase++ ) {
			String ans ="no";
			int num = sc.nextInt();
			int reverseNum = reverse(num);
			int ret = num + reverseNum;
			int reverseRet = reverse(ret);
			
			if ( ret ==  reverseRet ) {
				ans = "yes";
			}
			
			System.out.println(ans);
		}
	}

	private static int reverse(int num) {
		// TODO Auto-generated method stub
		int reverseNum = 0;
		while( num != 0 ) {
			reverseNum = reverseNum * 10 + num % 10;
			num /= 10;
		}
		return reverseNum;
	}

}
