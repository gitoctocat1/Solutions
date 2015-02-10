public class ReverseInteger {

	/**
	 * Complexity O(n)
	 * Check for integer overflow and underflow
	 * @param x
	 * @return
	 */
	public int reverse(int x) {

		boolean isNegative = false;

		// check if integer is negative
		if (x < 0) {
			isNegative = true;
			x = -x;
		}

		int z = 0;

		while (x > 0) {

			// get the last digit
			int y = x % 10;

			// handle overflow/underflow
			if (Math.abs(z) > (Math.pow(2, 31) / 10)) {
				return 0;
			}

			z = (z * 10) + y;

			x = x / 10;
		}

		if (isNegative) {
			return -z;
		}

		return z;
	}

}
