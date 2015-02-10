public class MajorityElement {

	/**
	 * Complexity O(n) Majority element appears more than n/2 times in the array
	 * 
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {

		int counter = 0;

		// empty array return -1
		if (num.length == 0) {
			return -1;
		}

		int majority = num[0];

		for (int i = 0; i < num.length; i++) {

			if (counter == 0) {
				majority = num[i];
			}
			// if same element increment count else decrement; finally only the
			// majority element will be left
			if (num[i] == majority) {
				counter++;
			} else {
				counter--;

			}
		}
		return majority;
	}
}
