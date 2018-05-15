package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class JustGoLowPath {
	// 백준 1520 내리막길
	static int n;
	static int m;
	static int[][] map;
	static int[][] visited;
	static int ret;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static final int VISITED = 1;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("goJust.txt"));
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][m];
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		for ( int[] arr : visited ) {
			Arrays.fill(arr, -1);
		}
		
		int ret = dpGo(0, 0);

//		 printVISIT();
		System.out.println(ret);

	}

	private static void printVISIT() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int dpGo(int x, int y) {
		// TODO Auto-generated method stub
		if ((x == n - 1) && (y == m - 1)) {
//			System.out.println(x + " , "+ y);
			return 1;
		}
		if (visited[x][y] >= 1 || visited[x][y] == 0)
			return visited[x][y];
		
		if ( visited[x][y] == -1 ) visited[x][y] = 0;
		
		for (int k = 0; k < 4; k++) {
			int nextX = x + dx[k];
			int nextY = y + dy[k];

			if (canMove(x, y, nextX, nextY)) {
				visited[x][y] += dpGo(nextX, nextY);
			}
		}
		return visited[x][y];
	}

	// 도착
	private static boolean canMove(int x, int y, int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = (0 <= nextX && nextX < n) && (0 <= nextY && nextY < m);
		return isRange && (map[x][y] > map[nextX][nextY]);
	}
}
