package com.restart.algorithm;

import java.util.Scanner;


public class MakeStar_2448 {

	
	public static char[][] map = new char[3072][6144];
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < 2*n; j ++ ) {
				map[i][j] = ' ';
			}
		}
		
		
		star ( n, 0, n-1 );
		
		for (int i = 0; i < n; i++) {
			for ( int j = 0; j < 2*n; j ++ ) {
				sb.append(map[i][j]);
			}
          	sb.append("\n");
        }
        System.out.println(sb);
		
		
		
	}
	private static void star(int n, int x, int y) {
		// TODO Auto-generated method stub
		if ( n == 3 ) {
			map[x][y] = '*';
			
			map[x+1][y-1] = '*';
			map[x+1][y+1] = '*';
			
			map[x+2][y-2] = '*';
			map[x+2][y-1] = '*';
			map[x+2][y] = '*';
			map[x+2][y+1] = '*';
			map[x+2][y+2] = '*';
			return;
		}
		
		star(n/2, x, y);
		star(n/2, x+(n/2), y - (n/2) );
		star(n/2, x+(n/2), y + (n/2) );
	} 
	
	
	
	
}
