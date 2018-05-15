package com.restart.algorithm;

import java.util.Scanner;

public class BeeRooms {
	
	public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if ( n == 1 ) System.out.println(1);
		else if ( n <= 1000000000 ){
			int ret = findMinRoom(1, 1, 2, 0);
			System.out.println(ret);
		}
		
		
	}

	private static int findMinRoom(int start, int k, int countRoom, int countNum) {
		// TODO Auto-generated method stub
		while ( n != start ) {
			start++;
			//개수가 6k개 된다면 k++, countRoom++을 한다. 
			if ( countNum == 6*k ) {
				k++;
				countRoom++;
				countNum = 0;
			}
			countNum++;
		}
		return countRoom;
	}

}
