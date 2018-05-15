package com.restart.algorithm;

import java.util.Scanner;

public class FindSu {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[3];
		
		for ( int i = 0; i < numbers.length; i ++ ) {
			numbers[i] = sc.nextInt();
		}
		
		//정렬후 두번째 배열 출력
		int n = numbers.length;
		for ( int i = 0; i < n-1; i ++ ) {
			for ( int j = i+1; j < n; j ++ ) {
				if ( numbers[i] <= numbers[j] ) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
	
		System.out.println(numbers[1]);
		
		
		
	}
}
