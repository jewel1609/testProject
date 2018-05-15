package com.baekjoon.yeon;

import java.util.Scanner;

class kakao001 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] result = null;
		int n = 5;
		int arr1[] = new int[5];
		int arr2[] = new int[5];
		arr1[0] = 9;
		arr1[1] = 20;
		arr1[2] = 28;
 		arr1[3] = 18;
		arr1[4] = 11;
		
		arr2[0] = 30;
		arr2[1] = 1;
		arr2[2] = 21;
		arr2[3] = 17;
		arr2[4] = 28;

		solution(n, arr1, arr2);
		

	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
	
	String[] answer = new String[n];
	
	
	int map[][] = new int[n][n];
	int map2[][] = new int[n][n];
	String map3[][] = new String [n][n];

	//arr 을 이진수로 변환하여 map만들기.
    for ( int j = 0; j < map.length; j ++ ) {
    	for (int k = map.length-1; k >= 0; k--) {
    		int num = arr1[j];
        	if (num % 2 == 1) {
        		map[j][k] = 1;
        		arr1[j] = num / 2;
            } else if (num % 2 == 0) {
            	map[j][k] = 0;
            	arr1[j] = num / 2;
            }  
    	}
    }
	
	// 두번째 배열 전환해서 맵2에 넣기
    for ( int j = 0; j < map.length; j ++ ) {
    	for (int k = map.length-1; k >= 0; k--) {
    		int num = arr2[j];
        	if (num % 2 == 1) {
        		map2[j][k] = 1;
        		arr2[j] = num / 2;
            } else if (num % 2 == 0) {
            	map2[j][k] = 0;
            	arr2[j] = num / 2;
            }  
    	}
    }

	for(int i = 0;i < n;i++)	{
		for (int j = 0; j < n; j++) {
			if (map[i][j] == 1 || map2[i][j] == 1) {
				map3[i][j] = "#";
			}
			else if (map[i][j] == 0 && map2[i][j] == 0) {
				map3[i][j] = " ";
			}
		}
	}
	//초기
	for ( int i = 0; i < n; i ++ ) {
		answer[i] = "";
	}
	for (int i = 0 ; i < n; i ++ ) {
		for ( int j = 0 ; j < n ; j ++ ) {
			answer[i] += map3[i][j];
		}
	}
	
//	for ( int i = 0; i < n; i ++ ) {
//		System.out.println(answer[i]);
//	}
	
	
	return answer;
	}

		



}