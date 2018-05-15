package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; 
class TetPair {
	int x;
	int y;
	public TetPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class TetrisGame {
	static int n;
	static int m;
	static int[][] map;
	static int max = 0;
	static List<ArrayList<TetPair>> tetBlocks;
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("tetris.txt"));
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		
		//좌표 네개를 리스트에 담으면 한조각 
		ArrayList<TetPair> p1 = new ArrayList<>();
		ArrayList<TetPair> p2 = new ArrayList<>();
		ArrayList<TetPair> p3 = new ArrayList<>();
		
		ArrayList<TetPair> n1 = new ArrayList<>();
		ArrayList<TetPair> n2 = new ArrayList<>();
		ArrayList<TetPair> n3 = new ArrayList<>();
		ArrayList<TetPair> n4 = new ArrayList<>();
		ArrayList<TetPair> n5 = new ArrayList<>();
		ArrayList<TetPair> n6 = new ArrayList<>();
		ArrayList<TetPair> n7 = new ArrayList<>();
		ArrayList<TetPair> n8 = new ArrayList<>();
		
		ArrayList<TetPair> r1 = new ArrayList<>();
		ArrayList<TetPair> r2 = new ArrayList<>();
		ArrayList<TetPair> r3 = new ArrayList<>();
		ArrayList<TetPair> r4 = new ArrayList<>();

		ArrayList<TetPair> t1 = new ArrayList<>();
		ArrayList<TetPair> t2 = new ArrayList<>();
		ArrayList<TetPair> t3 = new ArrayList<>();
		ArrayList<TetPair> t4 = new ArrayList<>();
		
		
		//스페이스 가
		p1.add(new TetPair(0, 0));
		p1.add(new TetPair(0, 1));
		p1.add(new TetPair(0, 2));
		p1.add(new TetPair(0, 3));
		//스페이스 세로 
		p2.add(new TetPair(0, 0));
		p2.add(new TetPair(1, 0));
		p2.add(new TetPair(2, 0));
		p2.add(new TetPair(3, 0));
		//네모 
		p3.add(new TetPair(0, 0));
		p3.add(new TetPair(0, 1));
		p3.add(new TetPair(1, 0));
		p3.add(new TetPair(1, 1));
		//니은 1
		n1.add(new TetPair(0, 0));
		n1.add(new TetPair(1, 0));
		n1.add(new TetPair(2, 0));
		n1.add(new TetPair(2, 1));
		//2
		n2.add(new TetPair(0, 0));
		n2.add(new TetPair(1, 0));
		n2.add(new TetPair(2, 0));
		n2.add(new TetPair(2, -1));
		//3
		n3.add(new TetPair(0, 0));
		n3.add(new TetPair(1, 0));
		n3.add(new TetPair(2, 0));
		n3.add(new TetPair(0, 1));
		//4
		n4.add(new TetPair(0, 0));
		n4.add(new TetPair(1, 0));
		n4.add(new TetPair(2, 0));
		n4.add(new TetPair(0, -1));
		//5
		n5.add(new TetPair(0, 0));
		n5.add(new TetPair(0, 1));
		n5.add(new TetPair(0, 2));
		n5.add(new TetPair(1, 0));
		//6
		n6.add(new TetPair(0, 0));
		n6.add(new TetPair(0, 1));
		n6.add(new TetPair(0, 2));
		n6.add(new TetPair(-1, 0));
		//7
		n7.add(new TetPair(0, 0));
		n7.add(new TetPair(0, 1));
		n7.add(new TetPair(0, 2));
		n7.add(new TetPair(1, 2));
		//8
		n8.add(new TetPair(0, 0));
		n8.add(new TetPair(0, 1));
		n8.add(new TetPair(0, 2));
		n8.add(new TetPair(-1, 2));
		
		//r1
		r1.add(new TetPair(0, 0));
		r1.add(new TetPair(1, 0));
		r1.add(new TetPair(1, 1));
		r1.add(new TetPair(2, 1));
		//r2
		r2.add(new TetPair(0, 0));
		r2.add(new TetPair(1, 0));
		r2.add(new TetPair(1, -1));
		r2.add(new TetPair(2, -1));
		//r3
		r3.add(new TetPair(0, 0));
		r3.add(new TetPair(0, 1));
		r3.add(new TetPair(-1, 1));
		r3.add(new TetPair(-1, 2));
		//r4
		r4.add(new TetPair(0, 0));
		r4.add(new TetPair(0, 1));
		r4.add(new TetPair(1, 1));
		r4.add(new TetPair(1, 2));
		
		//t1
		t1.add(new TetPair(0, 0));
		t1.add(new TetPair(1, 0));
		t1.add(new TetPair(2, 0));
		t1.add(new TetPair(1, -1));
		//t2
		t2.add(new TetPair(0, 0));
		t2.add(new TetPair(1, 0));
		t2.add(new TetPair(2, 0));
		t2.add(new TetPair(1, 1));
		//t3
		t3.add(new TetPair(0, 0));
		t3.add(new TetPair(0, 1));
		t3.add(new TetPair(0, 2));
		t3.add(new TetPair(-1, 1));
		//t4
		t4.add(new TetPair(0, 0));
		t4.add(new TetPair(0, 1));
		t4.add(new TetPair(0, 2));
		t4.add(new TetPair(1, 1));
		

		tetBlocks = new ArrayList<>();
		tetBlocks.add(p1);
		tetBlocks.add(p2);
		tetBlocks.add(p3);
		
		tetBlocks.add(n1);
		tetBlocks.add(n2);
		tetBlocks.add(n3);
		tetBlocks.add(n4);
		tetBlocks.add(n5);
		tetBlocks.add(n6);
		tetBlocks.add(n7);
		tetBlocks.add(n8);
		
		tetBlocks.add(r1);
		tetBlocks.add(r2);
		tetBlocks.add(r3);
		tetBlocks.add(r4);
		
		tetBlocks.add(t1);
		tetBlocks.add(t2);
		tetBlocks.add(t3);
		tetBlocks.add(t4);
		
		for ( int i = 0 ; i < n; i ++ ) { 
			for ( int j = 0 ; j < m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//4개 
//		int x = tetBlocks.get(0).get(i).x;
//		int y = tetBlocks.get(0).get(i).y;
		
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m ;j ++ ) {
				//i , j 시작 지점 
				for ( int k = 0 ; k < tetBlocks.size(); k ++ ) {
					dfs(i, j, 0, 0, k);
				}
			}
		}

		System.out.println(max);
		
	}
	private static void dfs(int x, int y, int sum, int idx, int k) {
		// TODO Auto-generated method stub
		//x,y를 중심으로 
		//네조각 더하기 
		for ( idx = 0; idx< 4; idx++  ){
			if ( isRange(x + tetBlocks.get(k).get(idx).x, y + tetBlocks.get(k).get(idx).y) ){
				sum += map[x + tetBlocks.get(k).get(idx).x][y + tetBlocks.get(k).get(idx).y];
			}
		}
		if ( max < sum ) max = sum;
		return;
	}
	private static boolean isRange(int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = (0<=nextX && nextX < n ) && ( 0<=nextY && nextY < m);
		return isRange;
	}
}
