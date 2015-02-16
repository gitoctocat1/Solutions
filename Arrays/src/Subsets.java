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
}
