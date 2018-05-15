package com.restart.algorithm;

import java.util.Scanner;

public class BruteForce_NLHAP {
	static int nums[];
	static boolean flag;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		for ( int i = l; i <= 100; i++ ) {
			//길이 
//			System.out.println(i + " 길이 ");
			int startNum = 0;
			int sum = 0; 
			while ( true ) {
//				System.out.println(startNum);
				int temp = startNum;
				for ( int k = 1; k <= i; k++) {
//					System.out.println(startNum + " --");
					sum += startNum;
					startNum+=1;
				}
//				System.out.println(sum + " 합계 ");
				
				startNum = temp;
				
				if ( sum > n ) {
					flag = false;
					break;
				}
				if ( sum == n ) {
					flag = true;
					for ( int k = 1; k <= i; k++) {
//						System.out.print(startNum + " ");
						sb.append(startNum + " ");
						startNum++;
					}
					System.out.println(sb);
					return;
				}
				startNum +=1;
				sum = 0;
			}//end while
			
		}//end
		if ( !flag ) {
			System.out.println(-1);
		}
		
		
	}
}
