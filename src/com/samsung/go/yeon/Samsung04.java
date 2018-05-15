package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Scanner;

//2048 
public class Samsung04 {
	
	static final int LIMIT = 5;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception{
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int n = sc.nextInt();
		
		int[][] a = new int[n][n];
		
		
		//map create
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < n; j ++ ) {
				a[i][j] = sc.nextInt();
			}
		}
		
		int ans = 0;
		//모든 경우 순회 ( 4^5 경우의 수 )
		for ( int k = 0 ; k < (1 << ( 2*LIMIT )); k++ ) {
			
			//k번째 경우의 해당 방향 정하기 
			int dir[] = gen(k);
			//이동후의 가장 큰 블럭 출력하기 
			int cur = check(a, dir);
			if ( ans < cur ) ans = cur;
		}//end for 
		
		System.out.println(ans);
		
			
		
		
	}

	private static int check(int[][] a, int[] dir) {
		// TODO Auto-generated method stub
		int n = a.length;
		int[][] d = new int[n][n];
		boolean[][] merged = new boolean[n][n];
		
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < n; j ++ ) {
				d[i][j] = a[i][j];
			}
		}
		
		//총 다섯번의 방향으로 움직인다 . 
		for ( int k : dir ) {
			boolean ok = false;
			for ( int i = 0 ; i < n; i ++ ) {
				for ( int j = 0 ; j < n; j ++ ) {
					merged[i][j] = false;
				}
			}
			
			while ( true ) {
				ok = false;
				if ( k == 0 ) {
					for ( int i = n-2; i >= 0; i -- ) {
						for ( int j = 0; j < n; j ++ ) {
							if ( d[i][j] == 0 ) continue;
							//이동할 위치에 0이있다면 그리로 이동 
							if ( d[i+1][j] == 0 ) {
								d[i+1][j] = d[i][j];
								merged[i+1][j] = merged[i][j];
								d[i][j] = 0;
								ok = true;
							} 
							else if ( d[i+1][j] == d[i][j] ) {
								if ( merged[i][j] == false && merged[i+1][j] == false ) {
									d[i+1][j] *= 2;
									merged[i+1][j] = true;
									d[i][j] = 0;
									ok = true;
								}
							}
						}
					}
					
				} else if ( k == 1 ) {
					for ( int i = 1; i < n; i ++ ) {
						for ( int j = 0; j < n; j ++ ) {
							if ( d[i][j] == 0 ) continue;
							//이동할 위치에 0이있다면 그리로 이동 
							if ( d[i-1][j] == 0 ) {
								d[i-1][j] = d[i][j];
								merged[i-1][j] = merged[i][j];
								d[i][j] = 0;
								ok = true;
							} else if ( d[i-1][j] == d[i][j] ) {
								if ( merged[i][j] == false && merged[i-1][j] == false ) {
									d[i-1][j] *= 2;
									merged[i-1][j] = true;
									d[i][j] = 0;
									ok = true;
								}
							}
						}
					}
					
				} else if ( k == 2 ) {
					for ( int j = 1; j < n; j ++ ) {
						for ( int i = 0; i < n; i ++ ) {
							if ( d[i][j] == 0 ) continue;
							//이동할 위치에 0이있다면 그리로 이동 
							if ( d[i][j-1] == 0 ) {
								d[i][j-1] = d[i][j];
								merged[i][j-1] = merged[i][j];
								d[i][j] = 0;
								ok = true;
							} else if ( d[i][j-1] == d[i][j] ) {
								if ( merged[i][j] == false && merged[i][j-1] == false ) {
									d[i][j-1] *= 2;
									merged[i][j-1] = true;
									d[i][j] = 0;
									ok = true;
								}
							}
						}
					}
				} else if ( k == 3 ) {
					for ( int j = n-2; j >= 0; j -- ) {
						for ( int i = 0; i < n; i ++ ) {
							if ( d[i][j] == 0 ) continue;
							//이동할 위치에 0이있다면 그리로 이동 
							if ( d[i][j+1] == 0 ) {
								d[i][j+1] = d[i][j];
								d[i][j] = 0;
								merged[i][j+1] = merged[i][j];
								ok = true;
								
							} 
							// 이동할 위치의 숫자와 같은데, 한번도 합쳐진적이 없다면 
							else if ( d[i][j+1] == d[i][j] ) {
								if ( merged[i][j] == false && merged[i][j+1] == false ) {
									d[i][j+1] *= 2;
									merged[i][j+1] = true;
									d[i][j] = 0;
									ok = true;
								}
							}
						}
					}
				}
				if ( ok == false) break;
			} //end while
		
		}//end dirs
		
		int ans = 0;
		for ( int i = 0; i < n; i ++ ) {
			for ( int j = 0; j < n; j ++ ) {
				if ( ans < d[i][j] ) ans = d[i][j]; 
			}
		}
		return ans;	
		
	}

	private static int[] gen(int k) {
		// TODO Auto-generated method stub
		int dir[] = new int[LIMIT];
		
		for ( int i = 0; i < dir.length; i ++ ) {
			
			dir[i] = (k&3);
			
			k >>= 2;
		}
		
		return dir;
	}

}
