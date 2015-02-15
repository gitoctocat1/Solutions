public class SortColors {

	/**
	 * aka Dutch Flag Problem
	 * Complexity O(n)
	 * @param A
	 */
	public void sortColors(int[] A) {

		int[] colors = new int[3];

		for (int i = 0; i < A.length; i++) {

			int num = A[i];

			// use num as index into the colors array
			colors[num]++;

		}

		for (int i = 0; i < A.length; i++) {

			for (int j = 0; j < colors.length; j++) {

				// if color count is greater than 0, set i elements in A to be
				// that color
				if (colors[j] > 0) {
					A[i] = j;
					colors[j]--;
					break;
				}
			}
		}
	}

}
