package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Scanner;

public class MoveBallGame {
	static int n;
	static int m;
	static String[][] map;
	static String[][] tempMap;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int min = 0x7fffffff;
	static int[] dir;
	static int rx, ry;
	static int bx, by;
	static int ret;
	static boolean minFlag = false;
	static boolean redGoal = false;
	static boolean blueGoal = false;
	//더이상 움직일수 없다. 
	static boolean fullMove = false;
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("moveBall.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new String[n][m];
		tempMap = new String[n][m];
		dir = new int[10];
		for ( int i = 0 ; i < n ; i++ ) {
			map[i] = sc.next().split("");
		}
		
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m;j ++ ) {
				tempMap[i][j] = map[i][j];
			}
		}
				
//		printMap();
		
		//기울이기 세팅 
		dfs("", -1);
		
//		System.out.println(goGame());
		if ( minFlag ) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
		
	}
	private static int goGame() {
		// TODO Auto-generated method stub
		int cnt = 0;
		//공의 위치 초기화
		for ( int i = 0 ; i < n;i ++ ) {
			for ( int j = 0 ; j < m;j++ ) {
				if ( map[i][j].equals("B")) {
					bx = i;
					by = j;
//					System.out.println("블루 공 " + bx +","+ by);
				}else if ( map[i][j].equals("R")) {
					rx = i;
					ry = j;
				}
			}
		}
		
//		//test Dir
//		int []dir2 = new int[2];
//		dir2[0] = 1;
//		dir2[1] = 2;
		
		
		//방향 순회 
		for ( int k : dir ) {
//			System.out.println(k + "현재방향 ");
			cnt++;
			//기울이면 해당방향으로 벽을 만날때 까지 이동. 
			for ( int i = 0 ; i < 2; i ++ ) {
				moveRed(k);
				moveBlue(k);
			}
//			System.out.println("기울인 후 의 맵 상태 ");
//			printMap();
//			System.out.println(cnt);
//			if ( redGoal && blueGoal ) return -1;
			if ( blueGoal ) return -1;
			//성공 
			if ( redGoal && !blueGoal) {
//				System.out.println(blueGoal);
//				System.out.println("성공");
				return cnt;
			}
			
		}
		
		return -1;
	}
	private static void moveBlue(int k) {
		// TODO Auto-generated method stub
		int curRx = bx;
		int curRy = by;
		boolean flag = false;
		while ( true ) {
			int nextRx = curRx + dx[k];
			int nextRy = curRy + dy[k];
			
			if ( canOut(nextRx, nextRy) ) {
				flag = true;
				blueGoal = true;
				//골인
				map[curRx][curRy] = ".";
				//좌표 이동 
				curRx = nextRx;
				curRy = nextRy;
			}
			else if ( isRange(nextRx, nextRy)) {
				//공 이동
				String temp = map[curRx][curRy];
				map[nextRx][nextRy] = temp;
				map[curRx][curRy] = ".";
				//좌표 이동 
				curRx = nextRx;
				curRy = nextRy;
			}else { //벽만나면 
				flag = true;
			}
			
			if ( flag ) {
				bx = curRx;
				by = curRy;
				break;
			}
		}
	}
	private static void moveRed(int k) {
		// TODO Auto-generated method stub
		int curRx = rx;
		int curRy = ry;
//		System.out.println(curRx + "," + curRy +"빨간공 좌표 ");
		boolean flag = false;
		while ( true ) {
			int nextRx = curRx + dx[k];
			int nextRy = curRy + dy[k];
//			System.out.println(nextRx + "," + nextRy +"빨간공 좌표 ");
//			System.out.println(map[nextRx][nextRy]);
			
			if ( canOut(nextRx, nextRy) ) { //탈출 
				flag = true;
				redGoal = true;
				//골인
				map[curRx][curRy] = ".";
				//좌표 이동 
				curRx = nextRx;
				curRy = nextRy;
			}
			else if ( isRange(nextRx, nextRy)) {
//				System.out.println("이동하자 ");
				//공 이동
				String temp = map[curRx][curRy];
//				System.out.println(temp + "좌표 " + curRx +","+curRy);
				map[nextRx][nextRy] = temp;
				map[curRx][curRy] = ".";
				//좌표 이동 
				curRx = nextRx;
				curRy = nextRy;
			}else { //벽이나 다른공 만나면 
				flag = true;
			}
			
			if ( flag ) {
				rx = curRx;
				ry = curRy;
				break;
			}
		}
	}
	private static boolean canOut(int nextRx, int nextRy) {
		// TODO Auto-generated method stub
		boolean isRange = (0<=nextRx && nextRx < n) && ( 0<=nextRy && nextRy < m );
		return isRange && ( map[nextRx][nextRy].equals("O"));
	}
	private static boolean isRange(int nextRx, int nextRy) {
		// TODO Auto-generated method stub
		boolean isRange = (0<= nextRx && nextRx < n) && ( 0<= nextRy && nextRy < m);
		return isRange && (map[nextRx][nextRy].equals("."));
	}
	
	private static void dfs(String str, int curDir) {
		// TODO Auto-generated method stub
		if ( str.length() == 10 ) {
//			System.out.println(str);
			//방향 세팅 
			for ( int i = 0 ; i < 10; i ++ ) {
				dir[i] = Integer.parseInt(str.charAt(i)+"");
			}
			//맵 세팅 
			for ( int i = 0 ; i < n; i ++ ) {
				for ( int j = 0 ; j < m;j ++ ) {
					map[i][j] = tempMap[i][j];
				}
			}
			//공 불린값 초기화 
			redGoal = false;
			blueGoal = false;
			//방향대로 게임 돌리기 
			ret = goGame();
			if ( ret != -1 ) {
				//탈출 
				minFlag = true;
				if ( min > ret ) min = ret;
			}
			return;
		}else {
			
			if ( curDir != 0 && curDir != 2 ) {
				dfs(str+"0", 0);
				dfs(str+"2", 2);
			}
			if ( curDir != 1 && curDir != 3 ) {
				dfs(str+"1", 1);
				dfs(str+"3", 3);
			}
		}
	}
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n; i++ ) {
			for ( int j = 0; j < m;j ++ ) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
