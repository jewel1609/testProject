package com.restart.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephusQ {
	
	public static Queue<Integer> q = new LinkedList<>();
	public static int n;
	public static int m;
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		for ( int i = 1; i <= n; i ++ ) {
			q.add(i);
		}
		System.out.print("<");
		while ( !q.isEmpty() ) {
			for ( int k = 0; k < m-1; k ++ ) {
				int temp = q.remove();
				q.add(temp);
			}
			if ( q.size() == 1 ) {
				System.out.print( q.remove() );
				continue;
			}
			System.out.print( q.remove() +", ");
		}
		System.out.print(">");
		
		
	}
}
