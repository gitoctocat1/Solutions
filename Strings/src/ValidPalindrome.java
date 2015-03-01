public class ValidPalindrome {

	/**
	 * Complexity O(n)
	 * keep two pointers at the start and end and compare . Skip non alphanumeric 
	 * characters
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			//skip alphanumeric characters
			while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
				i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
				j--;
			
			//if characters dont match not a palindrome
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s
					.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
