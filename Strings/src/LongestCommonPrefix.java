public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] strs = new String[4];
		String str1 = "bcd";
		String str2 = "bc";
		String str3 = "bcde";
		String str4 = "bbe";
		strs[0] = str1;
		strs[1] = str2;
		strs[2] = str3;
		strs[3] = str4;

		System.out.println("LCP "+longestCommonPrefix(strs));

	}

	/**
	 * Complexity O(n ^2) assuming n strings each of length n
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {

		  
        if(strs == null || strs.length == 0){
            return "";
        }
        
       if(strs.length == 1){
           return strs[0];
       }
        
        StringBuilder result = new StringBuilder();
        
        
        for(int i = 0; i < strs[0].length() ; i++){
            
             boolean matched = false;
            
          for (int j = 1; j < strs.length ; j ++){
              
              if(strs[j].length() > i && strs[0].charAt(i) == strs[j].charAt(i)){
                 matched = true;
                  
              } else {
                  matched = false;
                  break;
              }
          }
          
          if(matched){
                result.append(strs[0].charAt(i));
          } else {
              return result.toString();
          }
            
        }
         return result.toString();

	}
}
