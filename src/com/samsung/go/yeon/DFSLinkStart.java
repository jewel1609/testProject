package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Scanner;

public class DFSLinkStart {
	static int n;
	
	static int[] team1;
	static int[] team2;
	static int min = 0x7fffffff;
	static int[][] S;
	
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("linkStart.txt"));
		
		n = sc.nextInt();
		S = new int[n][n];
		
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0 ; j < n;j ++ ) {
				S[i][j] = sc.nextInt();
			}
		}
		
		dfs("", 0, 0);
		System.out.println(min);
	}

	private static void dfs(String str, int start, int link) {
		// TODO Auto-generated method stub
		
		if ( str.length() == n ) {
//			System.out.println(str);
			team1 = new int[n/2];
			team2 = new int[n/2];
			for ( int i = 0, idx1 = 0, idx2 = 0; i < n; i++ ) {
				if ( str.charAt(i) == '1' ) {
					team1[idx1++] = i;
				}else {
					team2[idx2++] = i;
				}
			}
			int sum1 = 0;
			int sum2 = 0;
			for ( int i = 0 ; i < n/2; i ++ ) {
				for ( int j = 0 ; j < n/2 ; j ++ ) {
					if ( i==j ) continue;
					sum1 += S[team1[i]][team1[j]];
					sum2 += S[team2[i]][team2[j]];
				}
			}
//			System.out.println(sum1+","+sum2);
			int ret = sum1 - sum2;
			if ( ret < 0 ) ret = ret * (-1);
			if ( min > ret ) min = ret;
			
			return;
		}else {

			if ( start < n/2 ) dfs(str+"1", start+1, link);
			if ( link < n/2 ) dfs(str+"2", start, link+1);
		}
	}
}
