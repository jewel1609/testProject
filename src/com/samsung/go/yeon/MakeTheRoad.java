package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Scanner;

public class MakeTheRoad {
	static int n;
	static int l;
	static int[][] map;
	static int[][] visited;
	static int ret = 0;

	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("makeTheRoad.txt"));

		n = sc.nextInt();
		l = sc.nextInt();
		map = new int[n][n];
		visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 가로 탐색
		for (int i = 0; i < n; i++) {
			visitedSetting();
			possibleMakeTheRoadX(i, 0);
		}

		// 세로 탐색

		for (int i = 0; i < n; i++) {
			visitedSetting();
			possibleMakeTheRoadY(0, i);
		}

		System.out.println(ret);

	}

	private static void visitedSetting() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = 0;
			}
		}
	}

	private static void possibleMakeTheRoadY(int x, int y) {
		// TODO Auto-generated method stub
		// 행 이동
		// 시작점 0,i
		// 끝점 n-1,i
//		System.out.println(x + "," + y);
		if (x == n - 1) {
			// 무사히 길 통과
//			System.out.println(x + "," + y);
			ret += 1;
			return;
		}
		// 다음 길의 위치가 높이가 똑같으면 이동
		if (map[x][y] == map[x+1][y]) {
			possibleMakeTheRoadY(x+1, y);
		} else if (map[x][y] - map[x+1][y] >= 2 || map[x][y] - map[x+1][y] <= -2) {
			// 다음 길의 높이와 2이상 차이나면 못감 ( 길 못만듬 )
			return;
		} else {
			// 높이 차이가 1이면 경사로를 만들어야 한다.

			// 다음 길의 높이가 1 높을 때 (위 경사로 제작해야 함 )
			if (map[x][y] < map[x+1][y]) {
				boolean flag = true;
				// 길이 l만큼 공간이 있어야 만들 수 있다.
				for (int i = 0; i < l; i++) {
					if (!isRange(x-i, y)) {
						// 범위를 벗어나면 경사로 못만듬.
						return;
					} else {
						// 범위 안에 존재
						if (visited[x-i][y] == 1 || map[x][y] != map[x-i][y]) {
							flag = false;
						}
					}
				}

				// 범위안에 있으면서 경사로 면의 높이가 다 같으면
				// 경사로 제작
				if (flag) {
					for (int i = 0; i < l; i++) {
						visited[x-i][y] = 1;
					} // 제작 완료
						// 이동
					possibleMakeTheRoadY(x+1, y);
				}
			} else if (map[x][y] > map[x+1][y]) {
				// 다음 길의 높이가 1 낮을 때 (아래 경사로 제작해야함 )
				boolean flag = true;
				// 길이 l만큼 공간이 있어야 만들 수 있다.
				int k = map[x+1][y];
				for (int i = 1; i <= l; i++) {
					if (!isRange(x+i, y)) {
						// 범위를 벗어나면 경사로 못만듬.
						return;
					} else {
						// 범위 안에 존재
						if (visited[x+i][y] == 1 || k != map[x+i][y]) {
							flag = false;
						}
					}
				}

				// 범위안에 있으면서 경사로 면의 높이가 다 같으면
				// 경사로 제작
				if (flag) {
					for (int i = 1; i <= l; i++) {
						visited[x+i][y] = 1;
					} // 제작 완료
						// 이동
					possibleMakeTheRoadY(x+l, y);
				}
			}
		}

	}

	private static void possibleMakeTheRoadX(int x, int y) {
		// TODO Auto-generated method stub
		// 열 이동
		// 시작점 i, 0
		// 끝점 i,n-1
//		System.out.println(x+","+y + "이동중 ");
		if (y == n - 1) {
			// 무사히 길 통과
//			System.out.println(x + "," + y);
			ret += 1;
			return;
		}
		// 다음 길의 위치가 높이가 똑같으면 이동
		if (map[x][y] == map[x][y + 1]) {
			possibleMakeTheRoadX(x, y + 1);
		} else if (map[x][y] - map[x][y + 1] >= 2 || map[x][y] - map[x][y + 1] <= -2) {
			// 다음 길의 높이와 2이상 차이나면 못감 ( 길 못만듬 )
			return;
		} else {
			// 높이 차이가 1이면 경사로를 만들어야 한다.

			// 다음 길의 높이가 1 높을 때 (위 경사로 제작해야 함 )
			if (map[x][y] < map[x][y + 1]) {
				boolean flag = true;
				// 길이 l만큼 공간이 있어야 만들 수 있다.
				for (int i = 0; i < l; i++) {
					if (!isRange(x, y - i)) {
						// 범위를 벗어나면 경사로 못만듬.
						return;
					} else {
						// 범위 안에 존재
						if (visited[x][y - i] == 1 || map[x][y] != map[x][y - i]) {
							flag = false;
						}
					}
				}

				// 범위안에 있으면서 경사로 면의 높이가 다 같으면
				// 경사로 제작
				if (flag) {
					for (int i = 0; i < l; i++) {
						visited[x][y - i] = 1;
					} // 제작 완료
						// 이동
					possibleMakeTheRoadX(x, y + 1);
				}
			} else if (map[x][y] > map[x][y + 1]) {
				// 다음 길의 높이가 1 낮을 때 (아래 경사로 제작해야함 )
				boolean flag = true;
				int k = map[x][y+1];
				// 길이 l만큼 공간이 있어야 만들 수 있다.
				for (int i = 1; i <= l; i++) {
					if (!isRange(x, y + i)) {
						// 범위를 벗어나면 경사로 못만듬.
						return;
					} else {
						// 범위 안에 존재
						if (visited[x][y + i] == 1 || k != map[x][y + i]) {
							flag = false;
						}
					}
				}

				// 범위안에 있으면서 경사로 면의 높이가 다 같으면
				// 경사로 제작
				if (flag) {
					for (int i = 1; i <= l; i++) {
						visited[x][y + i] = 1;
					} // 제작 완료
						// 이동
					possibleMakeTheRoadX(x, y + l);
				}
			}
		}

	}

	private static boolean isRange(int x, int y) {
		// TODO Auto-generated method stub
		boolean isRange = (0 <= x && x < n) && (0 <= y && y < n);
		return isRange;
	}
}
