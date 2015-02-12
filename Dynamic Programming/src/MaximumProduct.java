
public class MaximumProduct {

	/**
	 * Time Complexity O(n) space O(n)
	 * @param A
	 * @return
	 */
	  public int maxProduct(int[] A) {
	        
	        int[] minProduct = new int[A.length]; 
	        int[] maxProduct = new int[A.length];
	        
	        minProduct[0]= A[0];
	        maxProduct[0]= A[0];
	        
	        int product = A[0];
	        
	        
	        for(int i= 1; i < A.length; i++){
	            
	            //compare n with product of n-1 elements
	        
	            minProduct[i] = Math.min (A[i], Math.min(maxProduct[i-1]*A[i],minProduct[i-1]*A[i]));
	            
	            maxProduct[i] = Math.max (A[i], Math.max(maxProduct[i-1] *A[i], minProduct[i-1]*A[i]));
	            
	            product = Math.max(product,maxProduct[i]);
	            
	        }
	        
	        return product;
	        
	    }
}
