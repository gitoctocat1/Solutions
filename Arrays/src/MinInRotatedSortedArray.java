
public class MinInRotatedSortedArray {

	/**
	 * Complexity O(n)
	 * e.g 456712 condition A[i-1] > A[i]
	 * @param num
	 * @return
	 */
    public int findMin(int[] num) {
        
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
