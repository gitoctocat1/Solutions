
public class ReverseString {
	
	public static void main(String[] args) {
		
	}

	/**
	 * Complexity O (n)
	 * @param str
	 * @return
	 */
	public String reverse(String str){
		
		String result = null;
		
		int i = 0 ; int j = str.length()-1;
		
		char[] charArray = str.toCharArray();
		
		while (i < j){
			
			//swap 
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
			
			i++; j --;
		}
		result = new String(charArray);
		
		return result;
		
	}
}
