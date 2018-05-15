package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus {
	public static int[][] line;
	public static int[] visited;
	public static final int VIRUS = 1;
	public static int n;
	public static Queue<Integer> q;
	public static int count;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("virus.txt"));
		
		n = sc.nextInt();
		int k = sc.nextInt();
		line = new int[n][n];
		visited = new int[n];
		q = new LinkedList<>();
		
		//인접행렬 초기화 
		for ( int i = 0 ; i < k; i ++ ) {
			int x = sc.nextInt()-1;
			int y = sc.nextInt()-1;
//			System.out.println(x + " ," + y);
			line[x][y] = 1;
			line[y][x] = 1;
		}
		
		//bfs 0번에서 시작 .
		bfs(0);
		System.out.println(count);
				
	}
	private static void bfs(int v) {
		// TODO Auto-generated method stub
		//시작 정점 넣기, 방문  
		q.add(v);
		visited[v] = VIRUS;
		
		//bfs 시작 
		while ( !q.isEmpty() ) {
			//큐에서 체크정점을 꺼낸다. 
			int curV = q.poll();
			
			// 방문가능한 정점을 방문 후 바이러스를 퍼뜨린다. 
			for ( int i = 0 ; i < n ; i ++ ) {
				int nextV = i;
				if ( canMove ( curV, nextV) ) {
					q.add(nextV);
					visited[nextV] = VIRUS;
					count++;
				}
			}
		}
		
		
		
	}
	private static boolean canMove(int curV, int nextV) {
		// TODO Auto-generated method stub
		boolean isRange = ( line[curV][nextV] == 1 );
		return isRange && ( visited[nextV] != VIRUS );
	}

}
