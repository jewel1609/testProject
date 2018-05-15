package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Pair {
	int x;
	int y;
	int length;
	public Pair(int x, int y, int length) {
		this.x = x;
		this.y = y;
		this.length = length;
	}
}
public class MiroGame {
	public static String[][] map;
	public static int[][] memo;
	public static Queue<Pair> q;
	
	public static String VISITED = "0";
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	
	public static int n;
	public static int m;
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("miroGame.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new String[n][m];
		memo = new int[n][m];
		q = new LinkedList<>();
		
		for ( int i = 0 ; i < n ; i ++ ) {
			map[i] = sc.next().split("");
		}
		
		//bfs시작할 좌표 
		bfs(0,0);
		System.out.println(memo[n-1][m-1]);
		printMemo();
		
		
	}

	private static void printMemo() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n;i ++ ) {
			for ( int j = 0; j < m;j ++ ) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		//큐에 시작점을 넣고, 방문여부 표시하고 bfs를 시작한다.
		q.add(new Pair(i, j, 1));
		map[i][j] = VISITED;
		memo[i][j] = 1;
		int mark = memo[i][j];
		
		while ( !q.isEmpty() ) {
			int x = q.peek().x;
			int y = q.peek().y;
			int markT = q.poll().length;
			
//			System.out.println(mark);
			memo[x][y] = markT++;
			
			for ( int k = 0; k < 4; k ++ ) {
				int nextX = x + dx[k];
				int nextY = y + dy[k];
				
				if ( canMove(nextX, nextY) ) {
					q.add( new Pair(nextX, nextY, markT) );
					map[nextX][nextY] = VISITED;
				}
				
			}
			
			
			
			
			
			
			
			
		}
		
		
	}

	private static boolean canMove(int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = ( 0 <= nextX && nextX < n ) && ( 0 <= nextY && nextY < m );
		return isRange && (map[nextX][nextY].equals("1"));
	}
	
}
