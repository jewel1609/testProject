package com.baekjoon.yeon.exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Exam0001 {
	
	// 리스트와 어레이리스트 실습...
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		for ( int i = 0 ; i < 6; i ++ ) {
			
			list.add(i);
			
		}
		
		Iterator iterator = list.iterator();
		
		while ( iterator.hasNext() ) {
			System.out.println(iterator.next()); 
			
		}
		
	}

}
