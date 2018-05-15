package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Scanner;

public class Saumsung07 {
	
	static int ans = 0;
	static int[] t = new int[20];
	static int[] p = new int[20];
	static int n;
	
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		//상담가능한 일자 
		n = sc.nextInt();
		
		for ( int i = 0; i < n; i ++ ) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		
		go(0,0);
		
		//최대 이익 출력하기 
		System.out.println(ans);
	}

	private static void go(int x, int sum) {
		// TODO Auto-generated method stub
		if ( x == n ) {
			if ( ans < sum ) ans = sum;
			return;
		}
		if ( x > n ) return;
		
		go(x+1, sum);
		go(x+t[x], sum+p[x]);
		
	}


}
