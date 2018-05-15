package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class DFSSchedule {

	static int n;
	static int[] days;
	static int[] money;
	static int max = 0;
	static int result;

	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("dfsRetire.txt"));

		n = sc.nextInt();
		days = new int[n];
		money = new int[n];

		for (int i = 0; i < n; i++) {
			days[i] = sc.nextInt();
			money[i] = sc.nextInt();
//			System.out.println(days[i] + "," + money[i]);
		}

		// 상담해서 최대얻을 수 있는 이익 계산 .
		dfs(0, 0);
		System.out.println(max);

	}

	private static void dfs(int day, int sum ) {
		// TODO Auto-generated method stub
		
		if ( day == n ) {
//			System.out.println(sum + "상담종료 " + day);
			if ( sum > max ) max = sum;
			return;
		}
		
		if ( day > n ) {
			return;
		}
        dfs(day+days[day], sum + money[day]);
    	dfs(day+1, sum);

	}
}
