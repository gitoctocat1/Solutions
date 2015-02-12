import java.util.Arrays;


public class AnagramChecker {
	
	
	/**
	 * Complexity O(n)
	 * Increment the value in count array for characters in str1 and decrement for characters in str2. 
	 * Finally, if all count values are 0, then the two strings are anagram of each other. 
	 * optimization : If only english characters are allowed, use count array size = 52 (26 upper+ 26 lower). 
	 * use a[i]-'A' as index to array
	 * @param str1
	 * @param str2
	 * @return
	 */
	public boolean checkAnagram(String str1, String str2)
	{
	    // Create a count array and initialize all values as 0
	    int[] count = new int[256];
	    int i;
	 
	    // If both strings are of different length. Removing this condition
	    // will make the program fail for strings like "aaca" and "aca"
	    if(str1.length() != str2.length()){
	    	return false;
	    }
	    
	    char[] a = str1.toCharArray();
	    char[] b = str2.toCharArray();
	    
	    // For each character in input strings, increment count in
	    // the corresponding count array
	    for (i = 0; i< str1.length();  i++)
	    {
	        count[a[i]]++;
	        count[b[i]]--;
	        
	    }
	 
	   
	    // See if there is any non-zero value in count array
	    for (i = 0; i < 256; i++)
	        if (count[i] != 0)
	            return false;
	     return true;
	}

	
	private static boolean isAnagram(String str1, String str2) {
        // If length of strings are not same, the strings are not anagrams.
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
 
        char[] str1Chars = str1.toLowerCase().toCharArray();
        StringBuilder builder = new StringBuilder(str2.toLowerCase());
 
        for (Character ch : str1Chars) {
 
            // Find the index of the current character in builder.
            int index = builder.indexOf(String.valueOf(ch));
            if (index == -1) {
                return false;
            }
            // Remove the character from builder so that multiple occurrences of
            // a character in the first string will be matched with equal number
            // of occurrences of the character in the second string.
            builder.delete(index, index + 1);
        }
        return true;
    }

	
	 private static boolean isAnagram1(String str1, String str2) {
		 
	        // If string lengths are not same, the strings are not anagrams.
	        if (str1.length() != str2.length()) {
	            return false;
	        }
	 
	        // Sort characters of both the strings.
	        str1 = sortCharacters(str1);
	        str2 = sortCharacters(str2);
	 
	        // After sorting if strings are equal then they are anagrams.
	        if (str1.equals(str2)) {
	            return true;
	        }
	        return false;
	    }
	 
	 private static String sortCharacters(String str) {
	        char[] charArray = str.toLowerCase().toCharArray();
	        Arrays.sort(charArray);
	        return String.valueOf(charArray);
	    }
	 
}
