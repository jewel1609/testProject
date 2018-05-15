package com.restart.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class JosephusQueue {
	//조세푸스 문제 큐를 이용한 구현 (큐를 연결리스트로 구현 ) 
	public static void main(String[] args) {
		
		int n = 7;
		int k = 3;
		
		josephus(n, k);
		
		
	}

	private static void josephus(int n, int k) {
		// TODO Auto-generated method stub
		Queue<Integer> list = new LinkedList<Integer>();
		
		for ( int i = 1; i <= n; i ++ ) {
			list.add(i);
		}
		
		//1. 첫 번째 사람을 kill
		//2. k-1만큼 맨 앞의 사람을 맨 뒤로 보낸다. 
		
		while ( n > 2 ) {
			list.remove();
			n--;
			for ( int i = 0; i < k-1; i ++ ) {
				int man = list.poll();
				list.offer(man);
			}
			
		}
		
		System.out.println(list.remove());
		System.out.println(list.remove());
		
	}

}
