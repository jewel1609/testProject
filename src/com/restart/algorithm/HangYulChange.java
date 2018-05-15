package com.restart.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangYulChange {
	
	public static int n;
	public static boolean button = false;
	public static int[] dx = { -1, 1, 0, 1 };
	public static int[] dy = { 1, -1, 1, 0 };
	public static int k = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		n = sc.nextInt();
		//초기화 
		findNumber(1, 1, 1, 1);
		
	}

	private static void findNumber(int number, int count, int x, int y) {
		// TODO Auto-generated method stub
		//기저 사례 
		
		while ( n != number ) {
			
			if ( k == count ) {
				count = 0;
				k++;
				if ( button == false ) {
					button = true;
				}else if ( button == true){
					button = false;
				}
			}
			if ( button == true && count == 0 ) {
				x = x + dx[2];
				y = y + dy[2];
				number++;
				count++;
			}else if ( button == false && count == 0 ) {
				x = x + dx[3];
				y = y + dy[3];
				number++;
				count++;
			}else if ( button == true && count < k ) {
				x = x + dx[1];
				y = y + dy[1];
				number++;
				count++;
			}else if ( button == false && count < k ) {
				x = x + dx[0];
				y = y + dy[0];
				number++;
				count++;
			}
			
		}
//		if ( n == number ) {
			//출력 
			System.out.println(x + "/" + y);
			return;
//		}
		
		
	}


		
		
		
		

}
