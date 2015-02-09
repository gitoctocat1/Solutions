
public class SearchRotatedSortedArray {
	
	
	public static void main(String[] args) {
		int[]A = new int[]{1,3};
		System.out.println(search(A, 1));
		
	}
	  public static int search(int[] A, int target) {
	        
	        if(A.length == 0){
	            return -1;
	        }
	        
	        int left = 0;
	        int right = A.length -1 ;
	        
	        
	        
	        
	        while(left != right){
	        	
	        	int mid = right + (left -right)/2 ;
	           
	           if(A[mid] == target){
	               return mid;
	           }
	           
	           if(A[left]<= A[mid]){
	               
	               if(A[left]<= target && target < A[mid]){
	                   right = mid -1;
	               } else {
	                   left = mid + 1;
	                   
	               }
	           } else
	              if(A[right] >=target && target >A[mid]){
	                  left = mid + 1;
	              }  else {
	                  right = mid -1;
	              }
	           }
	           
	           return -1;
	        }
}
