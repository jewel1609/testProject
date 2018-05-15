package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Samsung05 {

	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };
	static int[] dice;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int n = sc.nextInt();
		int m = sc.nextInt();

		int x = sc.nextInt();
		int y = sc.nextInt();

		int k = sc.nextInt();

		int[][] map = new int[n][m];
		int[] dirs = new int[k];
		dice = new int[6];

		// dice create
		for (int i = 0; i < dice.length; i++) {
			Arrays.fill(dice, 0);
		}

		// map create
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			dirs[i] = sc.nextInt();
		}

		// 해당 방향으로 k만큼 움직인다. 움직일때마다 주사위 위의 숫자출력
		for (int dir : dirs) {

			// 주사위 이동할 위치 
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			// 벗어날
			if (nx >= n || ny >= m || nx < 0 || ny < 0) {
				continue;
			} 
			
			diceCheck(dir);
			// 맵에 0 이라면 주사위 바닥면에 써있는 칸의 수가 복사된다.
			if (map[nx][ny] == 0) {
				map[nx][ny] = dice[5];
			} else if (map[nx][ny] != 0) {
				// 0이 아닌 경우에는 칸에 써 있는 수가 주사위의 바닥면으로 복사되며, 칸에 써 있는 수는 0이 된다.
				dice[5] = map[nx][ny];
				map[nx][ny] = 0;
			}
			//위치 변경 
			x = nx;
			y = ny;
			System.out.println(dice[0]);

		}

	}

	private static void diceCheck(int dir) {
		// TODO Auto-generated method stub
		// east
		if (dir == 1) {
			int temp = dice[0];
			dice[0] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[2];
			dice[2] = temp;
		} else if (dir == 2) {
			int temp = dice[0];
			dice[0] = dice[2];
			dice[2] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;

		} else if (dir == 3) {
			// north
			int temp = dice[0];
			dice[0] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[1];
			dice[1] = temp;

		} else if (dir == 4) {
			int temp = dice[0];
			dice[0] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
		}
		
	}

}
