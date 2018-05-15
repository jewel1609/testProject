package com.restart.algorithm;

import java.util.Scanner;

public class MaxTrain {
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ret = 0;
		for ( int i = 0 ; i < 4; i++ ) {
			int out = sc.nextInt();
			int in = sc.nextInt();
			
			ret = stateCount(out, in, ret);
			
			if ( max < ret ) max = ret;
		}
		
		System.out.println(max);
	}
	private static int stateCount(int out, int in, int ret) {
		// TODO Auto-generated method stub
		ret -= out;
		ret += in;
		
		return ret;
	}
}
