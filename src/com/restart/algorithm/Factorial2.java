package com.restart.algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
//		System.out.println(fac(n));
		
		String[] nums = fac(n).toString().split("");
		int count = 0;
		for ( int i = nums.length-1; i>=0; i-- ) {
			if ( !nums[i].equals("0") ) {
				break;
			}
			count++;
		}
		System.out.println(count);
	}

	private static BigInteger fac(int n) {
		if (n == 0 || n == 1)
			return BigInteger.valueOf(1);

		return BigInteger.valueOf(n).multiply(fac(n - 1));
	}
}
