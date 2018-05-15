package com.restart.algorithm;

import java.util.Scanner;

public class SmartStar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		star_print(n);
	}
 
	public static void star_print(int line) {
		int n = line;
		int k;
		int height;
		k = (int)(Math.log(n / 3) / Math.log(2) + 1);
		String[] arr = new String[n];
 
		arr[0] = "  *  ";
		arr[1] = " * * ";
		arr[2] = "*****";
		height = 3;
 
		for (int i = 1; i < k; i++) {
			for (int j = 0; j < height; j++) {
				arr[height + j] = arr[j] + " " + arr[j];
				for (int m = 0; m < height / 3; m++) {
					arr[j] = "   " + arr[j] + "   ";
				}
			}
			height = 2 * height;
		}
 
		for (int i = 0; i < height; i++) {
			System.out.println(arr[i]);
		}
	}
}