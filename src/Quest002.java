
public class Quest002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = new int[4];
		arr[0] = 4;
		arr[1] = 1;
		arr[2] = 3;
		arr[3] = 2;
		
		for ( int i = 0; i < arr.length-1; i ++ ) {
			int temp;
			for ( int j = i+1; j < arr.length; j ++ ) {
				if ( arr[i] > arr[j] ) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		
		for ( int i = 0; i < arr.length; i ++ ) {
			System.out.println(arr[i]);
		}

		System.out.println(solution(arr));

	}

	private static boolean solution(int[] arr) {
		// TODO Auto-generated method stub
		boolean answer = true;
		
		for ( int i = 0, j = 1; i < arr.length; i ++, j++ ) {
			
			if ( j != arr[i]) {
				answer = false;
			}
			
        }
		return answer;
	}

}
