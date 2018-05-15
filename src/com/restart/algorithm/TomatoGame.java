package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class TomatoLocation {
	
	int x;
	int y;
	
	public TomatoLocation(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
}

public class TomatoGame {
	
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	
	public static final int RIPEN = 1;
	public static final int UNRIPEN = 0;
	public static final int EMPTY = -1;
	
	static int n;
	static int m;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("tomato.txt"));
		
		m = sc.nextInt();
		n = sc.nextInt();
		
		map = new int[n][m];
		
		LinkedList<TomatoLocation> pos = new LinkedList<>();
		
		//map set
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0; j < m;j ++ ) {
				map[i][j] = sc.nextInt();
				//익은 토마토의 위치를 담음 
				if ( map[i][j] == RIPEN ) {
					pos.add(new TomatoLocation(i, j));
				}
			}
		}
		
		for ( TomatoLocation tl : pos ) {
			bfs( tl.x, tl.y );
		}
		
		int ret = getMaxDate();
		System.out.println(ret);
//		printMap();
	}
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m; j ++ ) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	//1개라도 안익은게 있다면 -1 반환 
	//모두 익었다면 최대값 -1 반환 
	private static int getMaxDate() {
		// TODO Auto-generated method stub
		int max = -1;
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j <m;j ++ ) {
				if ( map[i][j] == UNRIPEN ) return -1;
				else if ( map[i][j] > max ) max = map[i][j];
			}
		}

		return max-1;
		
	}
	//익은 토마토 (1) 부터 시작해서 뻗어나감 
	private static void bfs(int a, int b) {
		// TODO Auto-generated method stub
		Queue<TomatoLocation> q = new LinkedList<>();
		q.add(new TomatoLocation(a, b));
		
		//익을게 없을 때까지 익힌다 .
		while(!q.isEmpty()) {
			//익은 토마토 좌표 
			int x = q.peek().x;
			int y = q.poll().y;
			
			//상하좌우로 퍼뜨릴수있는지 체크해서 퍼뜨린다 .
			for ( int i = 0; i < 4; i ++ ) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if ( canSpread(x, y, nextX, nextY ) ) {
					map[nextX][nextY] = map[x][y]+1;
					q.add(new TomatoLocation(nextX, nextY));
				}
				
			}
		}
		
	}
	private static boolean canSpread(int x, int y, int nextX, int nextY) {
		// TODO Auto-generated method stub
		//범위 안에 있는가 
		boolean isRange = ( 0 <= nextX && nextX < n ) && ( 0 <= nextY && nextY < m );
		return isRange && (map[nextX][nextY] == UNRIPEN || map[x][y] +1 < map[nextX][nextY] );
	}

}
