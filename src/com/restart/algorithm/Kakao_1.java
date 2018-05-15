package com.restart.algorithm;

import java.util.Scanner;

public class Kakao_1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr1 = new int[n];
		int[] arr2 = new int[n];
		int[] ret = new int[n];
		String[][] map = new String[n][n];
		
		for ( int i = 0 ; i < n; i ++) {
			arr1[i] = sc.nextInt();
		}

		for ( int i = 0 ; i < n; i ++) {
			arr2[i] = sc.nextInt();
		}
		
		for ( int i = 0 ; i < n; i ++) {
			ret[i] =  arr1[i]|arr2[i];
			map[i] = (Integer.toBinaryString(ret[i]) + "").split("");
		}
		
		for ( int i = 0 ; i < n; i++ ) {
			for ( int j = 0 ; j < n; j++ ) {
				if ( map[i][j].equals("1") ) {
					map[i][j] = "#";
				}else if ( map[i][j].equals("0") ) {
					map[i][j] = " ";
				}
			}
		}
		
		showMap(map);
		
	}

	private static void showMap(String[][] map) {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < map.length; i ++ ) {
			for ( int j = 0 ; j < map[0].length; j++ ) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}


}
