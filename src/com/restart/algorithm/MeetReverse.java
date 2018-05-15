package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class MeetReverse {
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("meetReverse.txt"));
		
		int t = sc.nextInt();
		for ( int testCase = 0; testCase < t; testCase++ ) {
			
			int h = sc.nextInt();
			int w = sc.nextInt();
			
			String[][] map = new String[h][w];
			
			for ( int i = 0; i < h; i ++ ) {
				map[i] = sc.next().split("");
			}
			
//			printMap(map);
			
			//전체를 뒤집으면 끝나는 일 
			//열을 거꾸로 출력 
			reversePrintMap(map);
			
			
		}
		
	}

	private static void reversePrintMap(String[][] map) {
		// TODO Auto-generated method stub
		int n = map.length;
		int m = map[0].length;
		for ( int i = 0;i < n; i ++ ) {
			for ( int j = m-1; j >=0; j -- ) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}

	private static void printMap(String[][] map) {
		// TODO Auto-generated method stub
		int n = map.length;
		int m = map[0].length;
		
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0; j < m; j ++ ) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
