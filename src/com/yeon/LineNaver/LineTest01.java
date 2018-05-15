package com.yeon.LineNaver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class WorkInfo {
	
	int startDay;
	int duration;
	int money;
	
	public WorkInfo ( int startDay, int duration, int money ) {
		this.startDay = startDay;
		this.duration = duration;
		this.money = money;
	}
}



public class LineTest01 {
	
	static ArrayList<WorkInfo> works;
	static int n;
	static int max = 0;
	static StringBuffer sb;
	static String str;
	public static void main(String[] args) throws Exception {
		
		try ( BufferedReader br = new BufferedReader(new FileReader("line01.txt"))) {
			
			n = Integer.parseInt(br.readLine().trim());
			works = new ArrayList<>();
			for ( int i = 0 ; i < n; i ++ ) {
				StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
				
				int startDay = Integer.parseInt(tokens.nextToken());
				int duration = Integer.parseInt(tokens.nextToken());
				int money = Integer.parseInt(tokens.nextToken());
				sb = new StringBuffer();
				str = "";
				works.add(new WorkInfo(startDay, duration, money));
				
			}
			
			//완전 탐색 
			dfs(0, 0, 0);
			
			System.out.println(max);
			System.out.println(str);
		}catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("파일이 존재하지 않습니다.");
//			e.printStackTrace();
		}
		
	}

	private static void dfs(int startDay, int index, int money) {
		// TODO Auto-generated method stub
		if ( index == n-1 ) {
			if ( max < money ) {
				max = money;
				str = sb.toString();
			}
			sb = new StringBuffer();
			
			return;
		}else {
			
			//일할수 있는 날이면 일하기 
			if ( startDay <= works.get(index).startDay ) {
				sb.append(startDay + " " + works.get(index).duration + "\n");
				dfs( startDay + works.get(index).duration, index+1, money + works.get(index).money );
			}
			
			//일 안하고 다음 날로 넘기기 .
			dfs ( works.get(index+1).startDay, index+1, money);
			
		}
	}
}
