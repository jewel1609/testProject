package com.yeon.LineNaver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class LineTest03 {
	static ArrayList<ArrayList<Integer>> lists;
	public static void main(String[] args) throws Exception {
		
		try ( BufferedReader br = new BufferedReader(new FileReader("line03.txt"))) {
			
			int n = Integer.parseInt(br.readLine().trim());
			System.out.println(n);
			lists = new ArrayList<>();
			int count = 0;
			for ( int i = 0 ; i < n ; i++ ) {
				StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(tokens.nextToken());
				int y = Integer.parseInt(tokens.nextToken());
//				System.out.println(x + " ," + y);
				ArrayList<Integer> numberList = new ArrayList<>();
				numberList.add(x);
				numberList.add(y);
				
				if ( lists.size() == 0 ) {
					lists.add(numberList);
				}
				else {

					for ( int j = 0 ; j < lists.size();j++ ) {
						for ( int k = 0; k < lists.get(j).size(); k++ ) {
							int curNum = lists.get(j).get(k);
							System.out.println(curNum);
							if ( curNum != x && curNum != y ) {
								lists.add(numberList);
								count++;
								break;
							}else if ( curNum == x || curNum == y ) {
								lists.get(j).add(x);
								lists.get(j).add(y);
								break;
							}
						}
					}
					
				}
				
			}
			System.out.println(lists.size());
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}	
