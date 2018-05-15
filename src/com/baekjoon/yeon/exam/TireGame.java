package com.baekjoon.yeon.exam;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
class Tire {
	int num;
	int dir;
	
	public Tire(int num, int dir) {
		this.num = num;
		this.dir = dir;
	}
	
}

public class TireGame {
	
	static int n = 4;
	static int m = 8;
	static int k;
	static int[][] map;
	static int select;
	static int dir;
	static int[] dirs;
	static int score = 0;
	
	static int[] visited;
	static int[] dx = {1, -1};
	
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("tireGame.txt"));
		
		map = new int[n][m];
		dirs = new int[n];
		visited = new int[n];
		
		for ( int i = 0 ; i < n; i ++ ) {
			String str = sc.nextLine();
			for ( int j = 0 ; j < m;j++ ) {
				map[i][j] = Integer.parseInt(str.charAt(j)+"");
			}
		}
		
//		printMap();
		
		k = sc.nextInt();
		for ( int i = 0 ; i < k; i ++ ) { 
			select = sc.nextInt();
			//select-1 번호 
			
			dir = sc.nextInt();
			//dir 1은 시계
			//-1은 반시
			
			//visited  초기화
			for ( int j = 0 ; j < n; j++ ) {
				visited[j] = 0;
			}
			
			//네개의 바퀴 방향설정 
			bfsDir();
			
			//방향대로 회전하기 
			goDirsTireNum();
			
//			printDirs();
		}
		sumScore();
		
		
		System.out.println(score);
		
	}
	private static void sumScore() {
		// TODO Auto-generated method stub
		if ( map[0][0] == 1 ) score+=1;	
		if ( map[1][0] == 1 ) score+=2;	
		if ( map[2][0] == 1 ) score+=4;	
		if ( map[3][0] == 1 ) score+=8;	
	}
	private static void goDirsTireNum() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n; i++ ) {
			rotateTire(i, dirs[i]);
		}
	}
	private static void rotateTire(int num, int k) {
		// TODO Auto-generated method stub
		//map[num][0]~[7] 을 변경 
		if ( k == 1 ) {
			//시계
			Stack<Integer> stack = new Stack<>();
			for ( int i = 0 ; i < m; i ++ ) {
				stack.add(map[num][i]);
			}
			int first = stack.pop();
			map[num][0] = first;
			
			for ( int i = 1; i < m;i ++ ) {
				map[num][i] = stack.get(i-1);
			}
			
		}else if ( k == -1 ) {
			//반시계
			Queue<Integer> q = new LinkedList<>();
			
			for ( int i = 0 ; i < m; i ++ ) {
				q.add(map[num][i]);
			}
			int temp = q.poll();
			q.add(temp);
			
			for ( int i = 0; i < m;i ++ ) {
				map[num][i] = q.poll();
			}
			
			
		}
		
	}
	private static void printDirs() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n; i ++ ) {
			System.out.print(dirs[i] + "방향 ");
		}
		System.out.println();
		
	}
	private static void bfsDir() {
		// TODO Auto-generated method stub
		Queue<Tire> q = new LinkedList<>();
		
		//첫번째 값 초기화 
		q.offer(new Tire(select-1, dir));
		visited[select-1] = 1;
		
		while ( !q.isEmpty() ) {
			int curNum = q.peek().num;
			int curDir = q.poll().dir;
			//방향 세팅 
			dirs[curNum] = curDir;
			//왼 .. 오 탐색 
			for ( int k = 0 ; k < 2; k ++ ) {
				int nextNum = curNum + dx[k];
				int nextDir = 0;
				if ( isRange(nextNum) ) {
					if ( k == 0 ) {
						//오른쪽에 있다면
						//극이 다르다면 
						if ( map[curNum][2] != map[nextNum][6] ) {
							nextDir = curDir * (-1);
						}else { 
							nextDir = 0;
						}
//						dirs[nextNum] = nextDir;
						q.offer(new Tire(nextNum, nextDir));
						visited[nextNum] = 1;
					}else if ( k == 1 ) {
						//왼쪽에 있다면 
						//극이 다르다면 
						if ( map[curNum][6] != map[nextNum][2] ) {
							nextDir = curDir * (-1);
						}else { 
							nextDir = 0;
						}
//						dirs[nextNum] = nextDir;
						q.offer(new Tire(nextNum, nextDir));
						visited[nextNum] = 1;
					}
				}
			}
		
		
		}
	}
	private static boolean isRange(int nextNum) {
		// TODO Auto-generated method stub
		boolean isRange = (0<= nextNum && nextNum < n );
		return isRange && ( visited[nextNum] == 0);
	}
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m;j++ ) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
}
