package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class QueueExample {
	public static List<Integer> q = new ArrayList<Integer>();
	public static Scanner sc;
	public static void main(String[] args) throws Exception {
		
//		sc = new Scanner(System.in);
		sc = new Scanner(new FileInputStream("input.txt"));
		
		
		int testCase = sc.nextInt();
		sc.nextLine();
		for ( int t = 0; t < testCase; t ++ ) {
			String order = sc.next();
			if ( order.equals("push") ) {
				int number = sc.nextInt();
				q.add(number);
			} else {
				int ret = queuOrder(order);
				System.out.println(ret);
			}
			
		}
		
	}

	private static int queuOrder(String order) {
		// TODO Auto-generated method stub
		if ( order.equals("front") ) {
			if ( q.size() == 0) return -1;
			return q.get(0);
		}
		else if ( order.equals("back") ) {
			int n = q.size();
			if ( q.size() == 0) return -1;
			return q.get(n-1);
		}
		else if ( order.equals("size") ) {
			return q.size();
		}
		else if ( order.equals("empty") ) {
			if ( q.size() == 0) return 1;
			return 0; 
		}
		else if ( order.equals("pop") ) {
			if ( q.size() == 0) return -1;
			return q.remove(0);
		}
		
		return 0;
	}

}
