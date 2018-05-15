package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PairApart {
	int x;
	int y;
	public PairApart(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class CheckHouse {
	public static int n;
	public static String[][] map;
	public static int[][] memo;
	public static Queue<PairApart> q;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static int count = 1;
	public static int[] counts;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("checkHouse.txt"));
		
		n = sc.nextInt();

		map = new String[n][n];
		memo = new int[n][n];
		
		q = new LinkedList<>();
		for ( int i = 0 ; i < n;  i++ ) {
			map[i] = sc.next().split("");
		}
		
		
		//아파트의 좌표찾는다.  
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < n; j ++ ) {
				if ( map[i][j].equals("1") && memo[i][j] == 0) {
					//해당좌표부터 bfs를 돌린다. 
//					System.out.println(i + ", " + j);
					bfs ( i, j );
				}
			}
		}
		
		printMemo();
//		System.out.println("==");
//		printMap();
		
		counts = new int[count-1];
		
		for ( int i = 0 ; i < n ;i ++ ) {
			for ( int j = 0 ; j < n; j ++ ) {
				if ( memo[i][j] != 0 ) {
					int num = memo[i][j];
					counts[num-1] +=1;
				}
			}
		}
		
		System.out.println(count-1);
		//counts 오름차순 정렬 
		for ( int i = 0 ; i < counts.length-1; i++ ) {
			for ( int j = i+1; j < counts.length; j++ ) {
				if ( counts[i] > counts[j] ) {
					int temp = counts[i];
					counts[i] = counts[j];
					counts[j] = temp;
				}
				
			}
		}
		
		
		for ( int i = 0 ; i < count-1; i ++ ) {
			System.out.println(counts[i]);
		}
		
	}

	private static void bfs(int i, int j) {
		// TODO Auto-generated method stub
		q.add(new PairApart(i, j));
		//첫번째 단지 기록 
		memo[i][j] = count;
		
		//bfs 시작 
		while( !q.isEmpty() ) {
			int x = q.peek().x;
			int y = q.poll().y;
			for ( int dir = 0 ; dir < 4; dir ++ ) {
				int nextX = x + dx[dir];
				int nextY = y + dy[dir];
				
				if ( neigbour(nextX, nextY) ) {
					q.add(new PairApart(nextX, nextY));
					//방문 
					memo[nextX][nextY] = count;
					map[nextX][nextY] = "0";
				}
			}
		}
		count++;
	}

	private static void printMemo() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < n ; j ++ ) {
				System.out.print(memo[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < n ; j ++ ) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean neigbour(int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = ( 0 <= nextX && nextX < n ) && ( 0 <= nextY && nextY < n );
		return isRange && ( map[nextX][nextY].equals("1"));
	}
}
