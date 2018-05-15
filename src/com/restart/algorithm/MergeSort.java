package com.restart.algorithm;

public class MergeSort {
	//머지 소트 
	public static int[] nums = { 3, 2, 1, 5, 6, 4};
	public static int[] temp;
	public static void main(String[] args) {
		int n = nums.length;
		temp = new int[n];
		mergeSort(0, n-1);
		
		
		for ( int i = 0 ; i < n ; i ++ ) {
			System.out.println(nums[i]);
		}
		
	}
	private static void mergeSort(int s, int e) {
		// TODO Auto-generated method stub
		
		if ( s>= e ) return;
		
		int m = (s+e)/2;
		mergeSort(s, m);
		mergeSort(m+1, e);
		
		int idx1 = s;
		int idx2 = m+1;
		int tempIdx = s;
		
		while ( idx1 <= m && idx2 <= e ) {
			if ( nums[idx1] < nums[idx2] ) temp[tempIdx++] = nums[idx1++];
			else temp[tempIdx++] = nums[idx2++];
		}
		
		if ( idx1 <= m ) {
			while ( idx1 <= m ) {
				temp[tempIdx++] = nums[idx1++];
			}
		}else {
			while ( idx2 <= e ) {
				temp[tempIdx++] = nums[idx2++];
			}
		}
		
		//쪼갠부분 nums에 다시 초기화 
		for ( int i = s ; i <= e ; i ++ ) {
			nums[i] = temp[i];
		}
		
	}

}
