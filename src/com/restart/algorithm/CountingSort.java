package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class CountingSort {
	public static int[] nums;
	public static int[] temp;
	public static int[] temp2;
	public static int[] result;
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		StringBuffer sb = new StringBuffer();
		int n = sc.nextInt();
		nums = new int[n];
		int max = 0;
		for ( int i = 0; i < n; i ++ ) {
			nums[i] = sc.nextInt();
			if ( max < nums[i] ) {
				max = nums[i];
			}
		}
		
		temp = new int[max];
		
		//카운팅 
		for ( int num : nums ) {
			temp[num-1] += 1;
		}
		
		
		//부분합 재귀로 생성 
//		psumTemp(max-1);
		temp2 = new int[max];
		for ( int i = 0 ; i < max; i ++ ) {
			if ( i == 0 ) temp2[i] = temp[i];
			else {
				temp2[i] = temp[i] + temp2[i-1];
			}
		}
		
		
//		for ( int i = 0 ; i < temp.length;i ++ ) {
//			System.out.println(temp2[i]);
//		}
//		
		result = new int[n];
		
		for ( int index = n-1; index >= 0; index-- ) {
			result [ temp2[ nums[index] - 1 ] - 1 ] = nums[index];
			temp2[ nums[index]- 1 ] -= 1;
		}
		
		for ( int i = 0 ; i < nums.length;i ++ ) {
			sb.append(result[i]);
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
//	private static int psumTemp(int index) {
//		// TODO Auto-generated method stub
//		//기저 사례 
//		if ( index == 0 ) return temp[index];
//		
//		return temp[index] += psumTemp(index-1);
//	}

}
