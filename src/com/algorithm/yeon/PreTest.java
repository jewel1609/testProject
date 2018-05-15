package com.algorithm.yeon;

import java.util.Scanner;

public class PreTest {

	// 문제) 입력받은 숫자를 한글 구음으로 변환하여 Standard out으로 출력하는 프로그램을 만들고자 합니다.
	// PreTest.java라면, 아래와 같이 동작하도록 구현하시오. (입력값은 1 ~ 99999 의 정수에 한함.)

	static final String[] numberUnit = { "", "십", "백", "천"};
	static final String[] numberUnit2 = { "", "만"};
	static final String[] number = { "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String input = sc.next();

		String result = numberChangeKorean(input);
		
		System.out.println(result);

	}

	private static String numberChangeKorean(String input) {
		// TODO Auto-generated method stub
		
		int numLength = input.length();
		
		if ( numLength > 5 || Integer.parseInt(input) <= 0 ) {
			String result = "범위를 벗어났습니다.";
			return result;
		}

		StringBuffer result = new StringBuffer();
		
		for ( int i = numLength-1; i >= 0 ; i-- ) {
			
			result.append(number[Integer.parseInt(input.substring(numLength-i-1, numLength-i))]);
			
			if (Integer.parseInt(input.substring(numLength-i-1, numLength-i)) > 0 ) {
				result.append(numberUnit[i%4]);
			}
			if ( i%4 == 0 ) {
				result.append(numberUnit2[i/4]);
			}
			
		}
		
		return result.toString();
	}

}
