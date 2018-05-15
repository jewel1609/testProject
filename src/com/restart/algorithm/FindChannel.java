package com.restart.algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class FindChannel {
	static int minCount = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<>();
		//목표채널 
		int n = sc.nextInt();
		
		int k = sc.nextInt();
		int brokenNums[] = new int[k];
		for ( int i = 0; i < k; i ++ ) {
			brokenNums[i] = sc.nextInt();
		}
		
		//부르트 포스 (모든 경우의 수 ) 완전탐색 
		//100에서 출발 +버튼, -버튼, 0~9버튼 존재
		int count = 0;
		//1. 100에서 +,-버튼만으로 접근 
		if ( n > 100 ) {
			count = n - 100; 
		}else if ( n < 100 ) {
			count = 100 - n;
		}
		if ( minCount > count ) minCount = count;
		//2. 버튼으로 접근 (고장난 버튼이라면 가까운 버튼입력 )-> +or -로 목표 도달 
		count = 0;
		
		while ( true ) {
			int mok = n / 10;
			int nmg = n % 10;
			
			//7이 나옴 
			for ( int i = 0 ; i < k; i ++ ) {
				if ( nmg == brokenNums[i] ) {
					
				}
			}
			
			
			
		}
		
		
		
	}
}
