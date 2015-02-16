import java.util.ArrayList;
import java.util.List;


public class IntersectionSortedArrays {
	
	
	/**
	 * Complexity O( m + n) where m = length of array1 and n = length of array2
	 * 
	 * Start with first element of A and B; compare and if equal add to result array
	 * @param A
	 * @param B
	 * @return
	 */
	public static int[] findIntersection (int[] A, int[] B){
	
		int[] result = new int[A.length + B.length];
	
		if(A.length == 0 || B.length==0){
			return result;
		}
		
		int i = 0, j = 0, k = 0;
		int m = A.length; int n = B.length;
		
		while (i < m && j < n ){
			
		     if(A[i] < B[j]){
		    	 i++;
		     } else if(A[i] > B[j]) {
		    	 j++;
		     } else {
		    	 result[k] = A[i];
		    	 k++; i++; j++;
		     }
		}
		
		return result;
	}
	
	
	public static List<Integer> findIntersection (List<Integer> A, List<Integer> B){
		
		List<Integer> result = new ArrayList<Integer>();
	
		if(A.size() == 0 || B.size() == 0){
			return result;
		}
		
		int i = 0, j = 0, k = 0;
		int m = A.size(); int n = B.size();
		
		while (i < m && j < n ){
			
		     if(A.get(i) < B.get(j)){
		    	 i++;
		     } else if(A.get(i) > B.get(j)) {
		    	 j++;
		     } else {
		    	 result.add(A.get(i));
		    	 i++; j++;
		     }
		}
		
		return result;
	}

}
