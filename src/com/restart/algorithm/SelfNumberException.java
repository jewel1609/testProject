package com.restart.algorithm;

import java.util.ArrayList;
import java.util.Scanner;

public class SelfNumberException {
	public static int[] D = new int[10036];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//[1,10000)까지 생성자를 생성해서 배열에 담는다. 
		for ( int i = 1; i <= 10000; i ++ ) {
			D[dn(i)] = 1;
			if ( D[i] != 1 ) System.out.println(i);
		}
	}


	private static int dn(int n) {
		// TODO Auto-generated method stub
		int ret = n;
		if ( n >= 10000) {
			ret += n / 10000;
			n %= 10000;
		}
		if ( n >= 1000) {
			ret += n / 1000;
			n %= 1000;
		}
		if ( n >= 100) {
			ret += n / 100;
			n %= 100;
		}
		if ( n >= 10) {
			ret += n / 10;
			n %= 10;
		}
		return ret += n;
	}

}
