package com.restart.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CaingCalendar {
	
	public static int M;
	public static int N;
	public static long x;
	public static long y;
	public static boolean temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for ( int t = 0; t < testCase; t ++ ) {
			M = sc.nextInt();
			N = sc.nextInt();
			
			x = sc.nextInt();
			y = sc.nextInt();
			int max = gcdlcm(M,N);
//			System.out.println(max);
			long ret = caingCal(max, 1, 1, 1);
			
			System.out.println(ret);
			
		}
	}

	private static long caingCal(int max, long startX, long startY, long k) {
		// TODO Auto-generated method stub
		//기저 사례
		long temp = 0;
//		System.out.println(max);
		if ( startX == x && startY == y  ) return k;
		startY = y;
		while( y <= max ) {
//			System.out.println(x + " ," + y);
			startY += y;
			k = startY;
			if ( ( startY % M ) == x ) {
				return startY;
//				System.out.println(temp);
//				System.out.println("야호 ");
			}
		}

		return -1;
		
	}
	
	private static int gcdlcm(int a, int b) {
	      int[] answer = new int[2];
	      int temp=1;
	      int gcd=a*b;
	      while(temp!=0){
	      temp=b%a;
	        b=a;
	        a=temp;
	      }
	      answer[0]=b;
	      answer[1]=gcd/b;
	        return answer[1];
	    }
}

