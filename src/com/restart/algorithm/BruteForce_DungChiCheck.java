package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Dungchi {
	
	int kg;
	int height;
	
	public Dungchi(int x, int y) {
		// TODO Auto-generated constructor stub
		kg = x;
		height = y;
		
	}
	
}

public class BruteForce_DungChiCheck {
	
	static int howMoreDunchi[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("dungchi.txt"));
		int n = sc.nextInt();
		howMoreDunchi = new int[n];
		ArrayList<Dungchi> list = new ArrayList<>();
		
		for ( int i = 0 ; i < n; i ++ ) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.add( new Dungchi(x, y) );
		}
		
		//자신의 등수 : 덩치큰사람 수 + 1 
		for ( int i = 0 ; i < n; i ++ ) {
			int kg = list.get(i).kg;
			int height = list.get(i).height;
			int count = 0;
			for ( int j = 0; j < n; j++ ) {
				if ( i == j ) continue;
				int kg2 = list.get(j).kg;
				int height2 = list.get(j).height;
				if ( ( kg < kg2 ) && ( height < height2 ) ) {
					count++;
				}
			}
			howMoreDunchi[i] = count+1;
		}
		
		for ( int i = 0 ; i < n;i ++ ) {
			System.out.print(howMoreDunchi[i] + " ");
		}
		
		
	}
}
