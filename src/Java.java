import java.util.Scanner;

public class Java {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int board[][];
		int n;
		int result = 0;
		n = scan.nextInt();
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = scan.nextInt();
			}
		}

		result = solution(board);

		System.out.println(result);

	}

	public static int solution(int[][] board) {
		int answer = 0;
		boolean possibleSquare;
		int size = 1;
		int k = 1;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 1) {
					k =1;
					while (i + k < board.length || j + k < board.length) {

						if (board[i + k][j + k] == 1) {
							possibleSquare = check(i, j, i + k, board);
							if (possibleSquare == true) {
								size = k;
								k++;
							}
						}
					}
				}
			}
		}

		answer = size * size;

		return answer;
	}

	private static boolean check(int i, int j, int k, int[][] board) {
		// TODO Auto-generated method stub
		for (int m = i; m <= k; m++) {
			for (int p = j; p <= k; p++) {
				if (board[m][p] == 0) {
					return false;
				} else {
					return true;
				}
			}
		}
		return true;
	}
}
