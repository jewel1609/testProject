package com.baekjoon.yeon.exam;

import java.util.Scanner;

public class NHN002 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = 0;
		
		n = scan.nextInt();
		int arr[][] = new int[n][n];
		int reverseArr[][] = new int[n][n];
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0 ; j < n; j ++ ) {
				arr[i][j] = scan.nextInt();
			}
		}
		reverseArr(arr, reverseArr);
		printArr(reverseArr);
		
		
		
	}

	private static void reverseArr(int[][] arr, int[][] reverseArr) {
		// TODO Auto-generated method stub
		for ( int i = 0; i < arr.length; i ++ ) {
			for ( int j = 0 ; j < arr.length; j ++ ) {
				reverseArr[i][j] = arr[j][i];
			}
		}
		
	}

	private static void printArr(int[][] arr) {
		// TODO Auto-generated method stub
		for ( int i = 0; i < arr.length; i ++ ) {
			for ( int j = 0 ; j < arr.length; j ++ ) {
				if ( j == arr.length-1 ) {
					System.out.print(arr[i][j]);
				}
				else {
					System.out.print(arr[i][j]+ " ");
				}
			}
			System.out.println();
		}
	}

}
