public class StringRotation {

	
	public static void main(String[] args) {
	    String string = "hello";
	    String rotatedString = "llohe";
	    StringRotation sr = new StringRotation();
	    System.out.println(sr.rotated(string, rotatedString));
	}
	
	/**
	 * Complexity O(n)
	 * http://phoxis.org/2013/05/24/check-if-a-string-is-rotation-of-another/
	 * @param string
	 * @param rotatedString
	 * @return
	 */
	public int rotated(String string, String rotatedString) {
		
		// if the lengths do not match, not a rotation
		if (string.length() != rotatedString.length()) {
			return -1;
		}
				
		String concatenatedStr = rotatedString + rotatedString;
		
		if(concatenatedStr.indexOf(string) != -1){
		   return 	concatenatedStr.indexOf(string);
		}
		
		return -1;
	}
	
	/**
	 * Complexity O(n^2)
	 * @param string
	 * @param rotatedString
	 * @return
	 */
	public int isRotated(String string, String rotatedString) {

		int result = 0;

		// if the lengths do not match, not a rotation
		if (string.length() != rotatedString.length()) {
			return -1;
		}

		int n = string.length();

		int flag = 0;

		// all possible rotations starting at k
		for (int k = 0; k < n; k++) {

			for (int i = 0; i < n; i++) {

				if (string.charAt(i) != rotatedString.charAt((i + k) % n)) {
					flag = 1;
					break;
				}
				//reset flag
				flag = 0;
			}

			if (flag == 0) {
				result = k;
			}

		}
		return result;
	}

}
