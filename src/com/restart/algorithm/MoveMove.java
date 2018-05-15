package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class MoveMove {
	static int n;
	static String[][] map;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("moveMove.txt"));
		
		n = sc.nextInt();
		int k = sc.nextInt();
		map = new String[n][n];
		
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < n ; j ++ ) {
				map[i][j] = sc.next();
			}
		}
		printMap();
		
		for ( int i = 0 ; i < k ; i ++ ) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			System.out.println(x + "," + y);
			int count = sc.nextInt();
			
			goGame(x, y, count, 0);
		}
		
		
	}
	
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < n ; j ++ ){
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void goGame(int x, int y, int count, int start) {
		// TODO Auto-generated method stub
		
		String str = map[x][y]; 
		String strs[] = str.split("");
		int dir = changeDir(strs[0]);
		int num = Integer.parseInt(strs[1]);
		boolean flag = false;
		while ( start != count ) {
			int nextX = x + (dx[dir] * num);
			int nextY = y + (dy[dir] * num);
//			System.out.println(nextX + " ,  " + nextY);
			
			if ( canMove(nextX , nextY) ) {
				str = map[nextX][nextY]; 
				String strs2[] = str.split("");
				dir = changeDir(strs2[0]);
				num = Integer.parseInt(strs2[1]);
			}else {
				System.out.println(10000);
				flag = true;
				break;
			}
			x = nextX;
			y = nextY;
			start++;
		}
		if ( !flag ) {
			System.out.println(num * 1000);
		}
		
	}

	private static boolean canMove(int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = ( 0 <= nextX && nextX < n ) && ( 0 <= nextY && nextY < n );
		return isRange;
	}

	private static int changeDir(String dir) {
		// TODO Auto-generated method stub
		int direct = 0;
		
		switch (dir) {
			case "N": direct = 0;
				break;
			case "E": direct = 1;
				break;
			case "S": direct = 2;
				break;
			case "W": direct = 3;
				break;
		}
		
		return direct;
	}
}
