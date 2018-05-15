package com.restart.algorithm;

import java.util.ArrayList;

public class Permutation {
	static int n;
	public static void main(String[] args) {
		
		// n : 전체 원소의 개수
		// picked : 지금까지 고른 원소의 개수
		// isPick : 이전에 선택된 원소인지 저장하고있는 변수
		// n개의 원소의 모든 순열을 구하는 방법
		n = 5;
		
		ArrayList<Integer> picked = new ArrayList<>();
		boolean[] isPick = new boolean[n];
		
		permutation(picked, isPick);

		
	}
	
	public static void permutation( ArrayList<Integer> picked, boolean isPick[] ){
	    // 기저사례 : 모든 개수를 뽑아냈다.
	    if( picked.size() == n ){
	        System.out.println(picked);
	        return ;
	    }
	     
	    for(int next = 0; next < n; next++){
	        if( isPick[next] )
	            continue;
	         
	        picked.add(next);
	        isPick[next] = true;
	         
	        permutation( new ArrayList<Integer>(picked), isPick );
	         
	        picked.remove(picked.size()-1);
	        isPick[next] = false;
	    }
	}
		
}
