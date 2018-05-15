package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleGame {
	
	public static String[][] cycles;
	
	public static void main(String[] args) throws Exception {
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("cycleGame.txt"));
		
		cycles = new String[4][8];
		
		for ( int i = 0 ; i < cycles.length;i++ ) {
			cycles[i] = sc.nextLine().split("");
		}
		
		int k  = sc.nextInt();
		int ret = 0;
		
		for ( int i = 0 ; i < k; i ++ ) {
			int cycleNum = sc.nextInt()-1;
//			System.out.println(cycleNum);
			int direct = sc.nextInt();
//			System.out.println(direct);
			//1시계 -1 반시계 0은 그대
			
			int[] directs = new int[4];
			//방향 세팅 
			directs = checkDirect(cycleNum, direct);
			
			//방향대로 돌리기 
			goCycle(directs);
//			showMap();
			
		}
		
		for ( int i = 0 ; i < cycles.length; i ++ ) {
			
			if ( cycles[i][0].equals("0") ) {
				ret += 0;
			}else if ( cycles[i][0].equals("1")) {
				ret += (1 << i );
			}
//			ret += Integer.parseInt( cycles[i][0] );
			
			
		}
		
		
		
		System.out.println(ret);
		
	}

	private static void goCycle(int[] directs) {
		// TODO Auto-generated method stub
		Queue<String> q;
		
		for ( int i = 0; i < 4;i ++ ) {
			q = new LinkedList<String>();
			
			//q세팅 
			for ( int j = 0 ; j < 8; j ++ ) {
				q.add(cycles[i][j]);
//				System.out.print(cycles[i][j]);
			}
//			System.out.println(directs[i] + "해당방향 ");
			//해당 방향으로 회전 
			if ( directs[i] == 1 ) {
//				System.out.println("시계 ");
				//시계 
				for ( int m = 0; m < 7; m ++ ) {
					String temp = q.remove();
//					System.out.println(temp);
					q.add(temp);
//					System.out.println("완료 ");
				}
			}else if ( directs[i] == -1 ) {
				//반시계
//				System.out.println("반 시계 ");
				String temp = q.remove();
				q.add(temp);
			}else if ( directs[i] == 0 ) {
				//노회전 
//				System.out.println("노회전");
				continue;
			}
			
			//cycels에 다시 담기 
			for ( int k = 0 ; k < 8; k ++ ) {
				cycles[i][k] = q.remove();
			}
			
			
		}
		
		
	}

	private static int[] checkDirect(int cycleNum, int direct) {
		// TODO Auto-generated method stub
		int[] dir = new int[4];
		
		for ( int i = 0; i < dir.length;i ++ ) {
			dir[i] = 0;
		}
		
		dir[cycleNum] = direct;
//		System.out.println(cycleNum + " ," + direct);
		
		switch (cycleNum) {
		case 0: if ( !cycles[0][2].equals(cycles[1][6]) ) {
					dir[1] = direct * (-1);
				}
				if ( !cycles[1][2].equals(cycles[2][6]) ) {
					dir[2] = dir[1] * (-1);
				}
				if ( !cycles[2][2].equals(cycles[3][6]) ) {
					dir[3] = dir[2] * (-1);
				}
				break;
		case 1: if ( !cycles[0][2].equals(cycles[1][6]) ) {
					dir[0] = direct * (-1);
				}
				if ( !cycles[1][2].equals(cycles[2][6]) ) {
					dir[2] = direct * (-1);
				}
				if ( !cycles[2][2].equals(cycles[3][6]) ) {
					dir[3] = dir[2] * (-1);
				}
				break;
		case 2: 
				if ( !cycles[2][2].equals(cycles[3][6]) ) {
					dir[3] = direct * (-1);
				}
				if ( !cycles[1][2].equals(cycles[2][6]) ) {
					dir[1] = direct * (-1);
				}
				if ( !cycles[0][2].equals(cycles[1][6])  ) {
					dir[0] = dir[1] * (-1);
				}
				break;
		case 3: 
				if ( !cycles[2][2].equals(cycles[3][6]) ) {
					dir[2] = direct * (-1);
				}
				if ( !cycles[1][2].equals(cycles[2][6]) ) {
					dir[1] = dir[2] * (-1);
				}
				if ( !cycles[0][2].equals(cycles[1][6]) ) {
					dir[0] = dir[1] * (-1);
				}
				
				break;
		}
//		for ( int i = 0 ; i < 4; i ++ ){
//			System.out.println(dir[i] + "뱡향>>");
//		}
		return dir;
	}

	private static void showMap() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < cycles.length; i++ ) {
			for ( int j = 0 ; j < cycles[0].length;j ++ ) {
				System.out.print(cycles[i][j]);
			}
			System.out.println();
		}
		
	}

}
