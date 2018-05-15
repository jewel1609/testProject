package com.restart.algorithm;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ret = fac(n);
		System.out.println(ret);
	}

	private static int fac(int n) {
		if (n == 0)
			return 1;

		return n * fac(n - 1);
	}
}
