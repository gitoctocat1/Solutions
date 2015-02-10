
public class Search2DMatrix {
	
	/**
	 * O(lg (mn)) 
	 * Use binary search since the matrix is equivalent to sorted array
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        
	      
        if(matrix==null || matrix.length==0 || matrix[0].length==0) 
            return false;
 
        //no of rows
        int m = matrix.length;
        
        //no of columns
        int n = matrix[0].length;
 
        int start = 0;
        int end = m*n-1;
 
        while(start<=end){
        	
            int mid=(start+end)/2;
            
            //get the row using div 
            int midX=mid/n;
            
            //get the column using mod
            int midY=mid%n;
 
            if(matrix[midX][midY]==target) 
                return true;
 
            if(matrix[midX][midY]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
 
        return false;
    }

}
