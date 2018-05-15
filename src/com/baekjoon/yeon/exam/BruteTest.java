package com.baekjoon.yeon.exam;

import java.util.LinkedList;
import java.util.Queue;

public class BruteTest {
		
	public static void main(String[] args) {
		
		Queue<String > q = new LinkedList<>();
		
		q.add("가");
		q.add("나");
		q.add("다");
		q.add("라");
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		System.out.println(q.isEmpty());
		
		
	}

}
