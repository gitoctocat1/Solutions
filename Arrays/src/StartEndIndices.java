
public class StartEndIndices {
	
	public static void main(String[] args) {
		int[] a = {1,1,2,3,4,5,6};
		System.out.println(getFirstIndex(a, 2));
		System.out.println(getLastIndex(a, 2));
		
	}

	public static int getLastIndex(int[] A, int N) {
		int i = 0;
		int j = A.length - 1;
		int m = 0;
		while (i < j) {
			
			m = (i + j) / 2;
			
			if (A[m] <= N) {
				
				i = m + 1;
				
			} else {
				
				j = m - 1;
			}
			
		}
		return i;
	}
	
	
	public static int getFirstIndex(int[] A, int N) {
		int i = 0;
		int j = A.length - 1;
		int m = 0;
		while (i < j) {
			
			m = (i + j) / 2;
			
			if (A[m] >= N) {
				
				j = m -1 ;
				
			} else {
				
				i = m + 1;
			}
			
		}
		return i;
	}
}
