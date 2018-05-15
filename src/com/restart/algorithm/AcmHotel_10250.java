package com.restart.algorithm;

import java.util.Scanner;

public class AcmHotel_10250 {
	public static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for ( int t = 0; t < testCase; t++ ) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			
			int n = sc.nextInt();
			map = new int[h][w];
			
			roomCall(n, 0);
			
		}
	}
	private static void roomCall(int n, int count ) {
		// TODO Auto-generated method stub
		//기저사례 
		int h = map.length;
		int w = map[0].length;
		
		//열, 행 순 
		for ( int i = 0 ; i < w; i ++ ) {
			for ( int j = h-1; j >= 0; j-- ) {
				//방 배정 
				map[j][i] = 1;
				count++;
				if ( n == count ) {
					if ( (i+1) / 10 == 0 ) {
						System.out.println(h-j + "0" + (i+1) );
						break;
					}else {
						System.out.println((h-j) +"" + (i+1) );
						break;
					}
				}
			}
		}
	}

}
