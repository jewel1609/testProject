package ebay.yeon.quest;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class tomatoLocation {
	int x;
	int y;
	int z;
	
	public tomatoLocation (int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Tomato {
	static int n;
	static int m;
	static int h;
	static int[][][] map;
	static Queue<tomatoLocation> q = new LinkedList<>();
	public static void main(String[] args) throws Exception  {
		Scanner sc = new Scanner(new FileInputStream("tomato.txt"));
		
		//열 
		m = sc.nextInt();
		//행 
		n = sc.nextInt();
		
		//높이 
		h = sc.nextInt();
		map = new int[n][m][h];
		int count = 0;
		//1 익은 토마토 
		//0 익지않은 토마토
		//-1 벽 
		while ( h > count ) {
			for ( int i = 0; i < n;i ++ ) {
				for ( int j = 0 ; j < m; j++ ) {
					map[i][j][count] = sc.nextInt();
					if ( map[i][j][count] == 1 ) {
						q.offer(new tomatoLocation(i, j, count)); 
					}
				}
			}
			count++;
		}//end while
//		System.out.println("endWhile");
		bfs();
		
//		printMap();
		System.out.println(searchTomato()-1);
		
	}
	private static void printMap() {
		// TODO Auto-generated method stub	
		int count = 0;
		while ( h > count ) {
			for ( int i = 0; i < n;i ++ ) {
				for ( int j = 0 ; j < m; j++ ) {
					System.out.print(map[i][j][count] + " ");
				}
				System.out.println();
			}
			System.out.println();
			count++;
		}//end while
	}
	
	private static int searchTomato() {
		// TODO Auto-generated method stub
		int count = 0;
		int max = 0;
		while ( h > count ) {
			for ( int i = 0; i < n;i ++ ) {
				for ( int j = 0 ; j < m; j++ ) {
					if ( map[i][j][count] == 0 ) return 0;
					else if ( map[i][j][count] > max ) max = map[i][j][count];
				}
			}
			count++;
		}//end while
		
		return max;
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		int[] dx = { -1, 0, 1, 0, 0, 0 };
		int[] dy = { 0, 1, 0, -1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, -1, 1 };
		
		while ( !q.isEmpty() ) {
			int x = q.peek().x;
			int y = q.peek().y;
			int z = q.poll().z;
			
			for (int i = 0 ; i < 6; i ++) {
				int nextX = x + dx[i];
				int nextY = y + dy[i];
				int nextZ = z + dz[i];
				
				if ( isRange(x,y,z,nextX, nextY, nextZ) ) {
					map[nextX][nextY][nextZ] = map[x][y][z] + 1;
					q.offer(new tomatoLocation(nextX, nextY, nextZ));
				}
			}
		}
		
		
		
		
		
	}
	private static boolean isRange(int x, int y, int z, int nextX, int nextY, int nextZ) {
		// TODO Auto-generated method stub
		boolean isRange = (0<= nextX && nextX < n) && ( 0<=nextY && nextY < m) && ( 0<=nextZ && nextZ < h);
		return isRange && ( map[nextX][nextY][nextZ] == 0 || map[x][y][z] + 1 < map[nextX][nextY][nextZ] );
	}
}
