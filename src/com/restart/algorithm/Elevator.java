package com.restart.algorithm;

import java.io.FileInputStream;
import java.util.Scanner;

public class Elevator {
	public static int moveDistance;
	public static int curElevatorPos = 1;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("elevator.txt"));
		
		int n = sc.nextInt();
		
		for ( int i = 0 ; i < n ; i ++ ) {
			int startPos = sc.nextInt();
			int endPos = sc.nextInt();
			System.out.println("---");
			//엘레베이터 현재 위치체크 
			if ( curElevatorPos > startPos ) {
				moveDistance += (curElevatorPos - startPos -1 );
				curElevatorPos = startPos;
				
			}
			else if ( curElevatorPos < startPos ) {
				moveDistance += (startPos - curElevatorPos -1 );
				curElevatorPos = startPos;
			}
			
			//목적지로 이동 
			if ( startPos < endPos ) {
				moveDistance += (endPos - startPos ); 
				curElevatorPos = endPos;
			}else if ( startPos > endPos ) {
				moveDistance += (startPos - endPos );
				curElevatorPos = endPos;
			}
			System.out.println(moveDistance);
		}
		
		System.out.println(moveDistance);
		
	}
}
