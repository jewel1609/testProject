package com.restart.algorithm;

import java.util.HashMap;
import java.util.Scanner;

public class Test {
	public static HashMap<String, Integer> map = new HashMap<>();
	public static boolean flag = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		int count = 0;
		for ( int i = 0; i < 1; i ++ ) {
			
			String str = sc.next().trim();
			
			for ( int j = 0 ; j < str.length(); j ++ ) {
				String curStr = str.charAt(j)+"";
				
				countText(curStr);
				
//				if ( changeOrIsNull(str, j , curStr ) ) {
//					
//					for (String mapkey : map.keySet()){
////				        System.out.print(map.get(mapkey) + mapkey);
//						result += map.get(mapkey) + mapkey;
//					}
//				}
//				map.clear();
								
			}
		}
	    for (String mapkey : map.keySet()){
//	        System.out.print(map.get(mapkey) + mapkey);
	        result = map.get(mapkey) + mapkey;
	        System.out.print(result);
	    }
		
		
	}

	private static boolean changeOrIsNull(String str, int j, String curStr) {
		// TODO Auto-generated method stub
		if ( j+1 >=  str.length() ) return true;
		int nextStr = str.charAt(j+1);
		if ( !curStr.equals(nextStr) ) {
			return true;
		}
		return false;
	}

	private static void countText(String key) {
		// TODO Auto-generated method stub
		if ( map.get(key) == null ) {
			map.put(key, 1);
			
			flag = true;
			
		}else {
			map.put(key, map.get(key)+1);
		}
	}

}
