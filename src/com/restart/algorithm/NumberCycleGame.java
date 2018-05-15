package com.restart.algorithm;

import java.util.Scanner;

public class NumberCycleGame {
	
	public static int n = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		int number = n;
		
		printCycle ( number , 1 );
		
	}

	private static void printCycle(int number, int cycle ) {
		// TODO Auto-generated method stub
		
		int mok = number / 10;
		int nmg = number % 10;
		int sum = mok + nmg;
		int sumNmg = sum % 10;
		
		String newNumber = nmg + "" + sumNmg + "";
		number = Integer.parseInt(newNumber);
		if ( n == number ) {
			System.out.println(cycle);
			return;
		}
		
		printCycle(number, cycle+1);
		
	}
}
