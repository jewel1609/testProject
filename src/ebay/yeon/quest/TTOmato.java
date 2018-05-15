package ebay.yeon.quest;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {
	int x;
	int y;
	
	public Location(int x, int y ) {
		this.x = x;
		this.y = y;
	}
}


public class TTOmato {
	static int n;
	static int m;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1}; 
	static int[] dy = {-1, 1, 0, 0}; 
	static Queue<Location> q = new LinkedList<>();
	static int max = 0;
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("tomato.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[m][n];
		
		for ( int i = 0 ; i < m; i ++ ) {
			for ( int j = 0 ; j < n; j ++ ) {
				map[i][j] = sc.nextInt();
				if ( map[i][j] == 1 )
					q.offer(new Location(i, j));
			}
		}
		
		bfs();
		
		System.out.println(returnMax() - 1);
		
		
		
	}
	private static int returnMax() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < m; i ++ ) {
			for ( int j = 0 ;j < n; j ++ ) {
				if ( map[i][j] == 0 ) return 0;
				if ( map[i][j] > max ) max = map[i][j];
			}
		}
		return max;
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		//q의 좌표를 뽑아낸다. 
		
		while ( !q.isEmpty() ) {
			
			int x = q.peek().x;
			int y = q.poll().y;
			
			for ( int i = 0 ; i < 4; i ++ ) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				
				if ( isRange(x,y,nextX,nextY) ) {
					q.offer(new Location(nextX, nextY));
					map[nextX][nextY] = map[x][y] + 1;
				}
				
			}
			
			
			
			
		}//q가 없어지면 탈출 
		
		
		
		
	}
	private static boolean isRange(int x, int y, int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = (0<=nextX && nextX < m) && ( 0<=nextY && nextY < n );
		return isRange && ( map[nextX][nextY] == 0 || map[x][y] + 1 < map[nextX][nextY] );
	}

}
