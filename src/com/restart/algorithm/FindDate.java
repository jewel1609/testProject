package com.restart.algorithm;

import java.util.Scanner;

public class FindDate {
	
	public static int[] MONTH = new int[13];
	public static int[] DATE = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; 
	public static String[] DAY = { "", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };
	public static int x = 0;
	public static int y = 0;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for ( int i = 0; i <= 12; i ++ ) {
			MONTH[i] = i;
		}
		
		x = sc.nextInt();
		y = sc.nextInt();
		
		//1월 1일은 월요일 에서 출발해서 x월 y일일때의 요일을 출력한다. 
		findDAY(1,1,1);
		
		
		
	}

	private static void findDAY(int month, int date, int day) {
		// TODO Auto-generated method stub
		//기저사례 
		if ( month == x && date == y ) {
			System.out.println(DAY[day]);
			return;
		}
		// 1월 1일 1요일 
		date++;
		day++;
		if ( day > 7 ) day = 1;
		if ( date > DATE[month] ) {
			date = 1;
			month++;
		}
		
		findDAY(month, date, day);
		
	}

}
