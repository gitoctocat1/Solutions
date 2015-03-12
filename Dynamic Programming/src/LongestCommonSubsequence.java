
public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		LongestCommonSubsequence l = new LongestCommonSubsequence();
		String X = "AGGTAB" ;
		String Y = "GXTXAYB";
		int m = X.length();
		int n = Y.length();
		l.LCS(X, Y, m, n);
	}
	
	/**
	 * Complexity O(m*n) used memoization
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	public int LCS(String X, String Y,int m, int n){
		
		//LCS of "AGGTAB" and "GXTXAYB"
		
		   int[][] L = new int[m+1][n+1];
		   int i, j;
		  
		   /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
		      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
		   for (i=0; i<=m; i++)
		   {
		     for (j=0; j<=n; j++)
		     {
		       if (i == 0 || j == 0)
		         L[i][j] = 0;
		  
		       else if (X.charAt(i-1) == Y.charAt(j-1))
		         L[i][j] = L[i-1][j-1] + 1;
		  
		       else
		         L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
		     }
		   }
		   
		   printLCS(L,X,Y, m , n);
		    
		   /* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
		   return L[m][n];
		
	}

	private void printLCS(int[][] L,String X, String Y, int m, int n) {
		
		 int index = L[m][n];
		 
		 char[] LCS = new char[index];
		// Start from the right-most-bottom-most corner and
		   // one by one store characters in lcs[]
		   int i = m, j = n;
		   while (i > 0 && j > 0)
		   {
		      // If current character in X[] and Y are same, then
		      // current character is part of LCS
		      if (X.charAt(i-1) == Y.charAt(j-1))
		      {
		          LCS[index-1] = X.charAt(i-1); // Put current character in result
		          i--; j--; index--;     // reduce values of i, j and index
		      }
		 
		      // If not same, then find the larger of two and
		      // go in the direction of larger value
		      else if (L[i-1][j] > L[i][j-1])
		         i--;
		      else
		         j--;
		   }
		   System.out.println(LCS);
		
	}

}
