package com.algorithm.yeon;

import java.util.Scanner;

//째로 탈출 2
public class Test02 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int result = 10;
		
		String map[][] = new String[n][m];
		for ( int i = 0; i < n; i ++ ) {
			String str = scan.next();
			for ( int j = 0 ; j < m; j ++ ) {
				map[i][j] = str.charAt(j) + "";
			}
		}
		
		
//		print(map);
		//문자열 R과 B의 위치를 찾아낸다음 움직이는 경우의수를 생각한다...
		//움직일 수 있는 방향은 네가지;
		//한번 움직이면 
		//0.결과 확인 .
		//1.빨간공 이동(위치체크)
		//2. 파랑공 이동(위치체크)
		//0~2 반복 
		// 10번 이하로 움직여서 빨간공이 탈출하면  움직인 수 출력 
		// 그 이상이면 -1 출력...
		Ball redBall = new Ball();
		Ball blueBall = new Ball();
		redBall.setBallType("R");
		blueBall.setBallType("B");
		
		//공 좌표 기록 
		searchBallLocation(redBall, map);
		searchBallLocation(blueBall, map);
		
		result = playGame ( map, redBall, blueBall, 0);
		
		
		
//		System.out.println(redBall.getX() + ", " + redBall.getY());
		System.out.println(result);
		
	}



	private static int playGame(String[][] map, Ball redBall, Ball blueBall, int i) {
		// TODO Auto-generated method stub
		
		if ( map[redBall.getX()][redBall.getY()].equals("O") && i <= 10) {
			//공이 빠져나갔을 때 움직인 회수를 출력 ..
			return i;
		}
		
		//왼쪽으로 이동가능하다면 이동 
		if ( redBall.getY() > 0  && map[redBall.getX()][redBall.getY()-1] != "#" ) {
			redBall.setY( redBall.getY() - 1 );
			return playGame( map, redBall, blueBall, i + 1 );
		}
		//위로 이동가능하다면 이동
		else if ( redBall.getX() > 0 && map[redBall.getX()-1][redBall.getY()] != "#" ) {
			redBall.setX( redBall.getX() - 1 );
			return playGame( map, redBall, blueBall, i + 1 );
		}
		//우측으로 이동가능하다면 이동
		if ( redBall.getY() < map[0].length-1 && map[redBall.getX()][redBall.getY()+1] != "#" ) {
			redBall.setY( redBall.getY() + 1 );
			return playGame( map, redBall, blueBall, i + 1 );
		}
		//아래로 이동가능하다면 
		else if ( redBall.getX() < map.length-1 && map[redBall.getX()+1][redBall.getY()] != "#" ) {
			redBall.setX( redBall.getX() + 1 );
			return playGame( map, redBall, blueBall, i + 1 );
		}
		
		return 0;
		
	}



	private static void searchBallLocation(Ball ball, String[][] map) {
		// TODO Auto-generated method stub
		for ( int i = 0; i < map.length; i ++ ) {
			for ( int j = 0 ; j < map[0].length; j ++ ) {
				if ( map[i][j].equals( ball.getBallType() ) ) {
					ball.setX(i);
					ball.setY(j);
				}
			}
		}
	}



	private static void print(String[][] map) {
		// TODO Auto-generated method stub
		for ( int i = 0; i < map.length; i ++ ) {
			for ( int j = 0; j < map[0].length; j ++ ) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}
	
}

class Ball {
	
	//행 
	private int x;
	//열 
	private int y;
	
	private String ballType;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getBallType() {
		return ballType;
	}
	public void setBallType(String ballType) {
		this.ballType = ballType;
	}
	
	
}
