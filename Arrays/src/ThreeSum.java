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
		 
					int j = i + 1;
					int k = num.length - 1;
		 
					while (j < k) {
						//case 1
						if (num[j] + num[k] == negate) {
							ArrayList<Integer> temp = new ArrayList<Integer>();
							temp.add(num[i]);
							temp.add(num[j]);
							temp.add(num[k]);
		 
							result.add(temp);
							j++;
							k--;
							//avoid duplicate solutions
							while (j < k && num[k] == num[k + 1])
								k--;
		 
							while (j < k && num[j] == num[j - 1])
								j++;
						//case 2
						} else if (num[j] + num[k] < negate) {
							j++;
						//case 3
						} else {
							k--;
						}
					}
		 
				}
			}
		 
			return result;
	    }
}
