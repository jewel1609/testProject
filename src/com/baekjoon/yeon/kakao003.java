package com.baekjoon.yeon;

public class kakao003 {
	//4
	public static void main(String[] args) {
		int n = 1;
		int t = 1;
		int m = 5;
		String[] timetable = new String[4];
		timetable[0] = "08:00";
		timetable[1] = "08:01";
		timetable[2] = "08:02";
		timetable[3] = "08:03";
		
		solution(n, t, m, timetable);
		
	}

	private static String solution(int n, int t, int m, String[] timetable) {
	      String answer = "";
	      String hours[] = new String[timetable.length];
	      String minutes[] = new String[timetable.length];
	      int count = t;
	      int minHour = 23;
	      int minMinte = 59;
	      
	      //n운행회수, t는 운행간격(분) , m 탈수 있는 최대 크루수 
	      int startBusHour = 9;
	      int startBusMinute = 0; 
	      int crueNumber = timetable.length;
	      //크루 온 시간과 분을 차례대로 저장 . 크루번호 : 0번~ <timetable.length
	      for ( int i = 0; i < timetable.length; i ++ ) {
	    	  hours[i] = timetable[i].substring(0, 2);
	    	  minutes[i] = timetable[i].substring(3, 5);
	      }
	      //크루수 timetable.length;
	      //가장 마지막에 버스 태우기
	      for ( int i = 0; i < n; i ++ ) {
	    	  
	    	  for ( int j = 0; j < timetable.length; j ++ ) {
		    	  if ( Integer.parseInt(hours[j]) <= startBusHour && Integer.parseInt(minutes[j]) <= startBusMinute )  {
		    		  count--;
		    	  }
		    	  
		      }
	    	  
	    	  
	    	  startBusMinute = startBusMinute + m ;
	    	  if (startBusMinute >= 60 ) {
	    		  startBusHour += startBusMinute / 60;
	    		  startBusMinute = startBusMinute % 60; 
	    	  }
	      }
	      
	      
	      
	      
	      
	      
	      
	      
	      return answer;
	}

	private static String String(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
