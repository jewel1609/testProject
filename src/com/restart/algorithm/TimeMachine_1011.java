package com.restart.algorithm;

import java.util.Scanner;

public class TimeMachine_1011 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int t = 0; t < testCase; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			int distance = y - x;

			long ret = dp(distance, 1);

			System.out.println(ret);
		}
	}

	private static long dp(int distance, long n) {
		//거리가 멀어질수록 n제곱의 크기가 int값을 벗어난다.
		//그렇기때문에 long으로 받아야 한다. 
		// TODO Auto-generated method stub
		// 거리가
		// [n*n - n + 1 , n^2] 에 포함되면 최소워프는 2*n-1;
		// [n*n + 1, n*n + n ] 에 포함되 최소워프는 2*n;
		while (true) {
			if ((distance >= (n * n) - n + 1) && (distance <= (n * n + n))) {
				if ((distance >= n * n + 1) && (distance <= (n * n))) {
					return 2 * n - 1;
				} else {
					return 2 * n;
				}
			}
			n++;
		}
	}
}
