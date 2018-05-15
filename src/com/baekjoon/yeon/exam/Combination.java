package com.baekjoon.yeon.exam;

import java.util.Scanner;

public class Combination {
	private static int min = 1000000000;
	private static int max = 0;

	public static void main(String[] args) {
		int[] arr = new int[3];
//		combination(arr, 0, 3, 2, 0);
		Scanner scan = new Scanner(System.in);
		for ( int i = 0 ; i < arr.length; i ++ ) {
			arr[i] = scan.nextInt();
		}
		
		
//		int num = factorial(3);
//		System.out.println(num);
		
		perm(arr, 0, 3, 3);
		System.out.println(max + "--");
		System.out.println(min + "--");
		System.out.println((min+max) + "--");
		
	}

	public static void combination(int[] arr, int index, int n, int r, int target) {
		if (r == 0)
			print(arr, index);
		else if (target == n)
			return;
		else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}// end combination()

	public static void print(int[] arr, int length) {
		for (int i = 0; i < length; i++)
			System.out.print(arr[i]);
		System.out.println("");
	}

	public static int combinationTwo(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			return combinationTwo(n - 1, r - 1) + combinationTwo(n - 1, r);
	}

	public static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static void perm(int[] arr, int depth, int n, int k) {
		if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
			print(arr);
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}

	private static void print(int[] arr) {
		// TODO Auto-generated method stub
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			str += arr[i]+"";
		}
		System.out.println();
		if ( min  > Integer.parseInt(str) ) {
			min = Integer.parseInt(str);
		}
		if ( max < Integer.parseInt(str) ) {
			max = Integer.parseInt(str);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
