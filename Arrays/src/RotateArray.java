public class RotateArray {

	/**
	 * Complexity O(n) and O(1) space
	 * rotates arr[] of size n by d elements.
	 * [1,2,3,4,5,6,7] rotate by 2 = [3,4,5,6,7,1,2]
	 * 
	 * step 1: 0 to d-1 [2,1,3,4,5,6,7]
	 * step 2: d to n-1 [2,1,7,6,5,4,3]
	 * step 3: 0 to n-1 [3,4,5,6,7,1,2]
	 * @param arr
	 * @param d
	 * @param n
	 */
	public void rotate(int arr[], int d, int n) {
		reverseArray(arr, 0, d - 1);
		reverseArray(arr, d, n - 1);
		reverseArray(arr, 0, n - 1);
	}

	/** 
	 * reverse array in-place
	 * @param arr
	 * @param start
	 * @param end
	 */
	private void reverseArray(int[] arr, int start, int end) {
		int i;
		int temp;
		while (start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

	}
}
