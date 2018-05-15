package com.restart.algorithm;

import java.util.Scanner;

public class DFSOperator {

	static int nums[];
	static int maxResult=0;
	static int minResult = 0x7fffffff;
	static int numCnt;
	public static void main(String[] args) throws Exception {
		
		maxResult = 0x7fffffff+1;
		minResult = 0x7fffffff;
		
		Scanner sc = new Scanner(System.in);
		numCnt = sc.nextInt();
		nums = new int[numCnt];
		int p,m,x,d;
		for ( int i = 0; i < numCnt ; i ++ ) {
			nums[i] = sc.nextInt();
		}
	    p = sc.nextInt();
	    m = sc.nextInt();
	    x = sc.nextInt();
	    d = sc.nextInt();
		
		
		dfs(nums[0],1,p,m,x,d);
		
		System.out.println(maxResult);
		System.out.println(minResult);
		
	}
	
	
	public static void dfs(int sum, int idx, int p,int m, int x, int d)
	{
		int nsum=0;
		if(idx==numCnt){
			//System.out.println(sum);
			if(maxResult < sum) maxResult = sum;
			if(minResult>sum) minResult = sum;
			return;
		}
		if ( x > 0 ) {
			nsum = sum * nums[idx];
			dfs( nsum, idx+1, p,m,x-1,d);
			
		}
		
		if ( p > 0 ) {
			nsum = sum + nums[idx];
			dfs( nsum, idx+1, p-1,m,x,d);
		}
		
		if ( m > 0 ) {
			nsum = sum - nums[idx];
			dfs( nsum, idx+1, p,m-1,x,d);
		}
				
		if ( d > 0 ) {
			sum = sum / nums[idx];
			dfs( sum, idx+1, p,m,x,d-1);
		}
		return;
	}
}
