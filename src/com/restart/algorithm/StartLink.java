package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class StartLink {
	//14889
	static int n;
	static int[][] map;
	static int[] manNumber;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("startLink.txt") );
		n = sc.nextInt();
		manNumber = new int[n];
		map = new int[n][n];
		//맵 초기화 
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < n ; j ++ ) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//사람 번호 초기화 
		for ( int i = 0; i < n; i ++ ) {
			manNumber[i] = i+1;
		}
		
		dfs("1");
		System.out.println(min);
		
	}
	private static void dfs(String str) {
		// TODO Auto-generated method stub
		if ( str.length() == n ) {
			System.out.println(str);
			cal(str);
			return;
		}
		
		//완전 탐색 
		for ( int i = 1; i < n; i ++ ) {
			if ( manNumber[i] == -1 ) continue;
			
			int temp = manNumber[i];
			manNumber[i] = -1;
			String ch = temp + "";
			if ( temp == i+1) dfs( str + ch);
//			else if ( temp == 2 ) dfs(str + ch);
//			else if ( temp == 3 ) dfs(str + ch);
//			else if ( temp == 4 ) dfs(str + ch);
			
			manNumber[i] = temp;
			
		}
		
	}
	private static void cal(String str) {
		// TODO Auto-generated method stub
		int start = 0;
		int link = 0;
		//start
		for ( int i = 0 ; i < n/2-1 ; i ++ ) {
			for ( int next=i+1; next < n/2; next++ ) {
				start += map[Integer.parseInt(str.charAt(i)+"")-1][Integer.parseInt(str.charAt(next)+"")-1];
				start += map[Integer.parseInt(str.charAt(next)+"")-1][Integer.parseInt(str.charAt(i)+"")-1];
			}
		}
		
		//link
		for ( int i = n/2; i < n - 1  ; i ++ ) {
			for ( int next=i+1; next < n; next++ ) {
				link += map[Integer.parseInt(str.charAt(i)+"")-1][Integer.parseInt(str.charAt(next)+"")-1];
				link += map[Integer.parseInt(str.charAt(next)+"")-1][Integer.parseInt(str.charAt(i)+"")-1];
			}
		}
//		System.out.println(start +"스타");
//		System.out.println(link + "링크 ");
		int ret = start - link;
//		System.out.println(ret);
		if ( ret < 0 ) ret *= -1;
		
		if ( ret < min ) min = ret;
		
	}

}
