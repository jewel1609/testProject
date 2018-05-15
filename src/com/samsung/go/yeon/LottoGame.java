package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Scanner;

public class LottoGame {

	static int n;
	static int[] S;
	static int[] temp;
	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("lottoGame.txt"));

		while ((n = sc.nextInt()) != 0) {
			S = new int[n];
			temp = new int[6];
			for (int i = 0; i < n; i++) {
				S[i] = sc.nextInt();
			}
			
			dfs("", 0, 0);
			System.out.println();
		}

	}

	private static void dfs(String str, int index, int cnt) {
		// TODO Auto-generated method stub
		if ( index == n ) {
			if ( cnt == 6 ) {
				System.out.println(str);
			}
			return;
		}else {
			
			//index 증가 하면서 고를 숫자 찾으면서 
			//선택하는 경우 
			dfs( str + S[index] + " ", index + 1, cnt +1);
			//선택하지 않는 경우 
			dfs( str , index +1, cnt);
		}
	}
}
