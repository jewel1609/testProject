package ebay.yeon.quest;

public class DFSCAL {
	public static void main(String[] args) {
		
		
		
		dfs("", 1, 1, 1, 1);
		
		
	}

	private static void dfs(String str, int p, int m, int x, int d) {
		// TODO Auto-generated method stub
		//기저사례
		if ( str.length() == 4 ) {
			System.out.println(str);
			return;
		}else {
			
			if ( p > 0 ) {
				dfs ( str+"+", p-1, m, x, d);
			}
			if ( m > 0 ) {
				dfs ( str+"-", p, m-1, x, d);
			}
			if ( x > 0 ) {
				
				dfs ( str + "*", p, m, x-1, d);
			}
			if ( d > 0 ) {
				dfs ( str + "/", p, m, x, d-1);
			}
		}
		str = "";
		
	}
}
