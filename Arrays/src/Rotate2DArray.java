
public class Rotate2DArray {
	
	
	/**
	 * Complexity O(n ^ 2) and extra space
	 * @param matrix
	 */
	    public void rotate(int[][] matrix) {
	        if(matrix == null || matrix.length==0)
	            return ;
	 
	        int n = matrix.length;
	 
	        int[][] result = new int[n][n];
	        
	        
	        for (int i = 0; i < n; ++i) {
	            for (int j = 0; j < n; ++j) {
	            	result[i][j] = matrix[n - j - 1][i];
	            }
	        }
	    }
	    
	    /**
	     * Complexity O(n ^ 2) In place
	     * 
	     * [0,i] -> [i,n-i], 
	     * [i,n-i] -> [n-1,n-(i+1)],
	     *  [n-1,n-(i+1)] -> [n-(i+1),0], 
	     *  and [n-(i+1),0] to [0,i]
	     * @param matrix
	     */
	    public void rotateWithoutExtraSpace(int[][] matrix) {
	        int size = matrix.length;
	        for (int i=0; i<size/2; i++) {
	            for (int j=0; j<(size+1)/2; j++) {
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[size-1-j][i];
	                matrix[size-1-j][i] = matrix[size-1-i][size-1-j];
	                matrix[size-1-i][size-1-j] = matrix[j][size-1-i];
	                matrix[j][size-1-i] = temp;
	            }
	        }
	    }
	

}
