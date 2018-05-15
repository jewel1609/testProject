package com.restart.algorithm;

import java.util.Scanner;

public class Fibonachi {
	static long[] cashing;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		cashing = new long[n+1];
		
		long ret = fibonachi(n);
		
		System.out.println(ret);
	}

	private static long fibonachi(int n) {
		// TODO Auto-generated method stub
		if ( n == 0 ) return 0;
		if ( n == 1 ) return 1;
		if ( cashing[n] != 0 ) { //연산을 한적이 있다면 
			return cashing[n]; //연산값을 되돌려주고 
		}
		//한적이 없다면 계산을 한다. 
		return cashing[n] = fibonachi(n-1) + fibonachi(n-2);
	}
}
