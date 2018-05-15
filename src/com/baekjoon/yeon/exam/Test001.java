package com.baekjoon.yeon.exam;

import java.util.Scanner;

public class Test001 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int []pocket = new int[3];
		int count = 0;
		int index = 0;
		
		String number = "";
		String[] numbers;
		number = scan.nextLine();
		
		numbers = number.split(" ");
		int[] items = new int[numbers.length]; 
		
		changeIntArr(numbers, items);

		//		for ( int i = 0 ; i < numbers.length; i ++ ) {
//			System.out.println(items[i]);
//		}
		
		//버린 아이템 출력하기 
		for ( int i = 0; i < items.length; i ++ ) {
			int check = 0;
			if ( count == 2 ) { //주머니가 꽉찼다
				for ( int j = 0; j < pocket.length; j ++ ) {
					if ( pocket[j] == items[i] ) { //같은게 들어있다면
						check++;
						if ( j == 0 ) {
							System.out.println(pocket[j]);
							count = 0;
							pocket[j] = items[i];
						}else if ( j == 1 ) {
							System.out.println(pocket[j]);
							int temp = pocket[0];
							pocket[0] = items[i];
							pocket[1] = temp;
							count = 0;
						}else if ( j == 2 ) {
							System.out.println(pocket[j]);
							int temp = pocket[0];
							int temp2 = pocket[1];
							pocket[0] = items[i];
							pocket[1] = temp;
							pocket[2] = temp2;
							count = 0;
						}
					}
				}
			}
			else if ( count == 2 && check == 0) {
				System.out.println(pocket[2]);
				int temp = pocket[0];
				int temp2 = pocket[1];
				pocket[0] = items[i];
				pocket[1] = temp;
				pocket[2] = temp2;
				count = 0;
			}
			
			if ( count < 2 ){
				//주머니에 아이템 담기 
				pocket[count] = items[i];
				count++;
				
			}
		}
		
		
		
	}


	private static void changeIntArr(String[] numbers, int [] items) {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < numbers.length; i ++ ) {
			items[i] = Integer.parseInt(numbers[i]);
		}
		
	}
	
}
