package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Scanner;

public class Samsung06 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 }; 
	static final int LIMIT = 3;
	static int[][] map;
	static int ans;
	static int max;
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n][m];
		
		//map create
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0; j < m; j ++ ) {
				map[i][j] = sc.nextInt();
			}
		}
		
		check();
		
		System.out.println(ans);
		
	}
	private static void check() {
		// TODO Auto-generated method stub

		for ( int k = 0 ; k < (1 << 2 * LIMIT ); k++ ) {
			int dir[] = gen(k);
			
			//의미없는 방향 제거 
			if ( !valid(dir) ) continue;
			
			for ( int i = 0; i < map.length; i ++ ) {
				for ( int j = 0; j < map[0].length; j ++ ) {
					int cur = sumSquares(dir, i, j);
					int cur2 = sumT(i,j);
					if ( ans < cur ) ans = cur;
					if ( ans < cur2 ) ans = cur2;
				}
			}
		}
		
	}
	private static int sumT(int x, int y) {
		// TODO Auto-generated method stub
		int n = map.length;
		int m = map[0].length;
		int sum = map[x][y];
		int max = 0;
		for ( int i = 0 ; i < 4; i ++ ) {
			if ( max < sum) max = sum;
			if ( i == 0 ) {
				if ( x+1 >= 0 && x+1 < n && y+1 >=0 && y+1 < m && 
						x+2 >= 0 && x+2 < n) {
					sum = map[x][y];
					sum+=( map[x+1][y+1] + map[x+2][y] + map[x+1][y] );
					max = sum;
				}
				
			} else if ( i == 1 ) {
				if ( x-1 >= 0 && x-1 < n && y+1 >=0 && y+1 < m && 
						y+2 >=0 && y+2 < m ) {
					sum = map[x][y];
					sum+=( map[x-1][y+1] + map[x][y+1] + map[x][y+2] );
				}
			} else if ( i == 2 ) {
				if ( x+1 >= 0 && x+1 < n && y+1 >=0 && y+1 < m && 
						y+2 >=0 && y+2 < m ) {
					sum = map[x][y];
					sum+=( map[x+1][y+1] + map[x][y+2] + map[x][y+1] );
					max = sum;
				}
			} else if ( i == 3 ) {
				if ( x-1 >= 0 && x-1 < n && y+1 >=0 && y+1 < m && 
						x+1 >= 0 && x+1 < n ) {
					sum = map[x][y];
					sum+=( map[x][y+1] + map[x-1][y+1] + map[x+1][y+1] );
				}
			}
		}
		
		return max;
	}
	private static int sumSquares(int[] dir, int x, int y) {
		// TODO Auto-generated method stub
		int n = map.length;
		int m = map[0].length;
		int sum = map[x][y];
		int cnt = 0;
		for ( int k : dir ) {
			cnt+=1;
			
			int nx = x + dx[k];
			int ny = y + dy[k];
			//map 예외 
			if ( nx < 0 || nx >= n || ny < 0 || ny >= m ) {
				sum = 0;
				return sum;
			}
			
			sum += map[nx][ny];
			
			x = nx;
			y = ny;
		}
		
		if ( cnt == 3 ) {
			return sum;
		}
		
		return 0;
	}
	private static boolean valid(int[] dir) {
		// TODO Auto-generated method stub
		
		for ( int i = 0; i+1 < dir.length; i ++ ) {
			
			if ( dir[i] == 0 && dir[i+1] == 1 ) return false;
			if ( dir[i] == 1 && dir[i+1] == 0 ) return false;
			if ( dir[i] == 2 && dir[i+1] == 3 ) return false;
			if ( dir[i] == 3 && dir[i+1] == 2 ) return false;
			
		}
		
		return true;
	}
	private static int[] gen(int k) {
		// TODO Auto-generated method stub
		int dir[] = new int[LIMIT];
		
		for ( int i = 0 ; i < LIMIT; i ++ ) {
			dir[i] = (k&3);
			k >>= 2;
		}
		
		return dir;
	}

}
