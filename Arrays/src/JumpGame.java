
public class JumpGame {
	
	/**
	 * Complexity O(n)
	 * @param A
	 * @return
	 */
	 public boolean canJump(int[] A) {
	        
	        int end = A.length -1 ;
	        
	        //remember max tracks the index
	        int max = 0;
	        
	        for(int i = 0 ; i < A.length ; i++ ){
	            
	            if( i <= max){
	               max = Math.max (max , A[i] + i);
	            }
	             
	             if ( max >= end){
	                 return true;
	             }
	             
	             
	        }
	        
	        return false;
	    }

}
