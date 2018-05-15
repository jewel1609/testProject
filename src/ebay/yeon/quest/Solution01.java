package ebay.yeon.quest;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution01 {
	
	public static void main(String[] args)  throws Exception {
		
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		Queue<String> q = new LinkedList<String>();
		int n = sc.nextInt();
		String[] votes = new String[n];
		
		int A = 4;
		int K = 4;
		int P = 1;
		
		int result = minNum( A, K, P );
		
		System.out.println(result);
		
		
	}
	
	static int minNum(int A, int K, int P) {
        
        int ans = 0;
        int cnt = 0;
        //a+p < k가 되는 일수를 찾아라 . 일수는 첫째날부터 시작
        while ( true ) {
            cnt+=1;     
            
            if ( cnt*A + P < cnt*K ) {
                ans = cnt;
                break;
            }
                    
            
            A += A;
            K += K;
        }        
        
        return ans;
    }
	
	
}
