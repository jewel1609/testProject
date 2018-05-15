package com.baekjoon.yeon;

public class kakao07 {
	public static void main(String[] args) {
		
		int m =4 ;
		int n = 5 ;
		String[] board = new String[m];
		board[0] = "CCBDE";
		board[1] = "AAADE";  
		board[2] = "AAABF";
		board[3] = "CCBBF";
		
		int result = solution(m, n, board);
		
	}

	private static int solution(int m, int n, String[] board) {
		
		int answer = 0;
		
		 String map[][] = new String[m][n];
		 int map2[][] = new int[m][n];
		 boolean moveDown = true;
		 int count = 0;
         
	      
	      // 맵 구성 
	      for ( int i = 0; i < m; i ++ ) {
	    	  for ( int j = 0; j < n; j ++ ) {
	    		  String text = board[i].charAt(j)+ "";
	    		  map[i][j] =  text;
	    	  }
	      }
	      
	      //실행 로직 
	      for ( int i = 0; i < m; i ++ ) {
	    	  for ( int j = 0; j < n; j ++ ) {
	    		  bfs(m, n, i, j, map, map2, moveDown, count);
	    	  }
	      }
	      
	      for ( int i = 0; i < m; i ++ ) {
	    	  for ( int j = 0; j < n; j ++ ) {
	    		  if ( map2[i][j] == 1 ) {
	    			  count++;
	    			  map2[i][j] = 0;
	    			  map[i][j] = " ";
	    		  }
	    		  
	    	  }
	      }
	      
	      
	      
	      //맵표시 
	      for ( int i = 0; i < m; i ++ ) {
	    	  for ( int j = 0; j < n; j ++ ) {
	    		  System.out.print(map[i][j]);
	    	  }
	    	  System.out.println();
	      }
	      
	      
	      System.out.println(count);
	      
	      return answer;
	}

	private static int bfs(int m, int n, int x, int y, String[][] map, int[][] map2, boolean moveDown, int count) {
		// TODO Auto-generated method stub
		if ( moveDown == false ) {
			return count;
		}
		
		if ( x+1 < m &&y+1 < n && map[x][y+1].equals(map[x][y]) && map[x+1][y].equals(map[x][y]) && map[x+1][y+1].equals(map[x][y])) {
			map2[x][y+1] = 1;
			map2[x][y] = 1;
			map2[x+1][y] = 1;
			map2[x+1][y+1] = 1;
		}
		
		if ( x+1 < m &&y+1 < n && map[x][y+1].equals(" ")  ) {
			map[x][y+1] = map[x][y];
			map[x][y] = " ";
		}
		
		
		
		
		return count;
	}
}
