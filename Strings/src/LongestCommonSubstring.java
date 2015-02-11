
public class LongestCommonSubstring {

	/**
	 * Complexity O(n)
	 * Create a character array to keep track of visited characters in the string
	 * 
	 * @param s
	 * @return
	 */
	 public int lengthOfLongestSubstring(String s) {
		    
		    boolean[] charExists = new boolean[256];

				int result = 0;
				int j = 0;
				int i = 0;
				char[] arr = s.toCharArray();

				
				while (i < s.length()) {
					char c = arr[i];
					//if character already encountered before
					if (charExists[c]) {
						result = Math.max(result, i - j);
						
						while (arr[j] != c) {
							
							// Set charExists to false till the first occurrence of c
							// p a b c d b x y
							// In the above example when you hit the second 'b' (after
							// pabcd),
							// we only set flag false for p a since there can be a valid
							// substring c d b x y
							charExists[arr[j]] = false;
							j++;
						}

						//move forward by one from visited character
						j++;

					} else {
						//first occurence of character
						charExists[c] = true;
					}
					i++;
				}

				return Math.max(i - j, result);
				
		    }
}
