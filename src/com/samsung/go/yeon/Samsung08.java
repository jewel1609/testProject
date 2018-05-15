package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Pairs {
	int x, y;
	Pairs (int x, int y ) {
		this.x = x;
		this.y = y;
	}
}

public class Samsung08 {
	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n;
	static int[][] map;
	static int ans = 0;
	static String[] check;
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		n = sc.nextInt();
		int k = sc.nextInt();
		map = new int[n+1][n+1];
		check = new String[10001];
		
		//check초기화
		for ( int i = 0; i < check.length; i++ ) {
			check[i] = "";
		}
		
		for ( int i = 0; i < map.length; i ++) {
			for ( int j = 0; j < map[0].length; j ++ ) {
				map[i][j] = 0;
			}
		}
		
		//사과 생성 
		for ( int i = 0; i < k; i++ ) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 1;
		}
				
		
		//방향 변환 개수 
		int l  = sc.nextInt();
		
		for ( int i = 0 ; i < l; i ++ ) {
			int sec = sc.nextInt();
			String dir = sc.next();
			check[sec] = dir;
		}
		Queue<Pairs> q = new LinkedList<Pairs>();
//		Stack<Pairs> stack = new Stack<Pairs>();
//		
//		stack.push(new Pairs(1,1));
//		stack.pop();
		//지렁이 칸 2, 사과의 칸 1
		q.add(new Pairs(1, 1));
		
		
		int cur = go(1, 1, 0, 3, q);
		
		System.out.println(ans);
		
	}

	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < map.length; i ++ ) {
			for ( int j = 0 ; j < map[0].length; j ++ ) {
				System.out.print (map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static int go(int x, int y, int sec, int dir, Queue<Pairs> q) {
		// TODO Auto-generated method stub
//		System.out.println(sec);
		sec +=1;
		int nx = x + dx[dir];
		int ny = y + dy[dir];
//		System.out.println(x + ", "+ y + " : dir " + dir) ;
//		System.out.println(t1+" , " +t2);
//		System.out.println();
//		printMap();
//		System.out.println();
		
		//끝나는 조건 
		if ( nx > n || ny > n || nx <= 0 || ny <= 0 || map[nx][ny] == 2) {
			ans = sec;
			return ans;
		}
		//만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
		if ( map[nx][ny] == 1) {
			map[nx][ny] = 2;
			q.add(new Pairs(nx, ny));
			x = nx;
			y = ny;
			if ( check[sec].equals("D") ) {
				
				if ( dir == 0 ) {
					dir = 3;
				} else if ( dir == 1 ) {
					dir = 2;
				} else if ( dir == 2 ) {
					dir = 0;
				} else if ( dir == 3 ) {
					dir = 1;
				}
			} else if ( check[sec].equals("L") ) {
				
				if ( dir == 0 ) {
					dir = 2;
				} else if ( dir == 1 ) {
					dir = 3;
				} else if ( dir == 2 ) {
					dir = 1;
				} else if ( dir == 3 ) {
					dir = 0;
				}
			}
			go( x, y, sec, dir, q );
		}
		//사과가 없다면 이동만한다  꼬리는 지운다. 
		else if ( map[nx][ny] == 0 ) {
			map[nx][ny] = 2;
			q.add(new Pairs(nx, ny));
			//꼬리좌표 꺼내서 지우기
			Pairs p1 = q.remove();
			map[p1.x][p1.y] = 0;
			
			x = nx;
			y = ny;
			if ( check[sec].equals("D") ) {
				
				if ( dir == 0 ) {
					dir = 3;
				} else if ( dir == 1 ) {
					dir = 2;
				} else if ( dir == 2 ) {
					dir = 0;
				} else if ( dir == 3 ) {
					dir = 1;
				}
			} else if ( check[sec].equals("L") ) {
				
				if ( dir == 0 ) {
					dir = 2;
				} else if ( dir == 1 ) {
					dir = 3;
				} else if ( dir == 2 ) {
					dir = 1;
				} else if ( dir == 3 ) {
					dir = 0;
				}
			}
			go( x, y, sec, dir, q);
		}// end else if
		
		return 0;
	} 
	
	

}
