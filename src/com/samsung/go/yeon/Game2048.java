package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BlockLocation {
	int x;
	int y;
	
	public BlockLocation (int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Game2048 {
	static int n;
	static int[][] map;
	static int[][] tempMap;
	static int[][] visited;
	
	static int max = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int dir[];
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("2048Game.txt"));
		
		n = sc.nextInt();
		
		map = new int[n][n];
		tempMap = new int[n][n];
		visited = new int[n][n];
		
		dir = new int[5];
		
		for ( int i = 0; i<n;i++ ) {
			for ( int j = 0 ; j < n;j ++ ) {
				map[i][j] = sc.nextInt();
				tempMap[i][j] = map[i][j];
			}
		}
		
		
		//5번 이동 
		dfs("", -1);
		
//		testGame
//		goGame();
//		searchMapInMax();
		System.out.println(max);
	}
	private static void searchMapInMax() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < n;j ++ ) {
				if ( map[i][j] > max ) max = map[i][j];
			}
		}
		
	}
	private static void dfs(String str, int curDir) {
		// TODO Auto-generated method stub
		if ( str.length() == 5 ) {
//			System.out.println(str);
			
			//방향 세팅 
			for ( int i = 0; i < 5; i ++ ) {
				dir[i] = Integer.parseInt(str.charAt(i)+"");
			}
			
			//맵 세팅 , visited 세팅 
			for ( int i = 0 ; i < n; i ++ ) {
				for ( int j = 0 ; j < n;j ++ ) {
					map[i][j] = tempMap[i][j];
				}
			}
			
			//방향만큼 게임돌기 
			goGame();
			
			//max값 찾기 
			searchMapInMax();
			
			//게임 끝난 후 맵상태
//			printMap();
			return;
		}else {
			
			for ( int i = 0; i < 4; i ++ ) {
				if ( curDir == 0 && i == 0 ) continue;
				if ( curDir == 1 && i == 1 ) continue;
				if ( curDir == 2 && i == 2 ) continue;
				if ( curDir == 3 && i == 3 ) continue;
				dfs(str+(i+""), i);
			}
		}
		
	}
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0 ; j < n ; j ++ ) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	private static void goGame() {
		// TODO Auto-generated method stub
		
		
//		//test Dir
//		int[] dir2 = new int[5];
//		dir2[0] = 0;
//		dir2[1] = 3;
//		dir2[2] = 1;
//		dir2[3] = 1;
//		dir2[4] = 1;
		
		for ( int k : dir ) {
			//현재방향 
//			System.out.println(k + "현재 방향 ");
			//방향이 바뀌면 visited 초기화 
			for ( int i = 0 ; i < n ; i ++ ){
				for ( int j = 0 ; j < n ;j ++ ) {
					visited[i][j] = 0;
				}
			}

			//오브젝트들을 큐에 담고 해당 방향만 으로 bfs 탐색 
			bfs(k);
			
//			printMap();
//			System.out.println();
		}
		
	}
	private static void bfs(int k) {
		// TODO Auto-generated method stub
		// 1 = 방문한 것은 이미 합쳐진 상태를 의미
		
		Queue<BlockLocation> q = new LinkedList<>();
		
		//해당방향의 반대로 큐에 담아야 한다. 
		if ( k == 1) {
			//큐에 블럭 담기 
			//열을 거꾸로 
			for ( int i = 0; i < n; i ++ ) {
				for ( int j = n-1 ; j >= 0 ; j-- ) {
					if ( map[i][j] != 0 ) {
//						System.out.println(i+","+j);
						q.offer(new BlockLocation(i, j));
					}
				}
			}
		}
		else if ( k == 3 ) {
			//큐에 블럭 담기 
			for ( int i = 0; i < n; i ++ ) {
				for ( int j = 0 ; j < n ; j++ ) {
					if ( map[i][j] != 0 ) q.offer(new BlockLocation(i, j));
				}
			}
		}
		else if ( k == 0 ) {
			//큐에 블럭 담기 
			for ( int i = 0; i < n; i ++ ) {
				for ( int j = 0 ; j < n ; j++ ) {
					if ( map[i][j] != 0 ) q.offer(new BlockLocation(i, j));
				}
			}
		}
		else if ( k == 2 ) { 
			//큐에 블럭 담기 
			//행 거꾸로 
			for ( int i = n-1; i >= 0; i-- ) {
				for ( int j = 0 ; j < n ; j++ ) {
//					System.out.println(i + "," + j);
					if ( map[i][j] != 0 ) q.offer(new BlockLocation(i, j));
				}
			}
		}
		
		//해당 방향으로만 bfs 서치
		//빈공간이면 이동 
		while ( !q.isEmpty() ) {
			int curX = q.peek().x;
			int curY = q.poll().y;
				
			int nextX = curX + dx[k];
			int nextY = curY + dy[k];
//			if ( k == 1 ) {
//				System.out.println(curX + ","+ curY +"큐검사 ");
//				System.out.println(nextX+","+nextY);
//			}
//			printMap();
//			System.out.println();
			if ( isRange(nextX,nextY) ) {
				
				//빈 공간이라면 이동 
				if ( map[nextX][nextY] == 0 ) {
//					System.out.println("이동");
					map[nextX][nextY] = map[curX][curY];
					map[curX][curY] = 0;
					q.offer(new BlockLocation(nextX, nextY));
				}
				else if ( map[curX][curY] == map[nextX][nextY] && visited[curX][curY] == 0 && visited[nextX][nextY] == 0) { 
					
					//같은 숫자면 합치기 (대신 한번도 합친적이 없어야 한다.)
					map[nextX][nextY] += map[curX][curY];
					map[curX][curY] = 0;
					visited[nextX][nextY] = 1;
					q.offer(new BlockLocation(nextX, nextY));
				}
				else if ( map[curX][curY] != map[nextX][nextY]) {
//					System.out.println("탈출 ");
					continue;
					//다른 숫자면 이동불가 
					//같은 숫자인데 이미 합쳐져 있으면 이동불가 
				}
			}
		}//endBfs
		
		//
		
		
		
		
	}
	private static boolean isRange(int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = (0<=nextX && nextX < n) && ( 0<=nextY && nextY < n);
		return isRange;
	}
}
