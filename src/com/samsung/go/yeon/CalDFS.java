package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Scanner;

public class CalDFS {
	static int n;
	static int[] nums;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("calGame.txt"));
		
		n = sc.nextInt();
		nums = new int[n];
		for ( int i = 0 ; i < n;  i ++ ) {
			nums[i] = sc.nextInt();
		}
		
		int plus = sc.nextInt();
		int minus = sc.nextInt();
		int multiple = sc.nextInt();
		int divide = sc.nextInt();
		
		dfs ("", plus, minus, multiple, divide);
		
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(String str, int plus, int minus, int multiple, int divide) {
		// TODO Auto-generated method stub
		
		if ( str.length() == n-1 ) {
//			System.out.println(str);
			int sum = nums[0];
			//계산 
			for ( int i = 1, j=0 ; i < n ; i ++ ) {
				if ( str.charAt(j) == '+' ) {
					sum = sum + nums[i];
					j++;
				}else if ( str.charAt(j) == '-') {
					sum = sum - nums[i];
					j++;
				}else if ( str.charAt(j) == '*' ) {
					sum = sum * nums[i];
					j++;
				}else if ( str.charAt(j) == '/' ) {
					sum = sum / nums[i];
					j++;
				}
			}//end for
			
			if ( sum > max ) max = sum;
			if ( sum < min ) min = sum;
			
			return;
		}else {
			
			if ( plus > 0 ) {
				dfs(str+"+", plus-1, minus, multiple, divide);
			}
			if ( minus > 0 ) {
				dfs(str+"-", plus, minus-1, multiple, divide);
			}
			if ( multiple > 0 ) {
				dfs(str+"*", plus, minus, multiple-1, divide);
			}
			if ( divide > 0 ) {
				dfs(str+"/", plus, minus, multiple, divide-1);
			}
			
		}
	}
}
