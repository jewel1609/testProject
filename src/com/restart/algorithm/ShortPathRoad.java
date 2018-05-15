package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

//외판원 문제2 백준 100971
//https://www.acmicpc.net/problem/10971
public class ShortPathRoad {
	
	//전역 변수 
	public static int n;
	public static int distance[][];
	
	public static void main(String[] args) throws Exception {
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		n = sc.nextInt();
		distance = new int[n][n];
		
		
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < n; j ++ ) {
				distance[i][j] = sc.nextInt();
			}
		}
		
		//경로, 방문 유무, 거리
		Stack<Integer> path = new Stack<>();
		boolean[] visited = new boolean[n];
		for ( int i = 0; i < n; i ++ ) {
			visited[i] = false;
		}
		int currentDistance = 0;
		path.push(0);
		visited[0] = true;
		int result = shortestDistance(path, visited, currentDistance);
		
		
		System.out.println(result);
		
		
	}

	private static int shortestDistance(Stack<Integer> path, boolean[] visited, int currentDistance) {
		// TODO Auto-generated method stub
		
		//기저사례 
		if ( path.size() == n ) {
			return currentDistance + distance[path.peek()][0];
		}
		int ret = 987654321;
		for ( int next = 0; next < n; next++ ) {
			//기저사례 
			if ( visited[next] ) continue;
			//방문 
			int here = path.peek();
			
			if ( distance[here][next] == 0) continue;
			
			path.push(next);
			visited[next] = true;
			//나머지 경로를 재귀 함수를 통해 완성하고 가장 짧은 경로의 길이를 얻는다.
			int cand = shortestDistance(path, visited, currentDistance + distance[here][next]);
			ret = Math.min(cand, ret);
			visited[next] = false;
			path.pop();
			
		}
		
		return ret;
	}

}
