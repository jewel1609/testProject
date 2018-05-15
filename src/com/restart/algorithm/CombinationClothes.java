package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;
public class CombinationClothes {
	public static HashMap<String, Integer> map;
	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int testCase = sc.nextInt();
		
		for ( int t = 0; t < testCase; t ++ ) {
			int n = sc.nextInt();
			map = new HashMap<>();
			
			for ( int i = 0 ; i < n; i ++ ) {
				String name = sc.next();
				String type = sc.next();
				if ( map.get(type) == null ) {
					map.put(type, 1);
				}else {
					map.put(type, map.get(type)+1);
				}
				
			}
			long ret = 1;
			for ( int count : map.values() ) {
				ret *= (count+1);
			}
			System.out.println(ret-1);
		}
	}


}
