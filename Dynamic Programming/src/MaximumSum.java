public class MaximumSum {

	/**
	 * Complexity O(n) and space O(1)
	 * @param A
	 * @return
	 */
	public int maxSumSubArray(int[] A) {

		int currentSum = A[0];

		int maxSum = A[0];

		for (int i = 1; i < A.length; i++) {

			// compare n with sum of n-1 elements

			currentSum = Math.max(A[i], currentSum + A[i]);

			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}

	/**
	 * Complexity O(n) and space O(n)
	 * 
	 * @param A
	 * @return
	 */
	public int maxSubArray(int[] A) {

		int[] sum = new int[A.length];

		int max = A[0];

		sum[0] = A[0];

		for (int i = 1; i < A.length; i++) {

			// compare n with sum of n-1 elements

			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);

			max = Math.max(sum[i], max);

		}

		return max;
	}

}
