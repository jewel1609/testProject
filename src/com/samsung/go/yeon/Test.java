package com.samsung.go.yeon;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    static int n, m, t1, t2;
    static int[][] a = new int[102][102];
    static int[][][] d = new int[101][101][101];
    static int go(int x, int y, int cnt) {
    	System.out.println(x + " , " + y );
        if (x > n || y > m) return 0;
        if (a[x][y] == 2) return 0;
        if (x == n && y == m && cnt == t1) {
            return 1;
        }
        int ans = d[x][y][cnt];
        if (ans != -1) return ans;
        ans = 0;
        ans += go(x+1,y,cnt+a[x+1][y]);
        ans += go(x,y+1,cnt+a[x][y+1]);
        d[x][y][cnt] = ans;
        return ans;
    }

    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(new FileInputStream("input.txt"));
//        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t1 = sc.nextInt();
        t2 = sc.nextInt();
        for (int i=0; i<t1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x][y] = 1;
        }
        for (int i=0; i<t2; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x][y] = 2;
        }
        for (int i=0; i<101; i++) {
            for (int j=0; j<101; j++) {
                Arrays.fill(d[i][j], -1);
            }
        }
        System.out.println(go(1,1,a[1][1]));
    }
}
