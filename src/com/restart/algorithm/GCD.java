package com.restart.algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class GCD {
	//최대공약수 
	//유클리드호제법
	//f(a,b) = f(b, a mod b) while(mod > 0) 
	// return b;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		long gcd = gcd(a, b);
		long lcm = lcm(a,b, gcd );
		System.out.println(gcd + "최대공약수 ");
		System.out.println(lcm + "최소공배수 ");
	}

	private static long lcm(int a, int b, long gcd) {
		// TODO Auto-generated method stub
		
		return (a*b) / gcd ;
	}

	private static long gcd(long a, long b) {
		// TODO Auto-generated method stub
		
		long mod = a % b;
		
		while ( mod > 0 ) {
			
			a = b;
			b = mod;
			mod = a % b;
		}
		
		return b;
	}

}
