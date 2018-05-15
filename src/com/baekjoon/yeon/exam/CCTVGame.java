package com.baekjoon.yeon.exam;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class TvLocation {
	int x;
	int y; 
	int type;
	int dir;
	
	public TvLocation ( int x, int y, int type, int dir ) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.dir = dir;
	}
}


public class CCTVGame {
	
	static int[] dx = { -1, 0, 1,0 };
	static int[] dy = { 0, 1, 0,-1 };
	static int n;
	static int m;
	static int[][] map;
	static int[][] tempMap;
	static int[][] visited;
	static int[] dirs;
	static int min = Integer.MAX_VALUE;
	static Queue<TvLocation> q;
	static Stack<TvLocation> tempQ;
	static int tvCount = 0;
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("cctvGame.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		tempMap = new int[n][m];
		visited = new int[n][m];
		q = new LinkedList<>();
		tempQ = new Stack<>();
		
		for ( int i = 0 ; i < n ; i ++ ) {
			for ( int j = 0 ; j < m; j++ ) {
				map[i][j] = sc.nextInt();
				tempMap[i][j] = map[i][j]; 
				if ( map[i][j] != 0 && map[i][j] != 6 ) {
					q.offer(new TvLocation(i, j, map[i][j], 0));
					tempQ.add(new TvLocation(i, j, map[i][j], 0));
					tvCount++;
				}
				
			}
		}
		
		dirs = new int[tvCount];
		
//		printMap();
		
		dfs("");
		
		System.out.println(min);
		
		
	}
	private static void printVisited() {
		// TODO Auto-generated method stub
		int count = 0;
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m;j++ ) {
				if ( visited[i][j] == 0 ) count++;
//				System.out.print(visited[i][j] + " ");
			}
//			System.out.println();
		}
