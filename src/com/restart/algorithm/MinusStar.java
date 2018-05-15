package com.restart.algorithm;

import java.util.Scanner;

public class MinusStar {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			if (i >= 2) {
				for (int j = 1; j <= i-1; j++) {
					System.out.print(" ");
				}
			}

			for (int k = i; k <= n; k++) {
				System.out.print("*");
			}

			System.out.println();
		}

	}
}
