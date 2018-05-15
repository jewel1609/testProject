package com.restart.algorithm;

import java.util.Scanner;

public class MusicGame {
	
	public static String[] RET = { "ascending", "descending", "mixed" };
	
	public static int[] music = new int[8];
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		for ( int i = 0 ; i < music.length;i ++ ) {
			music[i] = sc.nextInt();
		}
		
		//오름차순, 내림차순, 믹스 
		retMusicStyle();
	}
	private static void retMusicStyle() {
		// TODO Auto-generated method stub
		if ( music[0] == 1 ) {
			for ( int i = 0; i < music.length; i++) {
				if ( music[i] != i+1 ) {
					System.out.println(RET[2]);
					return;
				}
			}
			System.out.println(RET[0]);
			return;
		}
		else if ( music[0] == 8 ) {
			for ( int i = 0; i < music.length; i++) {
				if ( music[i] != 8-i ) {
					System.out.println(RET[2]);
					return;
				}
			}
			System.out.println(RET[1]);
			return;
		}
		else { 
			System.out.println(RET[2]);
			return;
		}
		
	}

}
