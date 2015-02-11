
public class LongestPalindromicSubstring {
	
	 /**
	  * Complexity O(n*n) and space O(1)
	  * @param s
	  * @return
	  */
    public String longestPalindrome(String s) {
        
        String longest = "";
        
        if(s == null || s.isEmpty()){
            return longest;
        }
        
        if(s.length()==1){
            return s;
             
        }
        
        for(int i = 0; i < s.length() ; i++){
            
        	// Eg. abbxbba
            String str1 = helper(s,i,i);
            
           // Eg. abba
            String str2 = helper(s,i, i+1);
            
            if(str1.length() > str2.length()){
                
                if(str1.length() > longest.length()){
                   longest = str1;
                }   
            
            } else {
                
                 if(str2.length() > longest.length()){
                   longest = str2;
                 }
            }
        }
        return longest;
    }
    
    
    // Returns the longest palindrome centered at i,j
 	// Note i can be equal to j Eg. abbxbba
 	// i != j Eg. abba
    public String helper(String s, int i, int j){
        
        while(i>= 0 && j <= s.length()-1 && s.charAt(i)== s.charAt(j)){
            i--;
            j++;
        }
        /*
		 * Note the substring function includes start index and excludes end
		 * index
		 * 
		 * "helo".substring(1, 2) = e "helo".substring(1, 3) = el
		 * "civic".substring(0, 5) = civic
		 */
        return s.substring(i+1, j);
    }
}
