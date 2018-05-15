package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class CheeseGame {
	
	public static int n;
	public static int m;
	public static int[][] map;
	public static int phase = 0;
	public static int[][] visited;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static int sideCount = 0;
	public static int eRaseCount = 0;
	public static Queue<Elements> cheeseQ = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("cheese.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new int[n][m];
		
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < m; j ++ ) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//판의 가장자리에는 치즈가 놓이지 않는다.
		//가장자리의 공기를 -1로 바꾼다.
		airBfs();
		int cheeseSize = 0;
		//가장자리 치즈를 큐에 담기 
		edgeCheeseSaveQ();
//		while ( !cheeseQ.isEmpty() ) {
			//가장자리 치즈를 없앤다.(-1)로 바꾼다. 
			//phase+1
			//치즈 갯수 cheeseQ.size();
			edgeCheeseRemoveQ();
			phase++;
//			edgeCheeseSaveQ();
//			edgeCheeseRemoveQ();
			//가장자리 치즈를 큐에 담기 
			cheeseSize = cheeseQ.size();
			System.out.println(cheeseSize);
			//가장자리 치즈를 다시 큐에 담는다.
//			edgeCheeseSaveQ();
			
//		}
		printMap();
		System.out.println(cheeseSize);
		System.out.println(phase+1);
		
	}
	private static void edgeCheeseRemoveQ() {
		// TODO Auto-generated method stub
		while ( !cheeseQ.isEmpty() ) {
			int x = cheeseQ.peek().x;
			int y = cheeseQ.poll().y;
			
			map[x][y] = -1;
			
			for ( int i = 0; i < 4; i ++ ) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if ( isRange(nextX, nextY)) {
					if ( map[nextX][nextY] == 0 ) {
						map[nextX][nextY] = -1;
					}
				}
			}
			
		}
		
	}
	private static void edgeCheeseSaveQ() {
		// TODO Auto-generated method stub
		//네방향중 하나라도 -1이 있으면 가장자리 치즈이다. 
		boolean flag = false;
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < m ; j ++ ) {
				if ( map[i][j] == 1 ) {
						
					for ( int k = 0; k < 4; k ++ ) {
						int nextX = i + dx[k];
						int nextY = j + dy[k];
						if ( map[nextX][nextY] == -1 || map[nextX][nextY] == 0 ) {
							flag = true;
						}
					}
					if ( flag ) {
						cheeseQ.offer(new Elements(i, j));
					}
				}
				flag = false;
			}
		}
		
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		//큐에담긴 가장자리 치즈도 -1로 바꾼다.
//		for ( int i = 0 ; i < n ; i ++ ) {
//			Arrays.fill(visited[i], 0);
//		}
		
		while ( !cheeseQ.isEmpty() ) {
			int x = cheeseQ.peek().x;
			int y = cheeseQ.poll().y;
			
			//가장자리 지우기 
			map[x][y] = -1;
			eRaseCount++;
			
//			if ( eRaseCount == 31 ) {
//				System.out.println();
//				printMap();
//				System.out.println(cheeseQ.size());
//				phase++;
//				sideCount = cheeseQ.size();
//				eRaseCount = 0;
//			}
			
			for ( int i = 0 ; i < 4; i ++ ) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if ( isRange(nextX,nextY) ) {
					int nextState = map[nextX][nextY];
					
					if ( nextState == 0 ) {
						map[nextX][nextY] = -1;
					}else if ( nextState == 1 && visited[nextX][nextY] != 1 ) {
						visited[nextX][nextY] = 1;
						map[nextX][nextY] = -1;
//						cheeseQ.offer(new Elements(nextX, nextY));
					}
				}
			}
		}
		
	}
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0; j < m; j ++ ) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	private static void airBfs() {
		// TODO Auto-generated method stub
		Queue<Elements> q = new LinkedList<>();
		
		q.offer(new Elements(0, 0));
		
		
		while ( !q.isEmpty() ) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for ( int i = 0; i < 4; i ++ ) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if ( isRange(nextX, nextY) ) {
					int nextState = map[nextX][nextY];
					
					//0이면 -1로 교체 
					if ( nextState == 0 ) {
						q.offer( new Elements(nextX, nextY) );
						map[nextX][nextY] = -1;
					}
					
				}
			}
		}//bfs end
		
	}
	private static boolean isRange(int x, int y) {
		// TODO Auto-generated method stub
		boolean isRange = ( 0<=x && x<n ) && ( 0<=y && y<m );
		return isRange;
	}

}
