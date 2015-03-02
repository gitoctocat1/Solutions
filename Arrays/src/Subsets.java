import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	/**
	 * Complexity O(n lg n) due to sorting
	 * @param S
	 * @return
	 */
	public List<List<Integer>> subsets(int[] S) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (S.length == 0) {
			return result;
		}

		// sort the array
		Arrays.sort(S);

		for (int i = 0; i < S.length; i++) {

			List<List<Integer>> temp = new ArrayList<List<Integer>>();

			for (List<Integer> l : result) {
				temp.add(l);
			}

			// add S[i] to existing sets
			for (List<Integer> l : temp) {
				List li = new ArrayList(l);
				li.add(S[i]);
				result.add(li);
			}

			// add S[i] as single list e.g {1}, {2},{3}
			List<Integer> list = new ArrayList<Integer>();
			list.add(S[i]);
			result.add(list);
		}

		// add an empty set to result
		result.add(new ArrayList<Integer>());

		return result;
	}
	
	/**
	 * Complexity O(n lg n)
	 * @param num
	 * @return
	 */
	 public List<List<Integer>> subsetsWithDup(int[] num) {
	        
     	List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (num.length == 0) {
			return result;
		}

		// sort the array
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {

			List<List<Integer>> temp = new ArrayList<List<Integer>>();

			for (List<Integer> l : result) {
				temp.add(l);
			}

			// add num[i] to existing sets
			for (List<Integer> l : temp) {
				List li = new ArrayList(l);
				
				
				 li.add(num[i]);
			
			 //check for duplicate lists
			  if(!result.contains(li)){
				result.add(li);
			  }	
			}

			// add num[i] as single list e.g {1}, {2},{3}
			List<Integer> list = new ArrayList<Integer>();
			list.add(num[i]);
			
			 //check for duplicate lists
			if(!result.contains(list)){
			  result.add(list);
			}	
		}

		// add an empty set to result
		result.add(new ArrayList<Integer>());

		return result;
     
 }
	 
	 
	 /**
	  * Complexity O(m lg m + n lgn )
	  *  Return 1 if arr2[] is a subset of arr1[] 
	  *  */
	 boolean isSubset(int arr1[], int arr2[], int m, int n)
	 {
	     int i = 0, j = 0;
	      
	     if(m < n)
	        return false;
	  
	     Arrays.sort(arr1);
	     Arrays.sort(arr2);
	     
	     while( i < n && j < m )
	     {
	         if( arr1[j] <arr2[i] )
	             j++;
	         else if( arr1[j] == arr2[i] )
	         {
	             j++;
	             i++;
	         }
	         else if( arr1[j] > arr2[i] )
	             return false;
	     }
	   
	     if( i < n )
	         return false;
	     else
	         return true;
	 }
}
