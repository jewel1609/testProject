package com.baekjoon.yeon;

import java.util.Scanner;

public class kakao002 {

	public static void main(String[] args) {
		
		String dartResult= "1S*2T*3S";
			
			int result = solution(dartResult);

			System.out.println(result);
			

	}
	private static int solution(String dartResult) {
		// TODO Auto-generated method stub
		String[] darts = new String[9];
		darts = dartResult.split("");
		String[] scoreNumber = dartResult.split("\\D+");
		String[] result = new String[9];
		int sum = 0;
		int score[] = new int[4];
		int count = 0;
		
		//정수잘라서 스코어에 넣기.
		for(int i =1 ; i <=scoreNumber.length; i ++ ) {
			score[i] = Integer.parseInt(scoreNumber[i-1]);
		}
		
		//result 배열 초기화
		for ( int i = 0; i < result.length; i ++ ) {
			result[i] = "";
		}
        //결과값을 배열에 나눠서 담기. 
        for ( int i =0 ; i < darts.length; i ++ ){
        	result[i] = darts[i];
        }
        
        
        // 체크하기 s,d,t 
        for ( int i = 1; i < darts.length; i ++ ) {
        	if ( result[i].equals("S") ) {
        		count ++;
        		int num = score[count];

        		if ( result[i+1].equals("*") ) {
        			score[count] = num * 2;
        			score[count-1] = score[count-1] * 2;
        		}
        		else if ( result[i+1].equals("#") ) {
        			score[count] = num * (-1);
        		}
        		else {
        			score[count] = num;
        		}
        	}
        	
        	if ( result[i].equals("D") ) {
        		count ++;
        		int num = score[count] * score[count];

        		if ( result[i+1].equals("*") ) {
        			score[count] = num * 2;
        			score[count-1] = score[count-1] * 2;
        		}
        		else if ( result[i+1].equals("#") ) {
        			score[count] = num * (-1);
        		}
        		else {
        			score[count] = num;
        		}
        	}
        	
        	if ( result[i].equals("T") ) {
        		count ++;
        		int num = score[count] * score[count] * score[count];

        		if ( result[i+1].equals("*") ) {
        			score[count] = num * 2;
        			score[count-1] = score[count-1] * 2;
        		}
        		else if ( result[i+1].equals("#") ) {
        			score[count] = num * (-1);
        		}
        		else {
        			score[count] = num;
        		}
        		
        	}
        }
        
        for ( int i = 0; i < score.length; i ++ ) {
        	System.out.println(score[i]);
        	sum += score[i];
        }
        
        return sum;
	}

}
