package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;



class Graph {
	//종점 
	int end;
	//가중치 
	int weight;

	public Graph(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}

public class TreeLength {
	// 1167

	public static int[] visited;
	public static int max = 0;
	public static int n;
	public static ArrayList<ArrayList<Graph>> test;
	public static int t;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("treeLength.txt"));

		n = sc.nextInt();
		// 인접행렬
		// line = new int[n+1][n+1];
		// 인접리스트
		test = new ArrayList<ArrayList<Graph>>();
		
		for (int i = 0; i < 100001; i++) {
			test.add(new ArrayList<Graph>());
		}
		
		visited = new int[100001];
		
		//입력 
		for (int i = 0; i < n; i++) {
			int startV = sc.nextInt();
			int nextV = 0;
			while ((nextV = sc.nextInt()) != -1) {
				int length = sc.nextInt();
//				System.out.println(startV + "," + nextV + " : " + length);
				Graph element = new Graph(nextV, length);
				test.get(startV).add(element);

			}
		}
		
		// 정점사이의 거리가 가장 긴 경로.
		// 1에서부터 가장 긴 경로 찾아보기
//		for (int i = 1; i < n + 1 ; i++) {

			//방문배열 초기화 
			Arrays.fill(visited, 0);
			dfs(1);
			int first = max;
//			System.out.println(t);
			Arrays.fill(visited, 0);
			dfs(t);
			int second = max;
			System.out.println(second);
			
//		}

//		 for (int i = 1; i < test.size(); i++) {
//		 System.out.print(i + " : ");
//		 for (int j = 0; j < test.get(i).size(); j++) {
//			 System.out.print(j + "번째 ");
//		 System.out.print(test.get(i).get(j).end + " : " +
//		 test.get(i).get(j).weight + ", ");
//		 }
//		 System.out.println();
//		 }

//		System.out.println(max);

	}

	private static void dfs(int v) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		visited[v] = 1; // 방문
		boolean flag;
		int sum = 0;
		while ( !stack.isEmpty() ) {
			int curV = stack.peek();
			
			flag = false;
			//해당 정점에서 다음으로 이동할수 있는 정점을 찾아서 방문하기 
			for ( int i = 0; i < test.get(curV).size(); i++ ) {
				int nextV = test.get(curV).get(i).end;
				if ( visited[nextV] == 0 ) {
					stack.push(nextV);
					visited[nextV] = 1;
					sum += test.get(curV).get(i).weight;
//					System.out.println( "가중치 " + sum );
					flag = true;
					break;
				}
			}
			
			if ( !flag ) {
//				System.out.println("완성 ");
				
				if ( sum > max ) {
					max = sum;
					t = stack.peek();
				}
				int lastV = stack.pop();
				if ( stack.isEmpty() ) break;
				int preV = stack.peek();
				
				for ( int i = 0; i < test.get(preV).size(); i ++ ) {
					if ( test.get(preV).get(i).end == lastV ) {
//						System.out.println("빼야하는 가중치 ");
						int minusWeight = test.get(preV).get(i).weight;
						sum -= minusWeight;
					}
					
				}
			}
			
		}
		
		

	}
}
