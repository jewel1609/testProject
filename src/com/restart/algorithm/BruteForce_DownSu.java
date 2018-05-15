package com.restart.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BruteForce_DownSu {
	
	public static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		int number = 0;
		
		while ( count != n ) {
			number++;
//			System.out.println(count);
//			System.out.println(number + ",,");
//			if ( number < 10 ) {
//				count++;
//				number++;
//				continue;
//			}
			if ( number > 987654321 ) {
				System.out.println(-1);
				return;
			}
			int temp = number;	
			//감소하는 수인지 체크
			//제일 큰자리수에서 1의자리까지 작아지는 수인지 .
			Queue<Integer> q = new LinkedList<>();
			while ( true ) {
				if ( number / 10 == 0 ) {
			
					q.add(number%10);
					break;
				}
				
				
				int nmg = number % 10;
//				System.out.println(number + " 숫자 ");
				number = number / 10;
				q.add(nmg);
//				System.out.println(nmg);
				//
			}
			flag = false;
//			System.out.println(q.size() + " before");
			
			
			
			
			//q가 오름차순인지 체크 
			//오름차순이라면 count 증가 
			while ( !q.isEmpty() ) {
				int num = q.poll();
				if ( q.isEmpty() ) break;
				int nextNum = q.peek();
//				System.out.println(num + ", " + nextNum);
				if ( num >= nextNum ) {
					flag = true;
					break;
				}
			}
//			System.out.println(q.size() + " q");
			if ( !flag ) {
				count++;
			}
			number = temp;
		}
		
		System.out.println(number);
	}
}
