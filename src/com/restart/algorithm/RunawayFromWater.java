package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Elements {
	int x;
	int y;

	public Elements(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class RunawayFromWater {
	
	public static int[] S = new int[2]; //고슴도치 위치배열 
	public static int[] D = new int[2]; //탈출동굴 위치배열 
	public static int[][] map;
	public static int n;
	public static int m;
	
	public static final int HEDGEHOG = 1;
	public static final int WATER = -1;
	public static final int ROCK = -2;
	public static final int CAVE = -3;
	
	public static LinkedList<Elements> water = new LinkedList<>();
	
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("runaway.txt"));

		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		
		String line = "";
		char ch;
		int k;
		
		for ( int i = 0; i < n; i ++ ) {
			
			line = sc.next();
			
			for ( int j = 0; j < m ; j ++ ) {
				
				ch = line.charAt(j);
				
				if ( ch == 'S' ) {
					S[0] = i;
					S[1] = j;
					k = HEDGEHOG;
				}else if ( ch == 'D' ){
					D[0] = i;
					D[1] = j;
					k = CAVE;
				}else if ( ch == '*' ){
					water.add(new Elements(i, j));
					k = WATER;
				}else if ( ch == 'X' ){
					k = ROCK;
				}else { //땅 ch = '.'
					k = 0;
				}
					
				map[i][j] = k;
				
			}
		}
//		printMap();
		//탈출하면 true
		//탈출하지 못하면 false
		boolean isEscape = bfs();
//		printMap();
		
		if ( isEscape ) {
			System.out.println( map[D[0]][D[1]] - 1 );
		}else {
			System.out.println( "KAKTUS" );
		}
		
	}

	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < m ;j++ ) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean bfs() {
		// TODO Auto-generated method stub
		Queue<Elements> q = new LinkedList<>();
		
		//시작점 q에 등록 
		q.offer(new Elements(S[0], S[1]));
		
		//물이 여러곳있을 수 있다. 
		//물의 시작 좌표들을 q에 등록 
		for ( Elements e : water ) {
			q.offer( new Elements(e.x, e.y) );
		}

		//벡터
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		while ( !q.isEmpty() ) {
			int x = q.peek().x;
			int y = q.poll().y;
			
			int cur = map[x][y];
			
			for ( int i = 0 ; i < 4; i ++ ) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if ( isRange(nextX, nextY) ) {
					//퍼져나가는 정보 
					//cur 가 물이면 물로 퍼지고 ,
					//그게 아니면 고슴도치밖에 없다. 고슴도치는 cur+1 (이동 수 증가)
					int spread = nextSpread(cur);
					
					//이동할 곳의 상태 
					int nextState = map[nextX][nextY];
					
					//물은 바위, 동굴, 물 (중복탐색 배제) 을 제외하고 퍼져 나감. 
					if( spread == WATER && ( nextState != ROCK && nextState != WATER && nextState != CAVE ) ) {
						map[nextX][nextY] = WATER;
						q.offer(new Elements(nextX, nextY));
					}
					//고슴도치는 땅(0), 최단거리 갱신, 동굴이면 퍼져나감
					else if ( spread > 0 && ( nextState == 0 || nextState > spread || nextState == CAVE ) ) {
						map[nextX][nextY] = spread;
						q.offer(new Elements(nextX, nextY));
					}
					
					//동굴의 값이 변했다 -> 고슴도치가 들어갔으면 true  , 아니면 false
					if ( map[D[0]][D[1]] != CAVE ) return true;
					
				}
				
			}
		}
		
		
		return false; //bfs다 돌았는데 동굴갱신이 안된거면 false로 리턴 
	}

	private static int nextSpread(int cur) {
		// TODO Auto-generated method stub
		int ret = 0;
		if ( cur == WATER ) ret = WATER;
		else { 
			ret = cur + 1;
		}
		
		return ret;
	}

	private static boolean isRange(int x, int y) {
		// TODO Auto-generated method stub
		boolean isRange = ( 0<= x && x < n ) && ( 0<=y && y < m );
		return isRange;
	}
	
	
	
	
	
}
