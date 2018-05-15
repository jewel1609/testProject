package ebay.yeon.quest;

import java.util.Scanner;

public class Test02 {
	public static int[][] arr;
	public static int leftCount = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int M = sc.nextInt();
		
		int temaM = K - M;
		
		calSelectCount(N, M, 0, N);
//		System.out.println(leftCount +"결과 ");
		calSelectCount(N, temaM, 0, N);
		
		System.out.println(leftCount);

	}

	public static void calSelectCount(int n, int m, int count, int ret) {
		
		if (count == m - 1) {
			int mFac = mFactorial(m);
//			System.out.println(ret + " ret");
//			System.out.println(mFac);
			leftCount *=  ret / mFac;
			return;
		}

		if (n > 0 && count < m) {
			n = n - 1;
			ret *= n;
			count++;
			calSelectCount(n, m, count, ret);
		}
	}

	public static int mFactorial(int m) {
		if (m == 0 || m == 1)
			return 1;

		return m * mFactorial(m - 1);
	}
}
