
public class MinInRotatedSortedArray {

    /**
     * Complexity O(lg n) using modified binary search
     * @param num
     * @return
     */
    public int findMin(int[] num) {
    	return findMin(num, 0, num.length - 1);
    }
     
    public int findMin(int[] num, int start, int end) {
    	if (start == end)
    		return num[start];
    	if ((end - start) == 1)
    		return Math.min(num[start], num[end]);
     
    	int middle = start + (end - start) / 2;
     
    	// not rotated
    	if (num[start] < num[end]) {
    		return num[start];
     
    	// go right side
    	} else if (num[middle] > num[start]) {
    		return findMin(num, middle, end);
     
    	// go left side
    	} else {
    		return findMin(num, start, middle);
    	}
    }
    
    
    /**
	 * Complexity O(n)
	 * e.g 456712 condition A[i-1] > A[i]
	 * @param num
	 * @return
	 */
    public int findMinOld(int[] num) {
        
        int min = num[0];
        
         for (int i= 1; i < num.length ; i++){
        	 //check if previous element is greater
            if(num[i-1] > num[i] ){
                min =  num[i];
                break;
            } 
         }  
       
       return min;
    }
}
