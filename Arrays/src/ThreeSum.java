import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
	
	public static void main(String[] args) {
		int[] num = {-7,-5,5,-6,-2,1,7,3,-4,-2,-2,-4,-8,-1,8,8,-2,-7,3,2,-7,8,-3,-10,5,2,8,7,7}; 
		threeSum(num);
		
	}

	/**
	 * Complexity O(n^2)
	 * @param num
	 * @return
	 */
	 public static List<List<Integer>> threeSum(int[] num) {
	        
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 
			if (num.length < 3)
				return result;
		 
			// sort array
			Arrays.sort(num);
		 
			for (int i = 0; i < num.length - 2; i++) {
				// //avoid duplicate solutions
				if (i == 0 || num[i] > num[i - 1]) {
		 
					int negate = -num[i];
		 
					int start = i + 1;
					int end = num.length - 1;
		 
					while (start < end) {
						//case 1
						if (num[start] + num[end] == negate) {
							ArrayList<Integer> temp = new ArrayList<Integer>();
							temp.add(num[i]);
							temp.add(num[start]);
							temp.add(num[end]);
		 
							result.add(temp);
							start++;
							end--;
							//avoid duplicate solutions
							while (start < end && num[end] == num[end + 1])
								end--;
		 
							while (start < end && num[start] == num[start - 1])
								start++;
						//case 2
						} else if (num[start] + num[end] < negate) {
							start++;
						//case 3
						} else {
							end--;
						}
					}
		 
				}
			}
		 
			return result;
	    }
}
