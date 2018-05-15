package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Samsung03 {
	
	static int n, m;
	static int [][] a;
	static int [][][] d;
	static int t1, t2;
	static int ans;
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		n = sc.nextInt();
		m = sc.nextInt();
		a = new int[102][102];
		d = new int[101][101][101];
		t1 = sc.nextInt();
		t2 = sc.nextInt();
		
		for ( int i = 0; i < t1; i++ ) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x][y] = 1;
		}
		
		for ( int i = 0; i < t2; i ++ ) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x][y] = 2;
		}
		
		for ( int i = 0 ; i < d.length; i ++ ) {
			for ( int j = 0 ; j < d[0].length; j ++ ) {
				Arrays.fill(d[i][j], -1);
			}
		}
		
		
		//1,1 에서 n,m까지 가는 경로 
		//방향은 두가지 만 존재 x+1,y  혹은 x, y+1 
		//모든 경우의 수 출력 
		
		
		System.out.println(go(1, 1, a[0][0]));
		
	
	}
	private static int go(int x, int y, int cnt) {
		// TODO Auto-generated method stub
		
		if (x > n || y > m) return 0;
        if (a[x][y] == 2) return 0;
        if ( x == n && y == m && cnt == t1) {
        	return 1;
        }
        
        int ans = d[x][y][cnt];
        if ( ans != -1 ) return ans;
        ans = 0;
        
        ans += go ( x+1, y, cnt+a[x+1][y]);
        ans += go ( x, y+1, cnt+a[x][y+1]);
        d[x][y][cnt] = ans;
        
        return ans;
        
	}
	
}
