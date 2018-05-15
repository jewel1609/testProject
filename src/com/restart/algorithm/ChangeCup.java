package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class ChangeCup {
	
	static int[] cups;
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("changeCup.txt"));
		
		int n = sc.nextInt();
		cups = new int[3];
		for ( int i = 0 ; i < 3; i++ ) {
			cups[i] = i+1;
		}
		
		
		for ( int i = 0 ; i < n; i ++ ) {
			int x = sc.nextInt();
			int y = sc.nextInt();
//			System.out.println(x+ "," + y);
			
			if ( x == y ) continue;
			
			searchAndSwap ( x, y );
			
		}
		
		System.out.println(cups[0]);
		
	}
	private static void searchAndSwap(int x, int y) {
		// TODO Auto-generated method stub
		int tempX = 0;
		int tempY = 0;
		
		//search
		for ( int i = 0; i < 3; i ++ ) {
			if ( cups[i] == x ) {
				tempX = i;
			}
			if ( cups[i] == y ) {
				tempY = i;
			}
		}
		
		//swap
		int temp = cups[tempX];
		cups[tempX] = cups[tempY];
		cups[tempY] = temp;
		
	}

}
