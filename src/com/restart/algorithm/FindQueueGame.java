package com.restart.algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class FindQueueGame {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//연결리스트 
		LinkedList<Integer> list = new LinkedList<>();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[m];
		
		for ( int i = 0; i < n; i ++ ) {
			list.add(i+1);
		}
		
		for ( int i =0; i < m;i++ ) {
			nums[i] = sc.nextInt();
		}
		int count  = 0;
		
		
		for ( int number : nums ) {
			while ( true ) {
				//찾아야하는 위치 
				int pos = list.indexOf(number);
				int size = list.size();
				
				int left = pos; //head와의 거리 
				int right = size - pos - 1; //tail과의 거리 
				
				//이동할 필요없이 현재위치에 있다면 
				if ( pos == 0 ) {
					list.removeFirst();
					break;
				}else {
					if ( left <= right ) { //2
						list.addLast(list.removeFirst());
						count++;
					}else { //3 
						list.addFirst(list.removeLast());
						count++;
					}
				}
			}
		}//end
		
		System.out.println(count);
		
		
		
	}
	
}
