public class PalindromeInteger {

	/**
	 * Complexity O(n)
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {

		int div = 1;

		if (x < 0) {
			return false;
		}

		while (x / div >= 10) {
			div = div * 10;
		}

		while (x != 0) {

			// get the first digit
			int l = x / div;
			// get the last digit
			int r = x % 10;

			// compare
			if (l != r) {
				return false;
			}

			x = (x % div) / 10;
			div = div / 100;
		}
		return true;
	}
}
