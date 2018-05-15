package com.restart.algorithm;

import java.util.LinkedList;
//연결리스트 예제 
public class Josephus {

	public static LinkedList<Integer> list = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		
		int n = 40;
		int k = 3;
		
		
		josephus(n, k);
		
	}

	private static void josephus(int n, int k) {
		// TODO Auto-generated method stub
		
		for ( int i = 1; i <= n; i ++ ) {
			list.addLast(i);
		}
		
		//킬 포인터 
		int kill = 0;
		
		while ( n > 2 ) {
			//kill위치에 있는 list제거 
			list.remove(kill);
			if ( kill == list.size() ) {
				kill = 0;
			}
			--n;
			for ( int i = 0; i < k-1; i ++ ) {
				kill++;
				if ( kill == list.size() ) kill = 0; 
			}
			
			
			
		}
		
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		
	}
	

}
