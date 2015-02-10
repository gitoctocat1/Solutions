import java.util.Arrays;

public class ThreeSumClosest {

	/**
	 * Complexity O(n ^2)
	 * Sort the array and use three pointers; get the current sum and compare against the minimum difference
	 * @param num
	 * @param target
	 * @return
	 */
	public int threeSumClosest(int[] num, int target) {

		int result = 0;

		int minDiff = Integer.MAX_VALUE;

		if (num.length == 0) {
			return result;
		}
		
        //sort the array
		Arrays.sort(num);

		for (int i = 0; i < num.length; i++) {
			int j = i + 1;
			int k = num.length - 1;

			while (j < k) {
				//get the sum of three elements
				int currentSum = num[i] + num[j] + num[k];

				//get the diff between current sum and target sum
				int diff = Math.abs(currentSum - target);

				//current sum is equal to target sum
				if (diff == 0) {
					return currentSum;
					
				} else if (diff < minDiff) {
					//update the mindiff 
					minDiff = diff;
					result = currentSum;
				}

				//depending on if the sum is closer or far from the target, adjust the pointers
				if (currentSum < target) {
					j++;
				} else {
					k--;
				}
			}
		}

		return result;

	}
}
