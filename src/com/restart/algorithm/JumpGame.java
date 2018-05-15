package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class JumpGame {
	
	public static int n = 7;
	public static int board[][] = new int[100][100];
	public static int cashe[][] = new int[100][100];
	public static int ret = 0;
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("jumpGame.txt"));
		
		
		
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < n; j++ ) {
				board[i][j] = sc.nextInt();
			}
		}
		
		//캐쉬 -1로 초기화 
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < n; j++ ) {
				cashe[i][j] = -1;
			}
		}
		
		jump(0,0);
		
		System.out.println(ret);
		
		
	}

	private static int jump(int x, int y) {
		// TODO Auto-generated method stub
		//기저사례 ,맵을 벗어나는 경우 
//		System.out.println(x + "," + y);
		if ( x >= n || y >= n ) return 0;
		//마지막 칸에 도착한 경우 
		if ( x == n-1 && y == n-1 ) {
			System.out.println("도착 ");
			ret += 1;
			return 1;
		}
		
		//메모이제이션 
		int ret = cashe[x][y];
		if ( ret != -1 ) return ret;
		int jumpSize = board[x][y];
		
		
		if ( ret == jump(x+ jumpSize, y) ) {
			return ret;
		}
		if ( ret == jump(x, y+jumpSize) ) {
			return ret;
		}
		
		return 0;
	}

}
