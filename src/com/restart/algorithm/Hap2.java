package com.restart.algorithm;

import java.util.Scanner;

public class Hap2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		int sum = 0;
		for ( int i = 0; i < n; i ++ ) {
			sum += Integer.parseInt(str.charAt(i)+""); 
		}
		System.out.println(sum);
	} 
	

}
