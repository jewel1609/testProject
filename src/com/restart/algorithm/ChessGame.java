package com.restart.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class ChessGame {
	public static String[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for ( int testCase = 0; testCase < t; testCase++ ) {
			
			int n = sc.nextInt();
			map = new String[n][n];
			for ( int i = 0 ; i < n; i ++ ) {
				Arrays.fill(map[i] , "0");
			}
			
			sc.nextLine();
			String str = sc.nextLine();
			String[] batch = str.split(",");
			
			mapABC(batch);
			
			goChess();
			
			showMap();
			int ret = checkZero();
			
			System.out.println(ret);
		}
		
		
	}
	private static int checkZero() {
		// TODO Auto-generated method stub
		int ret = 0;
		for ( int i = 0 ; i < map.length; i++ ) {
			for ( int j = 0 ; j < map[0].length; j++ ) {
				if ( map[i][j].equals("0") ) {
					ret += 1;
				}
			}
		}
		return ret;
	}
	private static void goChess() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < map.length; i++ ) {
			for ( int j = 0 ; j < map[0].length;j++) {
				if ( map[i][j].equals("A") ) {
					moveChess(i, j, 1);
				}else if ( map[i][j].equals("B") ) {
					moveChess(i, j, 2);
				}else if ( map[i][j].equals("C") ) {
					moveChess(i, j, 3);
				}
				
				
			}
		}
		
	}
	private static void moveChess(int x, int y, int num) {
		// TODO Auto-generated method stub
		int n = map.length;
		while ( num >  0 ) {
			if ( x-num >= 0 && y-num >= 0 && map[x-num][y-num].equals("0") ) {
				map[x-num][y-num] = "1";
			}
			if ( y-num >= 0 && map[x][y-num].equals("0") ) {
				map[x][y-num] = "1";
			}
			if ( x+num < n && y-num >=0 && map[x+num][y-num].equals("0") ) {
				map[x+num][y-num] = "1";
			}
			if ( x-num >= 0 && map[x-num][y].equals("0") ) {
				map[x-num][y] = "1";
			}
			if ( x+num < n && map[x+num][y].equals("0") ) {
				map[x+num][y] = "1";
			}
			if ( x-num >= 0 && y+num < n && map[x-num][y+num].equals("0") ) {
				map[x-num][y+num] = "1";
			}
			if ( y+num < n && map[x][y+num].equals("0") ) {
				map[x][y+num] = "1";
			}
			if ( x+num < n && y+num < n && map[x+num][y+num].equals("0") ) {
				map[x+num][y+num] = "1";
			}
			num--;
		}
	}
	private static void showMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < map.length; i++ ) {
			for ( int j = 0 ; j < map[0].length; j++ ) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	private static void mapABC(String[] batch) {
		// TODO Auto-generated method stub
		for ( int i = 0; i < 3; i ++ ) {
			String[] location = batch[i].split(" ");
			int m = 0;
			while ( m < location.length ) {
				int x = Integer.parseInt(location[m]);
				int y = Integer.parseInt(location[m+1]);
				if ( i == 0 ) {
					map[x][y] = "A"; 
				}else if ( i == 1 ) {
					map[x][y] = "B";
				}else if ( i == 2 ) {
					map[x][y] = "C";
				}
				
				m += 2;
			}
			
		}
	}
}
