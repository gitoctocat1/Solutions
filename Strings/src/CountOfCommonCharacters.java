import java.util.HashSet;
import java.util.Set;

public class CountOfCommonCharacters {

    public static void main(String[] args) {

        String[] words = {"aghkafgklt", "dfghako", "qwemnaarkf"};
         
        CountOfCommonCharacters cc = new CountOfCommonCharacters();
        cc.getCommonCharactersCount(words);
        
    }
    
    /**
     * Complexity O(m * n) where n = length of words array and m = avg length of each string
     * Space complexity 256
     * @param words
     * @return
     */
    public int getCommonCharactersCount (String[] words){
    	
    	if(words== null || words.length == 0){
    	  return -1;	
    	}
    	
    
    	//create an int array to hold # times character appears 
		int[] charCounts = new int[256];
		for(String word : words) {
			
			Set<Character> uniqueCharSet = new HashSet<Character>();
			
			for(int i=0; i < word.length(); i++) {
				
				char ch = word.charAt(i);
				
				//avoid adding duplicate char counts
				if (!uniqueCharSet.contains(ch)) {
					uniqueCharSet.add(ch);
					charCounts[(int) ch] ++;
				}
			}	
		}
	
		int commonCharCount = 0;
		
		for (int i=0; i < 256; i++) {
			
			//if the char has appeared in all words, increment common character count
			if (charCounts[i] == words.length) {
				
			  System.out.println(Character.valueOf((char) i));
			  commonCharCount++;
			}
		}
		
		return commonCharCount;
    	
    }

}
