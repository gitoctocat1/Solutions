public class LongestPalindromicSubsequence {

	public static void main(String[] args) {

		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		String s = "XAYBZBA";
		System.out.println(lps.findLPS(s, s.length()));
	}

	/**
	 * Complexity O(n ^2)
	 * @param X
	 * @param n
	 * @return
	 */
	public int findLPS(String X, int n) {

		int[][] LPS = new int[n][n];

		// initialize: string of length 1 is a palindrome
		for (int i = 0; i < X.length(); i++) {
			LPS[i][i] = 1;
		}

		for (int k = 1; k < n; k++) {

			int i = 0;
			int j = k;

			while (i < n && j < n) {

				if (X.charAt(i) == X.charAt(j)) {
					
					LPS[i][j] = LPS[i + 1][j - 1] + 2;
					
				} else {
					
					LPS[i][j] = Math.max(LPS[i + 1][j], LPS[i][j - 1]);
				}

				i++;
				j++;
			}
		}

		return LPS[0][n - 1];
	}
}
