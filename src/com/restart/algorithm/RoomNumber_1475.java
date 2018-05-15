package com.restart.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RoomNumber_1475 {
	public static int[] visitedNum = new int[10];
	public static int numLength;
	public static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//세트방문여 초기화
		settingVist();
		//큐 초기화
		settingQ(n);
		
		int ret = countSetting(n);
		System.out.println(ret);
	}
	private static void settingQ(int n) {
		String number = n + "";
		String [] nums = number.split("");
		numLength = nums.length;
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < nums.length; i ++ ) {
			q.add( Integer.parseInt(nums[i]) );
		}
		
	}
	private static void settingVist() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < 10; i++ ) {
			visitedNum[i] = 0;
		}
	}
	private static int countSetting(int n) {
		// TODO Auto-generated method stub
		int setCount = 1;
		
		//숫자를 간판에 다 사용했다면 반복문을 빠져나온다 . 
		while ( true ) {
			//맨 앞의 숫자 q.peek()
			int check = q.peek();
			//방문하지 않았다면 방문하고 삭제
			int count = 0;
			for ( int i = 0; i < numLength; i ++ ) {
				if ( visitedNum[q.peek()] == 0 ) {
					visitedNum[q.peek()] = 1;
					q.remove();
					count++;
				}
				else if ( q.peek() == 6 && visitedNum[q.peek()] == 1 && visitedNum[9] == 0) {
					visitedNum[9] = 1;
					q.remove();
					count++;
				}
				else if ( q.peek() == 9 && visitedNum[q.peek()] == 1 && visitedNum[6] == 0) {
					visitedNum[6] = 1;
					q.remove();
					count++;
				}
				else if ( visitedNum[q.peek()] == 1 ) {
					int temp = q.remove();
					q.add(temp);
				}
			}
			if ( q.size() == 0 ) break;
			numLength =	q.size();
//			//방문하고 남은 숫자들 
//			//방문할 수 없으므로 세트를 하나 더 늘려서 초기화 한다.
			settingVist();
			setCount++;
		}
			
		return setCount;
	}
}
