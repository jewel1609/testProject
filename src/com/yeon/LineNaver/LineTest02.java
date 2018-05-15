package com.yeon.LineNaver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class LineTest02 {
	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new FileReader("line02.txt"))) {
			
			int testCase = Integer.parseInt(br.readLine().trim());
			
			for ( int i = 0 ; i < testCase; i ++ ) {
				int result = 0;
				StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
				int n = Integer.parseInt(tokens.nextToken());
				int k = Integer.parseInt(tokens.nextToken());
				int m = Integer.parseInt(tokens.nextToken());
				
				// nCm * nC(k-m);
				
				int one = combination(n, m);
				int two = combination(n, k-m);
				result = one * two;
				
				System.out.println(result);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	private static int combination(int n, int r) {
		// TODO Auto-generated method stub
		if ( n == r || r == 0 ) return 1;
		else return combination(n-1, r-1) + combination(n-1, r);
	}
}
