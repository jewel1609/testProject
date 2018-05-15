package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class MatchWildCard {
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("matchWildCard.txt"));
		
		String w = sc.next();
		String s = sc.next();
		
		boolean result = matchWildCard(w, s);
		System.out.println(w.length());
		
	}

	private static boolean matchWildCard(String w, String s) {
		// TODO Auto-generated method stub
		//w.charAt(pos) 과 s.charAt(pos) 를 맞춰나간다.
		int pos = 0;
		
		//글자가 대응이 안될 때까지 와일문을 돈다. 
		while ( pos < w.length() && pos < s.length() && w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos) ) {
			pos++;
		}
		
		//패턴이 끝난 경우 
		if ( pos == w.length() ) return pos == s.length();
		
		//*를 만난경우 : *에 몇글자를 대응시켜야 하는지, 재귀함수를 통해 확인한다. 
		if ( w.charAt(pos) == '*' ) {
			for ( int skip = 0; pos+skip <= s.length(); skip++ ) {
				if ( matchWildCard(w.substring(pos+1), s.substring(pos+skip) ) ) {
					return true;
				}
			}
		}
		
		return false;
	}

}
