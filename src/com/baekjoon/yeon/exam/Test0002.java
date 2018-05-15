package com.baekjoon.yeon.exam;

import java.util.Scanner;

public class Test0002 {
	
	public static void main(String[] args) {
			
		String[] inputs = null;
		char messages[];
		char secrets[];
		char results[];
		
		
		Scanner scan = new Scanner(System.in);
		
		String input = scan.nextLine();
		inputs = input.split(" ");
		
		int lotation = Integer.parseInt( inputs[2] );
		
		secrets = inputs[1].toCharArray();
		
		messages = inputs[3].toCharArray();	
		

		int result[] = new int[messages.length];
		results = new char[messages.length];
		
		if ( inputs[0].equals("encrypt") ) {
			
			for ( int i = 0; i < messages.length; i ++ ) {
				result[i] = ( ( (int)messages[i] -97 ) + ( (int)secrets[i] - 97 ) );
				
				if ( result[i] > 26 ) {
					result[i] %= 26;
				}
			}
			resultPass( result, lotation, results );
			
		}
		else if ( inputs[0].equals("decrypt") ) {
			
			for ( int i = 0; i < messages.length; i ++ ) {
				result[i] = ( ( (int)messages[i] -97 ) + ( (int)secrets[i] - 97 ) );
				
				if ( result[i] > 26 ) {
					result[i] %= 26;
				}
				
			}
			resultOriginal( result, lotation, results );
		}
		
		
		
		
		
		
		
		
	}

	private static void resultOriginal(int[] result, int lotation, char[] results) {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i <result.length; i ++ ) {
//			result[i] = temp[(i+lotation)% 10]; 
//			result[i] = result[i] + 97;
//			
//			if ( result[i] > 122 ) {
//				result[i] -= 97;
//			}
//			
//			
//			results[i] = (char) result[i];
//			System.out.println(results[i]);
			
			System.out.print((char)(result[(i+lotation)% 10] + 97));	
		}
	}

	private static void resultPass(int[] result, int lotation, char[] results ) {
		// TODO Auto-generated method stub
		int temp[] = result;
		for ( int i = 0 ; i <result.length; i ++ ) {
//			result[i] = temp[(i+lotation)% 10]; 
//			result[i] = result[i] + 97;
//			
//			if ( result[i] > 122 ) {
//				result[i] -= 97;
//			}
//			
//			
//			results[i] = (char) result[i];
//			System.out.println(results[i]);
			
			System.out.print((char)(result[(i+lotation)% 10] + 97));	
		}
	}
}
