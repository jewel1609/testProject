
public class Quest003_Square {

	public static void main(String[] args) {

		int [] answer = {};
		int x = 0,y =0;
		int[][] v = {

			    {1,4},

			    {3,4},

			    {3,10}

			  };
		
		//x좌표가 1개인거 찾아서 리턴 
			x = v[0][0]^v[1][0]^v[2][0]; 
		
		//y좌표가 1개인거 찾아서 리턴 
			y = v[0][1]^v[1][1]^v[2][1];
		answer = new int[]{x,y};
		System.out.println(v.length);
		System.out.println(v[0].length);
	}
}
