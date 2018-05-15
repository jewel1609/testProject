
public class Quest004_SquareSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] board = new int[4][4];
		
		board[0][0] = 0;
		board[0][1] = 1; 
		board[0][2] = 1; 
		board[0][3] = 1; 
		
		board[1][0] = 1;
		board[1][1] = 1; 
		board[1][2] = 1; 
		board[1][3] = 1;
		
		board[2][0] = 1;
		board[2][1] = 1; 
		board[2][2] = 1; 
		board[2][3] = 1;
		
		board[3][0] = 0;
		board[3][1] = 0; 
		board[3][2] = 1; 
		board[3][3] = 0;
		
		int result = solution(board);
		
		System.out.println(result);
		
		
		
	}
	
	public static int solution(int[][] board) {

        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == 0) continue;

                if ((i - 1 >= 0 && board[i - 1][j] > 0)
                        && (j - 1 >= 0 && board[i][j - 1] > 0)
                        && (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] > 0)) {

                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                }

                answer = answer < board[i][j] ? board[i][j] : answer;
            }
        }
        return answer * answer;
	}

}
