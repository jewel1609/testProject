package com.samsung.go.yeon;

import java.util.Scanner;

public class AllSelectNumber {	
	static int[] nums = {1,2,3,5,8,13,21,34 };
	public static void main(String[] args) {
		//ex 1,2,3,4,5,6 중 4개로 이루어진 순열을 모두 출력하라.
		
		Scanner sc = new Scanner(System.in);
		
		dfs("", 0, 0);
	}
	private static void dfs(String str, int index,int cnt) {
		// TODO Auto-generated method stub
		if ( index == 8 ) {
			if ( cnt == 6 ) {
				System.out.println(str);
			}
			return;
		}else {
			//선택 하는 경우
			dfs(str+nums[index], index+1, cnt+1);
			//선택하지 않고 넘어가는 경우 
			dfs(str, index+1, cnt);
			
			
			
		}
	}

}
