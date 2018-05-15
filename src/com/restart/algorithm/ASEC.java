package com.restart.algorithm;

import java.util.Scanner;

public class ASEC {
	public static int[] nums;
	public static void main(String[] args) {
		
		Scanner sc =  new Scanner(System.in);
		int n = sc.nextInt();
		nums = new int[n];
		for ( int i = 0 ; i < n; i ++ ) {
			nums[i] = sc.nextInt();
		}
		
		//오름차순으로 정렬하기 
		asecArr();
		
		for ( int i = 0 ; i < n; i ++ ) {
			System.out.println(nums[i]);
		}
		
	}
	private static void asecArr() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < nums.length-1; i ++ ) {
			for ( int j = i+1 ; j < nums.length;j ++ ) {
				if ( nums[i] > nums[j] ) {
					//swap
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
			
		}
		
	}
}
