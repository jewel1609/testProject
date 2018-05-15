package com.restart.algorithm;

import java.util.Scanner;

public class MergeSort_2751 {
	public static int[] nums;
	public static int[] temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		nums = new int[n];
		temp = new int[n];
		for ( int i = 0 ; i < n; i ++ ) {
			nums[i] = sc.nextInt();
		}
				
		mergeSort(0, n-1);
		
		for ( int i = 0; i < nums.length; i ++ ) {
			System.out.println(nums[i]);
		}
		
		
		
	}
	private static void mergeSort(int left, int right) {
		// TODO Auto-generated method stub
		int mid;
		
		if ( left < right ) {
			mid = (left + right) / 2;
			
			//분할 
			mergeSort(left, mid);
			mergeSort(mid+1, right);
			//병합 
			merge(left, mid, right);
			
		}
	}
	private static void merge(int left, int mid, int right) {
		// TODO Auto-generated method stub
		
		//인덱스 
		int k = left;
		//왼쪽 인덴스 
		int i = left;
		//오른쪽 인덱스 
		int j = mid+1;
		
		while ( i <= mid && j <= right) {
			if ( nums[i] < nums[j] ) {
				temp[k] = nums[i];
				i++;
			}else {
				temp[k] = nums[j];
				j++;
			}
			k++;
		}
		
		if ( i > mid ) {
			for ( int m = j; m <= right; m++ ) {
				temp[k] = nums[m];
				k++;
			}
		} else {
			for ( int m = i; m <= mid; m ++ ) {
				temp[k] = nums[m];
				k++;
			}
		}
		
		//병합한 부분만큼 초기화 
		for ( int m = left ; m <= right;  m++ ) {
			nums[m] = temp[m];
		}
		
	}
	

}
