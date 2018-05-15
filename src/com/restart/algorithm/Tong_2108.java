package com.restart.algorithm;

import java.util.Scanner;

public class Tong_2108 {
	public static int n;
	public static int[] nums;
	public static int[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//n은 홀수개. 중앙값 n/2 + 1
		n = sc.nextInt();
		nums = new int[n];
		count = new int[n];
		int sum = 0;
		for ( int i = 0; i < n; i ++ ) {
			nums[i] = sc.nextInt();
			sum += nums[i];
		}
		
		//nums 정렬
		arrayNums();
		
		StringBuffer sb = new StringBuffer();
		
		int middleNum = nums[n/2];
		
		int scale = nums[n-1] - nums[0]; 
		int searchNum = suchNum();
		
		
		sb.append(sum/n);
		sb.append("\n");
		sb.append(middleNum);
		sb.append("\n");
		sb.append(searchNum);
		sb.append("\n");
		sb.append(scale);
		
		System.out.println(sb);
		
	}
	private static int suchNum() {
		// TODO Auto-generated method stub
		for ( int index = 0; index < nums.length-1; index++ ) {
			count[index] += 1;
			for ( int next = index + 1; next < nums.length; next++ ) {
				if ( nums[index] == nums[next] ) {
					count[index] += 1;
				}
			}
		}
		
		//count Max값 찾기 중복되면 두번째 값 출력
		int max = count[0];
		for ( int i = 0 ; i < count.length-1; i ++ ) {
			for ( int j = i+1; j < count.length; j++) {
				if ( max == count[j] ) {
					return count[1];
				}
				else if ( count[i] < count[j] ) {
					max = count[j];
				}
			}
		}
		
		return max;
	}
	private static void arrayNums() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < n-1; i ++ ) {
			for ( int j = i+1; j < n; j++ ) {
				if ( nums[i] > nums[j] ) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
		
	}
		
}
