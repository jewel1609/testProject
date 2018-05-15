package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Scanner;

class Result {
	
	int x, y;
	boolean moved;
	boolean hole;
	
	Result( boolean moved, boolean hole, int x, int y ) {
		this.x = x;
		this.y = y;
		this.moved = moved;
		this.hole = hole;
	}
	
}
//째로탈출 2 
public class Samsung01 {
	
	static final int LIMIT = 10;
	static int[] dx = { -1, 1, 0, 0 }; 
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String[] map = new String[n];
		char[][] a = new char[n][m];
		
		for ( int i = 0 ; i < n; i ++ ) {
			map[i] = sc.next();
		}
		int ans = -1;
		
		
		//모든 경우 순회 
		for ( int k = 0 ; k < ( 1 << ( 2 * LIMIT ) ); k ++ ) {
			
			int dir[] = gen(k);
			if ( !valid(dir) ) continue;
			
			//맵 생성 
			for ( int i = 0; i < n; i ++ ) {
				a[i] = map[i].toCharArray();
			}
			
			int cur = check(a, dir);
			
			if ( cur == -1 ) continue;
			if ( ans == -1 || ans > cur ) ans = cur;
			
		}
		
		System.out.println(ans);
		
		
		
	}

	private static int check(char[][] a, int[] dir) {
		// TODO Auto-generated method stub
		int n = a.length;
		int m = a[0].length;
		int hx = 0, hy = 0;
		int rx = 0, ry = 0;
		int bx = 0, by = 0;
		
		//구멍, 공의 위치 탐색 
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < m; j ++ ) {
				
				if ( a[i][j] == 'O') {
					hx = i;
					hy = j;
				} else if ( a[i][j] == 'R' ) {
					rx = i;
					ry = j;
				} else if ( a[i][j] == 'B' ) {
					bx = i;
					by = j;
				}
			}
		}
		
		int cnt = 0;
		boolean hole1 = false;
		boolean hole2 = false;
		
		for ( int k : dir ) {
			cnt+=1;
			
			while ( true ) {
				
				Result p1 = simulate ( a, k, rx, ry );
				rx = p1.x;
				ry = p1.y;
				Result p2 = simulate ( a, k, bx, by );
				bx = p2.x;
				by = p2.y;
				
				if ( p1.moved == false && p2.moved == false ) break;
				
				if ( p1.hole ) hole1 = true;
				if ( p2.hole ) hole2 = true;
				
			}
			
			if ( hole2 ) return -1;
			if ( hole1 ) return cnt;
		}
		
		return -1;
	}

	private static Result simulate(char[][] a, int k, int x, int y) {
		// TODO Auto-generated method stub
		int n = a.length;
		int m = a[0].length;
		
		if ( a[x][y] == '.' ) return new Result(false, false, x, y );

		boolean moved = false;
		while ( true ) {
			
			int nx = x + dx[k];
			int my = y + dy[k];

			if ( nx < 0 && nx >= n && my < 0 && my >= m ) return new Result(moved, false, x, y);

			char ch = a[nx][my];
			if ( ch == '#' ) {
				return new Result(moved, false, x, y);
			}else if ( ch == 'R' || ch == 'B' ) {
				return new Result(moved, false, x, y);
			}else if ( ch == '.' ) {
				char temp = a[x][y];
				a[x][y] = a[nx][my]; 
				a[nx][my] = temp;
				
				x = nx;
				y = my;
				moved = true;
			}else if ( ch == 'O' ) {
				a[x][y] = '.';
				moved = true;
				return new Result(moved, true, x, y);
			}
			
		}
		
	}

	private static boolean valid(int[] dir) {
		// TODO Auto-generated method stub
		int l = dir.length;
		
		for ( int i = 0; i+1 < l; i ++ ) {
			
			if ( dir[i] == 0 && dir[i+1] == 1 ) return false;
			if ( dir[i] == 1 && dir[i+1] == 0 ) return false;
			if ( dir[i] == 2 && dir[i+1] == 3 ) return false;
			if ( dir[i] == 3 && dir[i+1] == 2 ) return false;
			
		}
		
		return true;
	}

	private static int[] gen(int k) {
		// TODO Auto-generated method stub
		int[] dir = new int[LIMIT];
		
		for ( int i = 0 ; i < LIMIT; i ++ ) {
			dir[i] = (k&3);
			
			k >>= 2 ;
		}
		
		return dir;
	}

}
