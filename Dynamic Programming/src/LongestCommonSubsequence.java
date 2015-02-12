
public class LongestCommonSubsequence {
	
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
		    
		   /* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
		   return L[m][n];
		
	}

}
