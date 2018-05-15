package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	int x;
	int y;
	public Position ( int x, int y ) {
		this.x = x;
		this.y = y;
	}
}
public class Percolate {
	//13565
	static int n;
	static int m;
	static String[][] map;
	static int[][] visited;
	
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("percolate.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new String[n][m];
		visited = new int[n][m];
		
		for ( int i = 0 ; i < n ; i ++ ) {
			map[i] = sc.next().split("");
		}
		
		//바깥쪽 전류 시작 위치 등록 
		ArrayList<Position> startPositions = new ArrayList<>();
		ArrayList<Position> endPositions = new ArrayList<>();
		//열검색해서 넣기 
		for ( int i = 0; i < m; i ++ ) {
			if ( map[0][i].equals("0") ) {
				startPositions.add(new Position(0, i));
			}
			if ( map[n-1][i].equals("0") ) {
				endPositions.add(new Position(n-1, i));
			}
		}
		
		//시작위치에서 bfs 돌리기 
		for ( int i = 0 ; i < startPositions.size(); i ++ ) {
			int x = startPositions.get(i).x;
			int y = startPositions.get(i).y;
			
			bfs( x, y );
		}
		//마지막 열에 0이었던 좌표가 1로 바뀌었다면 전류가 흐른것이다. 
		for ( int i = 0; i < endPositions.size(); i ++ ) {
			int endX = endPositions.get(i).x;
			int endY = endPositions.get(i).y;
			
			if ( map[endX][endY].equals("1") ) {
				System.out.println("YES");
				return;
			}
		}
//		printMap();
		System.out.println("NO");
		
	}
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < m; j ++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	private static void bfs(int x, int y) {
		// TODO Auto-generated method stub
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(x, y));
		map[x][y] = "1";
		
		while ( !q.isEmpty() ) {
			int curX = q.peek().x;
			int curY = q.poll().y;
			for ( int i = 0 ; i < 4; i ++ ) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				
				if ( canMove(curX, curY, nextX, nextY ) ) {
					map[nextX][nextY] = "1";
					q.add(new Position(nextX, nextY));
				}
			}
		}
		
	}
	private static boolean canMove(int curX, int curY, int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = ( 0 <= nextX && nextX < n ) && ( 0 <= nextY && nextY < m );
		return isRange && ( !map[nextX][nextY].equals("1"));
	}

}
