package com.baekjoon.yeon.exam;

import java.io.FileInputStream;
import java.util.Scanner;

class Result {
	boolean moved, hole;
	int x, y;

	Result(boolean moved, boolean hole, int x, int y) {
		this.moved = moved;
		this.hole = hole;
		this.x = x;
		this.y = y;
	}
}

public class TestYeon {
	
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static final int LIMIT = 10;
	
	public static void main(String[] args) throws Exception {
		
//		Scanner sc = new Scanner(System.in);

		//파일 읽으려면 thorws Exception
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String[] map = new String[n];
		char[][] a = new char[n][m];
		
		for ( int i = 0; i < n; i ++ ) {
			map[i] = sc.next();
		}
		
		
		
		
		int ans = -1;
		//모든 과정 순회 2^20 ( 4x4x4x..... = 4^10 ) 
		for ( int k = 0 ; k < (1 << (2* LIMIT) ); k ++ ) {
			int[] dir = gen(k);
			if ( !valid(dir) ) continue;
			
			for ( int i = 0 ; i < n; i ++ ) {
				a[i] = map[i].toCharArray();
			}
			//공이 구멍으로 탈출 시 몇번 움직였는지 체크하기 ...
			int cur = check(a, dir);
			//10번만에 탈출못했으므로 다음 경우의 수 체크 
			if ( cur == -1 ) continue;
			
			if ( ans == -1 || ans > cur ) ans = cur;
		}
		
		System.out.println(ans);
		
	}
	
	private static int check(char[][] a, int[] dir) {
		// TODO Auto-generated method stub
		int n = a.length;
		int m = a[0].length;
		
		int hx = 0, hy =0;
		int rx = 0, ry = 0;
		int bx = 0, by = 0;
		
		//맵을 돌면서 구멍과 빨간공과 파란공의 좌표값 ( 행, 열 ) 찾기 
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m; j ++ ) {
				if ( a[i][j] == 'O' ) {
					hx = i;
					hy = j;
				}else if ( a[i][j] == 'R' ) {
					rx = i;
					ry = j;
				}else if ( a[i][j] == 'B' ) {
					bx = i;
					by = j;
				}
			}
		}
		
		int cnt = 0;
		
		// 움직인 횟수 (10번 만큼 포문 돌기 ) 
		for ( int k : dir ) {
			//k는 움직인 방향이다..
			cnt += 1;
			boolean hole1 = false, hole2 = false;
			
			//무한 루프 ...
			while ( true ) {
				Result p1 = simulate(a, k, rx, ry);
				rx = p1.x; ry = p1.y;
		
				Result p2 = simulate(a, k, bx, by);
				bx = p2.x; by = p2.y;
				//해당방향으로 이동이 끝나면 탈출 
				if ( p1.moved == false && p2.moved == false ) {
					break;
				}
				
				//이동시 공이 빠져나갔다면 true 
				if ( p1.hole ) hole1 = true;
				if ( p2.hole ) hole2 = true;
			}
			
			if ( hole2 ) return -1;
			//빨간공나갔을때 카운트 
			if ( hole1 ) return cnt;
		}
		return -1;
	}

	private static Result simulate(char[][] a, int k, int x, int y) {
		// TODO Auto-generated method stub
		int n = a.length;
		int m = a[0].length;
		
		//현재 공의 위치가 . 이라면 공이 이미 구멍으로 이동했다는 것을 뜻하므로 더이상 움직일 필요가 없다. 
		if ( a[x][y] == '.' ) return new Result(false, false, x, y);
		boolean moved = false;
		
		// 더이상 움직일 수 없을 때까지 이동 공은 항상 한칸씩 이동한다 . 
		while( true ) {
			//k방향으로 좌표가 움직인다  이동후의 좌표 nx, ny ...
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			//이동후의 좌표가 맵을 벗어났을 때 
			if ( nx < 0 || nx >= n || ny < 0 || ny >= m ) {
				return new Result(moved, false, x, y);
			}
			
			//이동후의 맵의 오브젝트가 무엇인지 체크 
			char ch = a[nx][ny]; 
			if ( ch == '#' ) {
				return new Result( moved, false, x, y );
			} else if ( ch == 'R' || ch == 'B' ) {
				return new Result( moved, false, x, y );
			} else if ( ch == '.' ) {
				char temp = a[nx][ny];
				//공을 이동시킨다.
				a[nx][ny] = a[x][y];
				a[x][y] = temp;
				x = nx;
				y = ny;
				//공이 움직였다.
				moved = true;
			} else if ( ch == 'O' ) {
				//이동시 구멍을 만난다면 
				//공의 좌표를 . 으로 바꾼다.
				a[x][y] = '.';
				//공이 구멍에 들어가서 움직였으므로 
				moved = true;
				return new Result(moved, true, x, y);
			}
		}
	}

	//의미없는 과정 거르기.
	private static boolean valid(int[] dir) {
		// TODO Auto-generated method stub
		int l = dir.length;
		for ( int i = 0 ; i+1 < l ; i ++  ) {
			
			if ( dir[i] == 0 && dir[i+1] == 1) return false;
			if ( dir[i] == 1 && dir[i+1] == 0) return false;
			if ( dir[i] == 2 && dir[i+1] == 3) return false;
			if ( dir[i] == 3 && dir[i+1] == 2) return false;
			
			if ( dir[i] == 0 && dir[i+1] == 0) return false;
			if ( dir[i] == 1 && dir[i+1] == 1) return false;
			if ( dir[i] == 2 && dir[i+1] == 2) return false;
			if ( dir[i] == 3 && dir[i+1] == 3) return false;
			
			
		}
		
		return true;
	}

	//모든 방향 고려 ( 10번 움직인다 ) 
	private static int[] gen(int k) {
		// TODO Auto-generated method stub
		int[] dir = new int[LIMIT];
		for ( int i = 0 ; i < LIMIT; i ++ ) {
			dir[i] = (k&3);
			k >>= 2;
		}
		return dir;
	}

	private static void printMap(char[][] a) {
		// TODO Auto-generated method stub
		for ( int i = 0; i < a.length; i ++ ) {
			for ( int j = 0 ; j < a[0].length; j ++ ) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
}
