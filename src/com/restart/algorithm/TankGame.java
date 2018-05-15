package com.restart.algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class TankGame {
	public static String[][] map;
	public static int count;
	public static void main(String[] args) throws Exception {
		
//		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		BufferedReader in;
		FileWriter out;
		try {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new FileWriter("output.txt");
			
			//code
			int t = Integer.valueOf(in.readLine());
			for ( int testCase = 0; testCase < t; testCase++ ) {
				
				count = 0;
				
				int n = Integer.valueOf(in.readLine());
				map = new String[n][n];
				
				for ( int i = 0; i < n; i ++ ) {
					map[i] = in.readLine().split(" ");
				}
				
				for ( int i = 0; i < n; i ++ ) {
					for ( int j = 0 ;  j < n;j ++ ) {
						if ( map[i][j].equals("T") ) {
							goBomb(i, j);
						}
					}
				}
				
//				showMap();
				
				//a,b,c값을 찾고 1을 퍼뜨리기. 
				System.out.println("#"+ (testCase+1) + " " + count);
				out.write("#"+ (testCase+1) + " " + count + "\r\n");
				
			}
			//code end
			
			in.close();
			out.close();
				
		}catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	private static void goBomb(int x, int y) {
		// TODO Auto-generated method stub
		int n = map.length;
		int tempX = x;
		int tempY = y;
		//서쪽으로 이동가능하다면 
		while ( y-1 >= 0 ) {
			
			if ( map[x][y-1].equals("B") ) {
				y = -1;
			}else if ( map[x][y-1].equals("E") ) {
				map[x][y-1] = "B";
				y = -1;
				count+=1;
			}
			
			y-=1;
		}
		
		x = tempX;
		y = tempY;
		
		//동쪽으로 이동가능하다면
		while ( y+1 < n ) {
			
			if ( map[x][y+1].equals("B") ) {
				y = n+1;
			}else if ( map[x][y+1].equals("E") ) {
				map[x][y+1] = "B";
				y = n+1;
				count+=1;
			}
			
			y+=1;
		}
		
		x = tempX;
		y = tempY;
		
		//북쪽으로 이동가능하다면
		while ( x-1 >= 0 ) {
			
			if ( map[x-1][y].equals("B") ) {
				x = -1;
			}else if ( map[x-1][y].equals("E") ) {
				map[x-1][y] = "B";
				x = -1;
				count+=1;
			}
			
			x-=1;
		}
		
		x = tempX;
		y = tempY;
		
		//남쪽으로 이동가능하다면
		while ( x+1 < n ) {
			
			if ( map[x+1][y].equals("B") ) {
				x = n+1;
			}else if ( map[x+1][y].equals("E") ) {
				map[x+1][y] = "B";
				x = n+1;
				count+=1;
			}
			
			x+=1;
		}
		
		
	}
	private static void showMap() {
		// TODO Auto-generated method stub
		for ( int i = 0; i < map.length; i ++ ) {
			for ( int j = 0 ;  j < map[0].length;j ++ ) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}

}
