package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
class VirusPair {
	int x;
	int y;
	public VirusPair (int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class LAB_14502 {
	static int n;
	static int m;
	static int[][] map;
	static int[][] tempMap;
	static int[][] visited;
	static boolean flag2 = false;
	
	static int max = 0;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("lab_virus.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		tempMap = new int[n][m];
		visited = new int[n][m];
		ArrayList<VirusPair> list = new ArrayList<>();
		// 2 바이러스
		// 1 벽
		// 0 빈 공간 
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < m ; j ++ ) {
				map[i][j] = sc.nextInt();
				tempMap[i][j] = map[i][j];
				if ( map[i][j] == 2 ) list.add(new VirusPair(i, j));
			}
		}
//		printMap();
//		System.out.println("--");
		//벽 세우기 
		for ( int x1 = 0; x1 < n; x1 ++ ) {
			for ( int y1 = 0 ; y1 < m ; y1 ++ ) {
				for ( int x2 = 0; x2 < n; x2 ++ ) {
					for ( int y2 = 0 ; y2 < m ; y2 ++ ) {
						for ( int x3 = 0; x3 < n; x3 ++ ) {
							for ( int y3 = 0 ; y3 < m ; y3 ++ ) {
								//map 초기화 
								for ( int l = 0 ; l < n ; l ++ ) {
									for ( int j = 0 ; j < m ; j ++ ) {
										map[l][j] = tempMap[l][j];
									}
								}
								
								if ( map[x1][y1] != 0 || map[x2][y2] != 0 || map[x3][y3] != 0 ) continue; 
								if ( (x1 == x2) && (y1 == y2) ) continue;
								if ( (x2 == x3 ) && ( y2 == y3 ) ) continue;
								if ( (x3 == x1 ) && ( y3 == y1 ) ) continue;	
								
//								System.out.println(x1 +" , " +y1);
//								System.out.println(x2 +" , " +y2);
//								System.out.println(x3 +" , " +y3);
//								System.out.println("완성 ");
								//맵 초기화 
								
								
								//해당 좌표에 벽 새우기 
								map[x1][y1] = 1;
								map[x2][y2] = 1;
								map[x3][y3] = 1;
								
								//방문 초기화 
								for ( int k = 0 ; k < n; k ++ ) {
									Arrays.fill(visited[k], 0);
								}
								
								//dfs돌리기
								for ( int i = 0 ; i < list.size(); i ++ ) {
									int x = list.get(i).x;
									int y = list.get(i).y;
//									System.out.println(x + " , " + y);
									
									dfs( x, y );
								}
								int count = 0;
								//0개수 세기 
								for ( int p = 0 ; p < n; p ++ ) {
									for ( int j = 0 ; j < m ; j ++ ) {
										if ( map[p][j] == 0 ) {
											count += 1;
										}
									}
								}
//								if ( count == 27 ) {
//									flag2 = true;
//									printMap();
//									System.out.println("--");
//								}
								if ( max < count ) max = count;
								
								//벽 없애기 
								map[x1][y1] = 0;
								map[x2][y2] = 0;
								map[x3][y3] = 0;
							}
						}
					}
				}
			}
		} //end
		
		System.out.println(max);
		
	}
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m ;j ++ ) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	private static void dfs(int x, int y) {
		// TODO Auto-generated method stub
		Stack<VirusPair> st = new Stack<>();
		st.add(new VirusPair(x, y));
		visited[x][y] = 2;
		map[x][y] = 2;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		boolean flag;
		while ( !st.isEmpty() ) {
			int curX = st.peek().x;
			int curY = st.peek().y;
			
			flag = false;
			
			for ( int i = 0 ; i < 4; i ++ ) {
				
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if ( canMove(x, y, nextX, nextY ) ) {
					st.add(new VirusPair(nextX, nextY));
					visited[nextX][nextY] = 2;
					map[nextX][nextY] = 2;
					flag = true;
					break;
				}
			}
			
			if ( !flag ) {
				st.pop();
			}
		}
		
		
	}
	private static boolean canMove(int x, int y, int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = ( 0 <= nextX && nextX < n ) && ( 0<= nextY && nextY < m );
		return isRange && ( map[nextX][nextY] == 0 && visited[nextX][nextY] != 2 );
	}

}
