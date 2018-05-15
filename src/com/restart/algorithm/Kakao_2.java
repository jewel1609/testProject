package com.restart.algorithm;

import java.util.Scanner;


public class Kakao_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		//1D2S#10S
		
		//S D T * #
		//점수는 0~10점까지 있다.
		
		int n = str.length();
		int[] score = new int[3];
		int index = 0;
		int scoreIndex = 0;
		while ( index < n ) {
			
			int curScore = Integer.parseInt(str.charAt(index)+"");
			if ( str.charAt(index) == '1' ) {
				if ( str.charAt(index+1) == '0' ) {
					curScore = 10;
					index++;
				}
			}
//			System.out.println(curScore + "--");
			index++;
			if ( str.charAt(index) == 'D' ) {
				curScore =  curScore*curScore;
				if ( index+1 < n && str.charAt(index+1) == '*' ) {
					curScore *= 2;
					if ( scoreIndex-1 >= 0 ) {
						score[scoreIndex-1] = score[scoreIndex-1] * 2; 
					}
					index++;
				}else if ( index+1 < n &&  str.charAt(index+1) == '#' ) {
					curScore *= -1;
					index++;
				}
			}else if ( str.charAt(index) == 'S' ) {
				curScore = curScore;
				if ( index+1 < n ) {
					
					if ( str.charAt(index+1) == '*' ) {
						curScore *= 2;
						if ( scoreIndex-1 >= 0 ) {
							score[scoreIndex-1] = score[scoreIndex-1] * 2; 
						}
						index++;
					}else if ( str.charAt(index+1) == '#' ) {
						curScore *= -1;
						index++;
					}
					
				}
			}else if ( str.charAt(index) == 'T' ) {
				curScore = curScore*curScore*curScore;
				if ( index+1 < n && str.charAt(index+1) == '*' ) {
					curScore *= 2;
					if ( scoreIndex-1 >= 0 ) {
						score[scoreIndex-1] = score[scoreIndex-1] * 2; 
					}
					index++;
				}else if ( index+1 < n &&  str.charAt(index+1) == '#' ) {
					curScore *= -1;
					index++;
				}
			}
			index++;
			score[scoreIndex] = curScore;
			scoreIndex++;
//			System.out.println(curScore);
		}
		int ret = 0;
		for ( int i = 0 ; i < 3; i ++ ) {
			ret += score[i];
		}
		System.out.println(ret);
	}

}
