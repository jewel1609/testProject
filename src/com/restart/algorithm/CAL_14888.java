package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CAL_14888 {
	static int n;
	static int[] nums;
	static int[] op;
	static int min = Integer.MAX_VALUE;
	static int max = -min;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("cal148.txt"));
		
		n = sc.nextInt();
		nums = new int[n];
		op = new int[n-1];
		
		
		//숫자 등록 
		for ( int i = 0 ; i < n ; i ++ ) {
			nums[i] = sc.nextInt();
		}
		int idx = 0;
		//부호 등록 
		for ( int i = 0 ; i < 4 ; i ++ ) {
			int calCount = sc.nextInt();
			if ( calCount == 0 ) continue;		
			while ( calCount > 0 ) {
				op[idx] = i;
				idx++;
				calCount--;
			}
		}
		
//		//부호확인  0 0 1 2 3
//		for ( int i = 0 ; i < op.length; i ++ ) {
//			System.out.println(op[i]);
//		}
		
		dfs("");
		System.out.println(max);
		System.out.println(min);
		
	}
	private static void dfs(String str) {
		// TODO Auto-generated method stub
		if ( str.length() == n-1 ) {
			System.out.println(str);
			cal(str);
			return;
		}
		
		for ( int i = 0 ; i < n-1 ; i ++ ) {
			if ( op[i] == -1 ) continue;
			int dir = op[i];
			op[i] = -1;
			
			if ( dir == 0 ) dfs(str + "+");
			else if ( dir == 1 ) dfs(str + "-");
			else if ( dir == 2 ) dfs(str + "*");
			else dfs(str + "/");
			
			op[i] = dir;
		}
	}
	private static void cal(String str) {
		// TODO Auto-generated method stub
		int result = nums[0];
		
		for ( int i = 0; i < n-1 ; i ++ ) {
			char ch = str.charAt(i);
			int b = nums[i+1];
			if ( ch == '+' ) result += b;
			else if ( ch == '-') result -= b;
			else if ( ch == '*') result *= b;
			else result /= b;
			
		}
		if ( result > max ) max = result;
		if ( result < min ) min = result;
		
	}
}
