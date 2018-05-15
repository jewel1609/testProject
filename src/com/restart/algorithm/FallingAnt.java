package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class FallingAnt {
	public static int result[];
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("fallingAnt.txt"));
		
		int t = sc.nextInt();
		for ( int testCase = 0; testCase < t; testCase++ ) {
			
			int n = sc.nextInt();
			int length = sc.nextInt();
			int k = sc.nextInt();
			
			int[] map = new int[length+1];
			result = new int[k+1];
			for ( int i = 0; i < n; i ++ ) {
				int pos = sc.nextInt();
				int antID = sc.nextInt();

				map[pos] = antID;
				
			}
			
			//k번째까지 떨어질때까지 시뮬레이션 
			simulation(map, k, 0, map.length);
			
			
		}
		
	}

	private static void simulation(int[] map, int k, int count, int length) {
		// TODO Auto-generated method stub
		
		while ( true ) {
			if ( count == k ) {
				//k번째 떨어진 개미의 ID 출력 
				System.out.println(result[k]);
				return;
			}
			
			//해당 방향으로 한칸씩 이동
			//음수면 왼쪽으로 한칸
			//양수면 오른쪽으로 한칸 
			//좌표가 양끝이면 result에 반환 count++;
			for ( int i = 0 ; i < length; i ++ ) {
				if ( map[i] != 0 ) {
					//한칸 이동 
					int currentId = map[i];
					int currentPos = i;
					int temp = 0;
					if ( currentId < 0 ) {
						temp = map[i];
						
						map[i] = 0;
						
						currentPos -= 1;
						
						if ( currentPos == 0 ) {
							result[count] = temp;
							count++;
							continue;
						}
						
						map[currentPos] = temp;
					}else { 
						temp = map[i];
						
						map[i] = 0;
						currentPos +=1;
						if ( currentPos == length ) {
							result[count] = temp;
							count++;
							continue;
						}
						
						map[currentPos] = temp;
					}
				}
			}//end for 
			
			//같은 좌표가 있는지 검사 
			//좌표가 같다면 두 좌표가 방향을 서로 바꾼다. andID 음수 양수가 서로 바뀐다.
			for ( int i = 0 ; i < length; i ++ ) { 
				
				
				
				
				
				
			}
			
			
			
			
		}
		
	}
}	
