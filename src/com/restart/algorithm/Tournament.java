package com.restart.algorithm;

import java.util.Scanner;

public class Tournament {
	static int n;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if ( a > b ) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		int round = 0;
		
		while ( n > 1 ) {
			System.out.println(a + " ," + b);
			
			if ( (b%2 == 0) && ( b/2 == (a/2)  + (a%2) ) ) {
				// 둘이 만남
				round++;
				break;
			}
			
			if ( a % 2 == 0 ) {
				a = a / 2;
			}else if ( a % 2 != 0 ) {
				a = (a/2) + (a%2);
			}
			
			if ( b % 2 == 0 ) {
				b = b / 2;
			}else if ( b % 2 != 0 ) {
				b = (b/2) + (b%2);
			}
			
			if ( n % 2 == 0 ) {
				n = n/2;
			}else {
				n = n/2 + 1;
			}
			
			round++;
			
		}
		
		System.out.println(round);
		
	}
}
