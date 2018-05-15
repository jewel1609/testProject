package com.restart.algorithm;

import java.util.Scanner;

public class Hansu {
	
	public static int[] numbers = new int[3];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//110 input  
		int n = sc.nextInt();
		int countHansu = 0;
		
		int ret = countHansuGame(n, 0);
		System.out.println(ret);
		
	}

	private static int countHansuGame(int n, int count) {
		// TODO Auto-generated method stub
		while ( n >= 1 ) {
			if ( n == 1000) {
				n--;
				continue;
			}
			// 세자리수이면 자리수각각 저장해서 등차인지 확인 
			else if ( n / 10 >= 10 ) {
				numbers[0] = n / 100;
				numbers[1] = (n % 100 ) / 10;
				numbers[2] = (n % 100 ) % 10; 
				if ( numbers[1] - numbers[0] == numbers[2] - numbers[1] ) {
					count++;
				}
			}
			else { 
				// 두자리수와 한자리수는 그자체가 한수이므로 다 카운팅한다.
				count++;
			}
			n--;
		}//end while
		
		return count;
		
	}

}
