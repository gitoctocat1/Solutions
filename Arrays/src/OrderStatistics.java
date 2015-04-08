
public class OrderStatistics {
	
	
	/**
	 * Complexity O(n)
	 * you choose a pivot element, and then move all elements less than the pivot element to 
	 * the left and all elements that are larger than the pivot element to the right.
	 *  After this operation the pivot element is on the right spot and if the k you're 
	 *  looking for equals to the pivot's index, you don't have to sort anymore and just
	 *   return the pivot.
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public static int partition(int[] array, int start, int end) {
		
	    int pivot = array[start];
	    int pivotPosition = start++;
	    while (start <= end) {
	        // scan for values less than the pivot
	        while ((start <= end) && (array[start] < pivot)) {
	            start++;
	        }
	 
	        // scan for values greater than the pivot
	        while ((end >= start) && (array[end] >= pivot)) {
	            end--;
	        }
	 
	        if (start > end) {
	            // swap the last uncoformed 
	            // element with the pivot
	            swap(array, pivotPosition, end); 
	        }
	        else {
	            // swap unconformed elements:
	            // first that was not lesser than the pivot 
	            // and last that was not larger than the pivot
	            swap(array, start, end);
	        }
	    }
	    return end;
	}
	 
	private static int orderStatistic(
	        int[] array, int k, int first, int last) {
	            
	    int pivotPosition = partition(array, first, last);
	    if ( pivotPosition == k - 1) {
	        return array[k - 1];
	    }
	    if (k - 1 < pivotPosition ) {
	        return orderStatistic(array, k, first, pivotPosition - 1);
	    }
	    else {
	        return orderStatistic(array, k, pivotPosition + 1, last);
	    }
	}
	 
	
	 
	public static int kthSmallest(int[] array, int k) {
	    return orderStatistic(
	        array, k, 0, array.length - 1);
	}
	 
	public static int kthLargest(int[] array, int k) {
	    return orderStatistic(
	        array, array.length - k + 1, 0, array.length - 1);
	}
	
	
	public static void swap (int[] array, int index1, int index2){
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
	}
	
	// iterative version
		private static int orderStatisticIterative(
		        int[] array, int k, int first, int last) {
		 
		    int pivotPosition = partition(array, first, last);
		 
		    while (pivotPosition != k - 1) {
		        if (k - 1 < pivotPosition) {
		            last = pivotPosition - 1;
		        }
		        else {
		            first = pivotPosition + 1;
		        }
		        
		        pivotPosition = partition(array, first, last);
		    }
		    
		    return array[k - 1];
		}

}
