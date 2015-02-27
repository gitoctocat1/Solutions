
public class OneEditDistance {
	
	
	
	public static void main(String[] args) {
		
		OneEditDistance oed = new OneEditDistance();
		String s = "ABC";
		String t = "ABCD";
		boolean result = oed.isOneEditDistance(s, t);
	}
	
	
	/**
	 * Complexity O(n)
	 * Traverse both the strings until all characters match
	 * Case 1) |n -m| > 1  return false
	 * Case 2) m <= n  
	 * i) Insert  S = ABC  T =ABXCD
	 * ii) Append S = ABC  T = ABCD
	 * iii)Modify S = ABC T = ABA
	 * Case 3) m > n Swap m and n
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isOneEditDistance(String s, String t) {
		
		   int m = s.length();
		   int n = t.length();
		   
		   if (m > n) {
			   return isOneEditDistance(t, s);
		   }
		   
		   //if the difference in length of two strings > 1, it cant be one edit distance away
		   if (n - m > 1) {
			   return false;
		   }
		   
		   int i = 0, shift = n - m;
		   
		   while (i < m && s.charAt(i) == t.charAt(i)) {
			   i++;
		   }
		   
		   //append operation
		   if (i == m ) {
			   return shift > 0;
		   } 
		   
		   //modify operation
		   if (shift == 0){
			   i++;
		   }
		   
		   //insert operation
		   while (i < m && s.charAt(i) == t.charAt(i + shift)){
			   i++;
		   }
		   return i == m;
		}

}
