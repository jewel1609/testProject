package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;


public class blutoothCal {
	//인접 행렬 
	public static int[][] a; 
	public static int n;
	static int[] nums;
	static int[] operator;
	static boolean opVisited[];
	static int index;
	static boolean flag;
	static Stack<Integer> stack;
	static int ret;
	static int[] line;
	
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("calSelect.txt"));
		
		n = sc.nextInt();
		nums = new int[n];
		operator = new int[n-1];
		opVisited = new boolean[n-1];
		a = new int[n-1][n-1];
		stack = new Stack<>();
		line = new int[n-1];
		
		for ( int i = 0; i < n; i ++ ) {
			nums[i] = sc.nextInt();
		}
		index = 0;
		for ( int i = 0 ; i < 4; i ++ ) {
			int opCount = sc.nextInt();
			while ( opCount > 0 ) {
				operator[index] = i;
				index++;
				opCount--;
			}
		}
		
		
		//인정행렬 초기화 
		for ( int i = 0 ; i < a.length; i++ ) {
			for ( int j = 0 ; j < a[0].length;j++) {
				if ( i != j ) {
					a[i][j] = 1;
				}
			}
		}
		
		ret = 0;
		
		for ( int i = 0; i < a.length;i ++ ) {
			for ( int j = 0; j < a.length;j ++ ) {
				operatorDFS(i, j, 0);
				
				//visited ( 초기화 ) 
			    setVist();
			}
		}
//		System.out.println(ret);
		System.out.println(MAX);
		System.out.println(MIN);
		
	}
	private static void calculator() {
		// TODO Auto-generated method stub
		int ret = nums[0];
		int n = line.length;
		
		for ( int i = 0; i < nums.length-1;i++) {
			//숫자 
			switch (operator[ line[i] ] ) {
			case 0: ret = ret + nums[i+1];
			//time error? 
				break;
			case 1: ret = ret - nums[i+1];
				break;
			case 2: ret = ret * nums[i+1];
				break;
			case 3: ret = ret / nums[i+1];
				break;
			}		
		}
		if ( ret > MAX ) {
			MAX = ret;
		}
		if ( ret < MIN ) {
			MIN = ret;
		}
	}
	private static void setVist() {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < opVisited.length;i++) {
			opVisited[i] = false;
		}
		
	}
	private static void operatorDFS(int index, int goal, int len) {
		// TODO Auto-generated method stub
		
		opVisited[index] = true;
		stack.push(index);
		
		if ( index == goal && len+1 == nums.length-1 ) {
			
			//스택 출력
			int count = stack.size();
			for ( int i = 0; i < count; i ++ ) {
//				System.out.println(stack.elementAt(i) + " ");
				line[i] = stack.elementAt(i);
			}
//			System.out.println("출력 완료 ");
//			System.out.println("계산  ");
			
			//연산자 넣어서 계산 
			calculator();
			
			ret++;
			stack.pop();
			return;
		}
		
		for ( int i = 0; i < a.length; i++ ) {
			if ( a[index][i] == 1 && !opVisited[i] ) {
				operatorDFS(i , goal, len+1);
				opVisited[i] = false;
			}
		}
		stack.pop();
	}

	
}
