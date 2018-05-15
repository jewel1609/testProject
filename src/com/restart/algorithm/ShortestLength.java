package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestLength {
	public static int[][] line;
	public static int[] visited;
	public static int n;
	public static int ret;
	public static int MIN = 10;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("shortLength.txt"));
		n = sc.nextInt();
		int m = sc.nextInt();
		
		int start = sc.nextInt()-1;
		line = new int[n][n];
		visited = new int[n];
		for ( int i = 0 ; i < m ; i ++ ) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
			int z = sc.nextInt();
			line[x][y] = z;
		}
		ret = 0;
		for ( int v = 0; v < n; v ++ ) {
			ret = 0;
			MIN = 10;
			if ( v == start ) {
				System.out.println(start + " , " + v );
				System.out.println(ret);
				continue;
			}
			
			for ( int k = 0 ; k < n; k ++ ) {
				visited[k] = 0;
			}
			
			System.out.println(start + " , " + v );
			bfs ( start, v );
			System.out.println(ret);
		}
		
		
		
		
		
	}
	private static void bfs(int start, int v) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		//시작 정점 큐에 넣고, 방문 
		q.add(start); 
		visited[start] = 1;
		
		while ( !q.isEmpty() ) {
			int curV = q.poll();
			
			for ( int i = 0 ; i <= v ; i ++ ) {
				int nextV = i;
				if ( line[curV][nextV] != 0 ) {
					if ( MIN > line[curV][nextV] ) {
						MIN = line[curV][nextV];
					}
				}
				if ( canMove(curV, nextV) ) {
					q.add(nextV);
					visited[nextV] = 1;
				}
			}
			ret += MIN;
		}
		
	}
	private static boolean canMove(int curV, int nextV) {
		// TODO Auto-generated method stub
		boolean isRange = ( 0 <= nextV && nextV < n);
		return isRange && ( line[curV][nextV] != 0 && visited[nextV] != 1 ) ;
	}
}
