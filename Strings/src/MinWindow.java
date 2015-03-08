
public class MinWindow {
	
	
	   public static void main(String[] args) {
		String S = "acbbaca";
		String T = "aba";
		
		String S1= "ADOBECODEBANC";
		String T1="ABC";
		
		MinWindow mws = new MinWindow();
		System.out.println(mws.minWindow(S1, T1));
	}
	
	   /**
	    * Complexity O(n)
	    * @param S
	    * @param T
	    * @return
	    */
	    public String minWindow(String S, String T) {
	        int[] needToFind = new int[256];
	        int[] hasFound = new int[256];
	        for (int i = 0; i < T.length(); i++)
	            needToFind[T.charAt(i)]++;
	         
	        String result = "";
	        int min = Integer.MAX_VALUE;
	        int left = 0;
	        int count = 0;
	        for (int i = 0; i < S.length(); i++) {
	            char c = S.charAt(i);
	            
	            //skip characters not in T
	            if (needToFind[c] == 0)
	                continue;
	             
	            hasFound[c]++;
	            
	            
	            if (hasFound[c] <= needToFind[c])
	                count++;
	             
	            //if window constraint is satisfied
	            if (count == T.length()) {
	            	
	                while (needToFind[S.charAt(left)] == 0 || hasFound[S.charAt(left)] > needToFind[S.charAt(left)]) {
	                	
	                	//do not break window constraint
	                    if (hasFound[S.charAt(left)] > needToFind[S.charAt(left)]){
	                        hasFound[S.charAt(left)]--;
	                    }    
	                    left++;
	                }
	                
	                //update the minimum window 
	                if (i-left+1 < min) {
	                    min = i-left+1;
	                    result = S.substring(left,i+1);
	                }
	            }
	        }
	        return result;
	    }
	

}
