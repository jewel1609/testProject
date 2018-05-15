package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class VirusT {
	int x;
	int y;
	public VirusT(int x, int y ) {
		this.x = x;
		this.y = y;
	}
}
public class DirDFS {
	public static int[][] map;
	public static int[][] temp;
	public static int[][] visited;
	public static int max = 0;
	public static int n;
	public static int m;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	
	public static Queue<VirusT> q = new LinkedList<>();
	public static ArrayList<VirusT> tempList = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("virus.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		temp = new int[n][m];
		visited = new int[n][m];
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < m; j++ ) {
				map[i][j] = sc.nextInt();
				temp[i][j] = map[i][j];
				if ( map[i][j] == 2 ) {
					q.offer(new VirusT(i, j));
					tempList.add(new VirusT(i, j));
				}
			}
		}
		
		dfs("");
		
		System.out.println(max);
	}

	private static void dfs(String str) {
		// TODO Auto-generated method stub
		if ( str.length() == 6 ) {
			
			if ( str.equals("100134")) {
				return;
			}
			
//			for ( int i = 0 ; i < 6; i ++ ) {
//				System.out.print(str.charAt(i) + "");
//			}
			int x1 = Integer.parseInt(str.charAt(0)+"");
			int y1 = Integer.parseInt(str.charAt(1) + "");

			int x2 = Integer.parseInt(str.charAt(2)+ "");
			int y2 = Integer.parseInt(str.charAt(3)+ "");
			
			int x3 = Integer.parseInt(str.charAt(4)+ "");
			int y3 = Integer.parseInt(str.charAt(5)+ "");
			
			if ( x1 == x2 && y1 == y2 ||
					x2 == x3 && y2 == y3 ||
					x3 == x1 && y3 == y1 ) {
				
			}else {
				map[x1][y1] = 1;
				map[x2][y2] = 1;
				map[x3][y3] = 1;
				bfs();
//				printMap();
				countZero();

				for ( int i = 0 ; i < n ; i ++ ) {
					for ( int j = 0 ; j < m;j ++ ) {
						map[i][j] = temp[i][j];
					}
				}
				for ( int i = 0 ; i < tempList.size(); i ++ ) {
					q.add(tempList.get(i));
				}
				
				map[x1][y1] = 0;
				map[x2][y2] = 0;
				map[x3][y3] = 0;
				
				visited[x1][y1] = 0;
				visited[x2][y2] = 0;
				visited[x3][y3] = 0;
			}
			
			
			
//			System.out.println("완성");
			return;
		}
		
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m ; j ++ ) {
				if ( map[i][j] == 0 && visited[i][j] == 0 ) {
					visited[i][j] = 1;
					dfs(str+i+""+j);
					visited[i][j] = 0;
				}
			}
		}
	}

	private static void countZero() {
		// TODO Auto-generated method stub
		int count = 0;
		for ( int i = 0 ; i <n; i ++ ) {
			for ( int j = 0; j < m;j ++ ) {
				if ( map[i][j] == 0 ) count++;
			}
		}
		
		if ( max < count ) max = count;
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		
		while ( !q.isEmpty() ) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			for ( int i = 0 ; i < 4; i ++ ) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if ( isRange(nextX, nextY)) {
					map[nextX][nextY] = 2;
					q.offer(new VirusT(nextX, nextY));
				}
			}
			
		}
		
	}

	private static boolean isRange(int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = ( 0<=nextX && nextX< n) && ( 0<=nextY && nextY<m);
		return isRange && ( map[nextX][nextY] == 0 );
	}

	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i <n ; i ++ ) {
			for ( int j = 0 ; j < m ; j ++ ) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