//		System.out.println(count);
		if ( count < min ) min = count;
		
	}
	private static void dfs(String str) {
		// TODO Auto-generated method stub
		if ( str.length() == tvCount ) {
//			System.out.println(str);
			
			
			dirs = new int[tvCount];
			//dirs세팅 
			for ( int i = 0 ; i < tvCount; i ++ ) {
				dirs[i] = Integer.parseInt(str.charAt(i)+"");
			}
			
			//map 초기화 
			for ( int i = 0 ; i < n; i ++ ) {
				for ( int j = 0 ; j < m;j++ ) {
					map[i][j] = tempMap[i][j];
					visited[i][j] = tempMap[i][j];
				}
			}
			
			//q 다시 세팅 
			q.clear();
			for ( int i = 0 ; i < tvCount; i ++ ) {
				q.offer(new TvLocation(tempQ.get(i).x,tempQ.get(i).y, tempQ.get(i).type, dirs[i]));
			}
			
			bfs();
			printVisited();
//			System.out.println();
			return;
		}else {
			for ( int i = 0 ; i < 4; i ++ ) {
				dfs(str+(i+""));
			}
		}
		
		
		
	}
	private static void bfs() {
		// TODO Auto-generated method stub
		
		//dirs
		//num 1~5 까지 있다. 
		while ( !q.isEmpty() ) {
			
			int curX = q.peek().x;
			int curY = q.peek().y;
			int num = q.peek().type;
			int dir = q.poll().dir;
			
			if ( num == 1 ) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir];
				if ( isRange(nextX,nextY) ) {
					if ( map[nextX][nextY] >= 0 && map[nextX][nextY] <= 5 ) {
						visited[nextX][nextY] = -1;
						q.offer(new TvLocation(nextX, nextY, num, dir));
					}
				}
				
			}else if ( num == 2 ) {
				
				int nextX = curX;
				int nextY = curY;
				
				if ( dir == 0 || dir == 2 ) {
					
					if ( isRange (nextX, nextY+dy[3]) ){
						if ( map[nextX][nextY+dy[3]] >= 0 && map[nextX][nextY+dy[3]] <= 5 ) {
							visited[nextX][nextY+dy[3]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[3], 1, 3));
						}
					}
					if ( isRange ( nextX, nextY+dy[1]) ) {
						if ( map[nextX][nextY+dy[1]] >= 0 && map[nextX][nextY+dy[1]] <= 5 ) {
							visited[nextX][nextY+dy[1]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[1], 1, 1));
						}
					}
					
				}else if ( dir == 1 || dir == 3 ) {
					
					if ( isRange (nextX+dx[0], nextY) ){
						if ( map[nextX+dx[0]][nextY] >= 0 && map[nextX+dx[0]][nextY] <= 5 ) {
							visited[nextX+dx[0]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[0], nextY, 1, 0));
						}
					}
					if ( isRange ( nextX+dx[2], nextY) ) {
						if ( map[nextX+dx[2]][nextY] >= 0 && map[nextX+dx[2]][nextY] <= 5 ) {
							visited[nextX+dx[2]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[2], nextY, 1, 2));
						}
					}
				}
				
			}else if ( num == 3 ) {
				
				int nextX = curX;
				int nextY = curY;
				
				if ( dir == 0 ) {
					// 0 1 추가 
					if ( isRange (nextX+dx[0], nextY) ){
						if ( map[nextX+dx[0]][nextY] >= 0 && map[nextX+dx[0]][nextY] <= 5 ) {
							visited[nextX+dx[0]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[0], nextY, 1, 0));
						}
					}
					if ( isRange ( nextX, nextY+dy[1]) ) {
						if ( map[nextX][nextY+dy[1]] >= 0 && map[nextX][nextY+dy[1]] <= 5 ) {
							visited[nextX][nextY+dy[1]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[3], 1, 1));
						}
					}
					
				}else if ( dir == 1 ) {
					//1,2 
					if ( isRange ( nextX, nextY+dy[1]) ) {
						if ( map[nextX][nextY+dy[1]] >= 0 && map[nextX][nextY+dy[1]] <= 5 ) {
							visited[nextX][nextY+dy[1]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[1], 1, 1));
						}
					}
					if ( isRange ( nextX+dx[2], nextY) ) {
						if ( map[nextX+dx[2]][nextY] >= 0 && map[nextX+dx[2]][nextY] <= 5 ) {
							visited[nextX+dx[2]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[2], nextY, 1, 2));
						}
					}
					
				}else if ( dir == 2 ) {
					//2  , 3
					if ( isRange ( nextX+dx[2], nextY) ) {
						if ( map[nextX+dx[2]][nextY] >= 0 && map[nextX+dx[2]][nextY] <= 5 ) {
							visited[nextX+dx[2]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[2], nextY, 1, 2));
						}
					}
					if ( isRange (nextX, nextY+dy[3]) ){
						if ( map[nextX][nextY+dy[3]] >= 0 && map[nextX][nextY+dy[3]] <= 5 ) {
							visited[nextX][nextY+dy[3]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[3], 1, 3));
						}
					}
					
				}else if ( dir == 3 ) {
					//0 , 3
					if ( isRange (nextX, nextY+dy[3]) ){
						if ( map[nextX][nextY+dy[3]] >= 0 && map[nextX][nextY+dy[3]] <= 5 ) {
							visited[nextX][nextY+dy[3]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[3], 1, 3));
						}
					}
					if ( isRange (nextX+dx[0], nextY) ){
						if ( map[nextX+dx[0]][nextY] >= 0 && map[nextX+dx[0]][nextY] <= 5 ) {
							visited[nextX+dx[0]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[0], nextY, 1, 0));
						}
					}
				}
				
			}else if ( num == 4 ) {
				
				int nextX = curX;
				int nextY = curY;
				
				if ( dir == 0 ) {
					// 0 1 3 추가 
					if ( isRange (nextX+dx[0], nextY) ){
						if ( map[nextX+dx[0]][nextY] >= 0 && map[nextX+dx[0]][nextY] <= 5 ) {
							visited[nextX+dx[0]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[0], nextY, 1, 0));
						}
					}
					if ( isRange ( nextX, nextY+dy[1]) ) {
						if ( map[nextX][nextY+dy[1]] >= 0 && map[nextX][nextY+dy[1]] <= 5 ) {
							visited[nextX][nextY+dy[1]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[3], 1, 1));
						}
					}
					if ( isRange (nextX, nextY+dy[3]) ){
						if ( map[nextX][nextY+dy[3]] >= 0 && map[nextX][nextY+dy[3]] <= 5 ) {
							visited[nextX][nextY+dy[3]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[3], 1, 3));
						}
					}
					
				}else if ( dir == 1 ) {
					//1,2 0
					if ( isRange ( nextX, nextY+dy[1]) ) {
						if ( map[nextX][nextY+dy[1]] >= 0 && map[nextX][nextY+dy[1]] <= 5 ) {
							visited[nextX][nextY+dy[1]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[1], 1, 1));
						}
					}
					if ( isRange ( nextX+dx[2], nextY) ) {
						if ( map[nextX+dx[2]][nextY] >= 0 && map[nextX+dx[2]][nextY] <= 5 ) {
							visited[nextX+dx[2]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[2], nextY, 1, 2));
						}
					}
					if ( isRange (nextX+dx[0], nextY) ){
						if ( map[nextX+dx[0]][nextY] >= 0 && map[nextX+dx[0]][nextY] <= 5 ) {
							visited[nextX+dx[0]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[0], nextY, 1, 0));
						}
					}
					
				}else if ( dir == 2 ) {
					//2  , 3 1
					if ( isRange ( nextX+dx[2], nextY) ) {
						if ( map[nextX+dx[2]][nextY] >= 0 && map[nextX+dx[2]][nextY] <= 5 ) {
							visited[nextX+dx[2]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[2], nextY, 1, 2));
						}
					}
					if ( isRange (nextX, nextY+dy[3]) ){
						if ( map[nextX][nextY+dy[3]] >= 0 && map[nextX][nextY+dy[3]] <= 5 ) {
							visited[nextX][nextY+dy[3]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[3], 1, 3));
						}
					}
					if ( isRange ( nextX, nextY+dy[1]) ) {
						if ( map[nextX][nextY+dy[1]] >= 0 && map[nextX][nextY+dy[1]] <= 5 ) {
							visited[nextX][nextY+dy[1]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[1], 1, 1));
						}
					}
					
				}else if ( dir == 3 ) {
					//0 , 3 2
					if ( isRange (nextX, nextY+dy[3]) ){
						if ( map[nextX][nextY+dy[3]] >= 0 && map[nextX][nextY+dy[3]] <= 5 ) {
							visited[nextX][nextY+dy[3]] = -1;
							q.offer(new TvLocation(nextX, nextY+dy[3], 1, 3));
						}
					}
					if ( isRange (nextX+dx[0], nextY) ){
						if ( map[nextX+dx[0]][nextY] >= 0 && map[nextX+dx[0]][nextY] <= 5 ) {
							visited[nextX+dx[0]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[0], nextY, 1, 0));
						}
					}
					if ( isRange ( nextX+dx[2], nextY) ) {
						if ( map[nextX+dx[2]][nextY] >= 0 && map[nextX+dx[2]][nextY] <= 5 ) {
							visited[nextX+dx[2]][nextY] = -1;
							q.offer(new TvLocation(nextX+dx[2], nextY, 1, 2));
						}
					}
				}
				
				
			}else if ( num == 5 ) {
				int nextX = curX;
				int nextY = curY;
				//0 , 3 2, 1
				if ( isRange (nextX, nextY+dy[3]) ){
					if ( map[nextX][nextY+dy[3]] >= 0 && map[nextX][nextY+dy[3]] <= 5 ) {
						visited[nextX][nextY+dy[3]] = -1;
						q.offer(new TvLocation(nextX, nextY+dy[3], 1, 3));
					}
				}
				if ( isRange (nextX+dx[0], nextY) ){
					if ( map[nextX+dx[0]][nextY] >= 0 && map[nextX+dx[0]][nextY] <= 5 ) {
						visited[nextX+dx[0]][nextY] = -1;
						q.offer(new TvLocation(nextX+dx[0], nextY, 1, 0));
					}
				}
				if ( isRange ( nextX+dx[2], nextY) ) {
					if ( map[nextX+dx[2]][nextY] >= 0 && map[nextX+dx[2]][nextY] <= 5 ) {
						visited[nextX+dx[2]][nextY] = -1;
						q.offer(new TvLocation(nextX+dx[2], nextY, 1, 2));
					}
				}
				if ( isRange ( nextX, nextY+dy[1]) ) {
					if ( map[nextX][nextY+dy[1]] >= 0 && map[nextX][nextY+dy[1]] <= 5 ) {
						visited[nextX][nextY+dy[1]] = -1;
						q.offer(new TvLocation(nextX, nextY+dy[1], 1, 1));
					}
				}
				
			}
		}
	}
	private static boolean isRange(int nextX, int nextY) {
		// TODO Auto-generated method stub
		boolean isRange = (0<=nextX && nextX < n ) && ( 0<=nextY && nextY <m);
		return isRange;
	}
	private static void printMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < n; i ++ ) {
			for ( int j = 0 ; j < m;j++ ) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
