package com.restart.algorithm;

import java.util.Scanner;


public class CroatiaText {
	
	public static String[] croa = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		input += " ";
		input += " ";
		
		int n = input.length();
		int ret = 0;
		for ( int i = 0 ; i < n; i ++ ) {
			if ( input.charAt(i) == 'c' ) {
				if ( input.charAt(i+1) == '=' || input.charAt(i+1) == '-'  ) {
					i++;
					ret++;
					continue;
				}
			}
			else if ( input.charAt(i) == 'd' ) {
				if ( input.charAt(i+1) == '-' ) {
					i++;
					ret++;
					continue;
				}else if ( input.charAt(i+1) == 'z' && input.charAt(i+2) == '=' ) {
					i += 2;
					ret++;
					continue;
				}
			}
			else if ( input.charAt(i) == 'l' ) {
				if ( input.charAt(i+1) == 'j') {
					i++;
					ret++;
					continue;
				}
			}
			else if ( input.charAt(i) == 'n' ) {
				if ( input.charAt(i+1) == 'j') {
					i++;
					ret++;
					continue;
				}
			}
			else if ( input.charAt(i) == 's' ) {
				if ( input.charAt(i+1) == '=') {
					i++;
					ret++;
					continue;
				}
			}
			else if ( input.charAt(i) == 'z' ) {
				if ( input.charAt(i+1) == '=') {
					i++;
					ret++;
					continue;
				}
			}else if ( input.charAt(i) == ' ') {
				ret--;
			}
			ret++;
		}
		
		System.out.println(ret);
	}
	
	
}
