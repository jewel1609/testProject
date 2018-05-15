package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.*;
class Pair {
	int x, y;
	
	Pair (int x, int y ) {
		this.x = x;
		this.y = y;
	}
	
}

public class Samsung02 {
	
	static int n;
	static int m;
	static int[][] a;
	static int[][] b;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int ans; 
	public static void main(String[] args) throws Exception{
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		a = new int[n][m];
		b = new int[n][m];
		
		//맵 생성 
		for( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m; j ++ ) {
				a[i][j] = sc.nextInt();
			}
		}
		
		//벽 생성 
		for ( int x1 = 0; x1 < n; x1++ ) {
			for ( int y1 = 0; y1< m; y1++ ) {
				if ( a[x1][y1] != 0 ) continue;
				for ( int x2 = 0; x2 < n; x2++ ) {
					for ( int y2 = 0; y2< m; y2++ ) {
						if ( a[x2][y2] != 0 ) continue;
						for ( int x3 = 0; x3 < n; x3++ ) {
							for ( int y3 = 0; y3< m; y3++ ) {
								if ( a[x3][y3] != 0 ) continue;
								
								// 벽을 만들 수 있는 공간을 찾았다. 세좌표가 같으면 다음 좌표로 넘어간다.
								if ( x1 == x2 && y1 == y2 ) continue;
								if ( x1 == x3 && y1 == y3 ) continue;
								if ( x2 == x3 && y2 == y3 ) continue;
								
								//벽 설치 
								//bfs돌았으니 벽 제거
								a[x1][y1] = 1;
								a[x2][y2] = 1;
								a[x3][y3] = 1;
								
								//벽 설치했으니 bfs을 돈다.
								bfs();
								
								//bfs돌았으니 벽 제거
								a[x1][y1] = 0;
								a[x2][y2] = 0;
								a[x3][y3] = 0;
								
							}
						}
						
					}
				}
				
				
			}
		}//end for
		
		System.out.println(ans);
		
		
		
		
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		//맵 초기화 과정 
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0 ; j < m; j ++ ) {
				b[i][j] = a[i][j];
				//바이러스 탐색 
				if ( b[i][j] == 2 ) {
					//바이러스 좌표를 큐에 담는다. 
					q.add(new Pair(i, j));
				}
			}
		}
		
		//큐가 비어있지 않다면 계속 반복을 한다. ( 퍼뜨리는 과정 ) 
		while ( !q.isEmpty() ) {
			//하나를 꺼낸다음 네방향으로 퍼뜨리면서 큐 담는다. 
			Pair p = q.remove();
			
			for ( int i = 0; i < 4; i ++ ) {
				
				//이동후의 좌표 
				int nm = p.x + dx[i];
				int ny = p.y + dy[i];
				
				//맵 안에 있다면 바이러스를 퍼뜨린다. 그리고 큐에 담는다. 
				if ( nm >= 0 && nm < n && ny >= 0 && ny < m ) {
					if ( b[nm][ny] == 0 ) {
						b[nm][ny] = 2;
						q.add(new Pair(nm, ny) ); 
					}
				}
			}
		}//end while
		
		int cnt = 0;
		//0의 최대 개수를 찾아라 
		for ( int i = 0; i < n; i++ ) {
			for ( int j = 0 ; j < m ; j ++ ) {
				if ( b[i][j] == 0 ) {
					cnt += 1;
				}
			}
		}

		if ( ans < cnt ) ans = cnt;
		
		
	}
	
}