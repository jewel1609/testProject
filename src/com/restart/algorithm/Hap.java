package com.restart.algorithm;

import java.util.Scanner;

public class Hap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int ret = sum(n);
		
		System.out.println(ret);
		
	}

	private static int sum(int n) {
		// TODO Auto-generated method stub
		//기저사례
		if ( n == 1 ) return 1;
		
		return n + sum(n-1);
	} 
	
}
